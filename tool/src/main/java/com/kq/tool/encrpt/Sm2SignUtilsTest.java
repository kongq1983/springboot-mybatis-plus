package com.kq.tool.encrpt;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

/**
 * @author kq
 * @date 2022-07-29 8:33
 * @since 2020-0630
 */
public class Sm2SignUtilsTest {

    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String MSG = "msg";

    public static final String CLIENT_PUBLIC_KEY = "02787e3e506758f08d992fbd7e10d2d3ece19e2f572957b66424c1899c573335c4";
    public static final String CLIENT_PRIVATE_KEY = "00c8a2a8c126ad362d8e369cca339d112e5c236dc947cae229eb4c8518afcff784";


    public static final String SERVER_PUBLIC_KEY = "026286478cdfc084a47c1aa3f69c16fc978c7ad8b6ceb815b279ad74d26c878566";
    public static final String SERVER_PRIVATE_KEY = "0b71b2dfb120b7ce2b4c12c657e6d1334e4dc0f5123cfdb7efc56fc3542e4982";

    // client
//    privateKeyHex=  00c8a2a8c126ad362d8e369cca339d112e5c236dc947cae229eb4c8518afcff784
//      publicKeyHex=   02787e3e506758f08d992fbd7e10d2d3ece19e2f572957b66424c1899c573335c4

    // server
//     privateKeyHex=   0b71b2dfb120b7ce2b4c12c657e6d1334e4dc0f5123cfdb7efc56fc3542e4982
//    publicKeyHex=     026286478cdfc084a47c1aa3f69c16fc978c7ad8b6ceb815b279ad74d26c878566

    public static void main(String[] args) throws Exception{

        // 生成公钥 私钥
//        SmServerSignUtils.generatorKey();

        // 校验客户端提交数据
        clientToServerChcek();

        // 校验服务器响应
        serverToClientResponseCheck();

    }


    /**
     * 客户端发往服务器
     * @throws Exception
     */
    private static void clientToServerChcek() throws Exception{

        try(InputStream inputStream = Sm2SignUtilsTest.class.getResourceAsStream("/product_plan.json")) {
            String content = IOUtils.toString(inputStream);
//            System.out.println("content="+content);

            JSONObject data = JSONObject.parseObject(content);

            System.out.println("data="+data);

            JSONObject dataAddSign = Sm2SignUtils.clientSubmitSign(data,SERVER_PUBLIC_KEY,CLIENT_PRIVATE_KEY);
            System.out.println("dataAddSign="+dataAddSign);

            // 故意加上 ，校验不通过
//            dataAddSign.put("one","1");

            JSONObject dataServer = Sm2SignUtils.serverVerifyClientSubmitSign(dataAddSign,CLIENT_PUBLIC_KEY,SERVER_PRIVATE_KEY);
            System.out.println("dataServer="+dataServer);

        }
    }

    public static void serverToClientResponseCheck() throws Exception{


        JSONObject obj = new JSONObject();
        obj.put("id",100);
        obj.put("name","hello");

        JSONObject data = writeSuccess(obj);

        data = Sm2SignUtils.serverResponseSign(data,CLIENT_PUBLIC_KEY,SERVER_PRIVATE_KEY);

        System.out.println("服务器响应数据 data="+data);

        JSONObject result = Sm2SignUtils.clientVerifyServerResponseSign(data,CLIENT_PRIVATE_KEY,SERVER_PUBLIC_KEY);

        System.out.println("result="+result);


    }

    public static void writeFail(JSONObject result,String message){
        result.put(CODE,-1);
        result.put(MSG,message);
        result.put(DATA,null);
    }

    public static JSONObject writeSuccess(Object object){
        JSONObject result = new JSONObject();
        result.put(CODE, 200);
        result.put(MSG,"success");
        result.put(DATA,object);

        return result;
    }

}
