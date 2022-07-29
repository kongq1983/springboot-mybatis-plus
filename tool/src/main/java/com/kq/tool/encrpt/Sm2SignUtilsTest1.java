package com.kq.tool.encrpt;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

/**
 * @author kq
 * @date 2022-07-29 13:56
 * @since 2020-0630
 */
public class Sm2SignUtilsTest1 {

    public static void main(String[] args) throws Exception{
        clientToServerChcek();
    }


    private static void clientToServerChcek() throws Exception{

        try(InputStream inputStream = Sm2SignUtilsTest.class.getResourceAsStream("/product_sale_quantity.json")) {
            String content = IOUtils.toString(inputStream);
//            System.out.println("content="+content);

            JSONObject data = JSONObject.parseObject(content);

            System.out.println("data="+data);

            JSONObject dataAddSign = Sm2SignUtils.clientSubmitSign(data,Sm2SignUtilsTest.SERVER_PUBLIC_KEY,Sm2SignUtilsTest.CLIENT_PRIVATE_KEY);
            System.out.println("dataAddSign="+dataAddSign);

            // 故意加上 ，校验不通过
//            dataAddSign.put("one","1");

            JSONObject dataServer = Sm2SignUtils.serverVerifyClientSubmitSign(dataAddSign,Sm2SignUtilsTest.CLIENT_PUBLIC_KEY,Sm2SignUtilsTest.SERVER_PRIVATE_KEY);
            System.out.println("dataServer="+dataServer);

        }
    }

}
