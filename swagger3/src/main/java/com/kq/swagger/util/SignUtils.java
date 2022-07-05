package com.kq.swagger.util;


import org.apache.commons.lang3.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author kq
 * @date 2022-07-05 14:06
 * @since
 */
public class SignUtils {

    private static final String SALT = "zjZYzhgFyXgSZhjKcTK12ShiAnDuiJieSyKey";

    public String getTimestamp() {
        //生成时间戳
        long timestampLong =System.currentTimeMillis();
        String timestampStr = String.valueOf(timestampLong);
        return timestampStr;
    }



    public String getNonceStr(int length){

        //生成随机字符串

        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random=new Random();
        StringBuffer randomStr=new StringBuffer();
        // 设置生成字符串的长度，用于循环

        for(int i=0; i<length; ++i){
            //从62个的数字或字母中选择
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            randomStr.append(str.charAt(number));
        }

        //将承载的字符转换成字符串
        return randomStr.toString();
    }


    public static String createSign(Map<String, Object> params){
        return createSign(params,null);
    }


//    public static String createSign(String body) {
//
//    }


    /**
     * 生成签名
     * 不包括 :  sign
     * @param params
     * @param salt
     * @return
     */
    public static String createSign(Map<String, Object> params, String salt){
        StringBuilder sb = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<>(params);
        // 不包括key
        sortParams.remove("sign");

        // 遍历排序的字典,并拼接"key=value"格式
        for (Map.Entry<String, Object> entry : sortParams.entrySet()) {
            String key = entry.getKey();
            String value =  entry.getValue()==null?null:entry.getValue().toString();
            if (StringUtils.isNotBlank(value)) {
                sb.append("&").append(key).append("=").append(value);
            }
        }
        String stringA = sb.toString().replaceFirst("&","");

        // *************
        if(salt==null) {
            //私钥最后放在配置文件里面读取
            salt = SALT;
        }

        String stringSignTemp = stringA + "&"+"salt="+salt;
        //将签名使用MD5加密并全部字母变为大写
        String signValue = stringToMD5(stringSignTemp).toUpperCase();
        System.out.println("stringA+privateKey后MD5加密+转换全部大写生成sign为：       "+signValue);

        return signValue;
    }

    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;

        try{
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        }catch (Exception e) {
            e.printStackTrace();
            return plainText;
        }

        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }

        return md5code;
    }

    public static void main(String[] args) {
        System.out.println(stringToMD5("123456"));
        System.out.println(stringToMD5("abdabc"));

        Map<String,Object> params = new HashMap<>();
        params.put("id",100);
        params.put("name","guest");
        params.put("address","zj.hz");

        String createSign = createSign(params);

        System.out.println(createSign);


    }


}
