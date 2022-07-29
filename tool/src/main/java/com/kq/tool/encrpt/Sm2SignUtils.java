package com.kq.tool.encrpt;

import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.BCUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.SM2;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 *     * 请求:
*      * 客户端提交加密 -> 服务端校验
*      * clientSign -> serverVerifyClientSubmitSign
*      *
*      * 响应:
*      * 服务端加密 -> 客户端校验
*      * serverResponseSign -> clientVerifyServerResponseSign
 *
 * @author kq
 * @date 2022-07-28 19:11
 * @since
 */
public class Sm2SignUtils {

    public static final String CODE = "code";
    public static final String DATA = "data";
    public static final String MSG = "msg";

    public static final String PRIVATE_KEY = "privateKey";
    public static final String PUBLIC_KEY = "publicKey";


    /**
     *
     * 请求:
     * 客户端提交加密 -> 服务端校验
     * clientSign -> serverVerifyClientSubmitSign
     *
     * 响应:
     * 服务端加密 -> 客户端校验
     * serverResponseSign -> clientVerifyServerResponseSign
     *
     * sign (客户端公钥加密-客户端私钥验签)
     * 字段加密(服务器公钥加密 - 服务器私钥解密)
     * @param data
     * @return
     */
    public JSONObject sign(JSONObject data) {

        String clientPublicKey = "";
        String servicePrivateKey = "";
        JSONObject jsonObject = Sm2SignUtils.clientSubmitSign(data, clientPublicKey, servicePrivateKey);
        return jsonObject;
    }


    /**
     * 终端参数发往服务端时的加密加签操作
     *
     * @param data 终端参数列表
     * @return 处理完成的参数，JSON格式
     */
    public static JSONObject clientSubmitSign(JSONObject data, String serverPublicKey, String clientPrivateKey) {
        // 打印参数
        // Map<String, Object> clientMap = data.toJavaObject(HashMap.class);
        Map<String, Object> clientMap = JSONObject.parseObject(data.toJSONString(), new TypeReference<Map<String, Object>>(){});
        printMap(clientMap);
        // SM2对参数加密
        clientMap = encrypt(clientMap,serverPublicKey);
        // 参数排序转字符串
        String clientStr = buildSignStr(clientMap);
        //固定顺序
//        String clientStr=CODE+"="+clientMap.get(CODE)+"&"+MESSAGE+"="+clientMap.get(MESSAGE)+"&"+DATA+"="+clientMap.get(DATA);
        // SM2加签
        SM2 csm2 = new SM2(clientPrivateKey, null);
        csm2.usePlainEncoding();
        String sign = HexUtil.encodeHexStr(csm2.sign(clientStr.getBytes(StandardCharsets.UTF_8)));
        clientMap.put("sign", sign);
        JSONObject jsonObject = new JSONObject(clientMap);
        return jsonObject;
    }


    /**
     * 服务端验证sign
     * @param data
     * @param clientPublicKey
     * @param servicePrivateKey
     * @return
     */
    public static JSONObject serverVerifyClientSubmitSign(JSONObject data,String clientPublicKey,String servicePrivateKey) {
        // Map<String, Object> serviceMap = data.toJavaObject(HashMap.class);
        Map<String, Object> serviceMap = JSONObject.parseObject(data.toJSONString(), new TypeReference<Map<String, Object>>(){});
        // 获取签名
        String serviceSign = (String) serviceMap.get("sign");
        serviceMap.remove("sign");
        // 参数排序转字符串
        String serviceStr = buildSignStr(serviceMap);
        // 验签
        SM2 ssm2 = new SM2(null, clientPublicKey);
        ssm2.usePlainEncoding();
//        log.info("服务端验证字符串:{}",serviceStr);
//        log.info("服务端验证字符串:{}",serviceStr);
        System.out.println("服务端验证字符串:{}"+serviceStr);
        System.out.println("服务端验证公钥:{}"+clientPublicKey);
        boolean verify = ssm2.verify(serviceStr.getBytes(StandardCharsets.UTF_8), HexUtil.decodeHex(serviceSign));
//        log.info("服务端易通云签名:{}",serviceSign);
        System.out.println("服务端接收签名:{}"+serviceSign);

        System.out.println("verify="+verify);

        if(!verify) {
            throw new RuntimeException("校验不通过");
        }

        // SM2对参数解密
        serviceMap = decrypt(serviceMap,servicePrivateKey);
        // 打印参数
        printMap(serviceMap);
        JSONObject jsonObject = new JSONObject(serviceMap);
        return jsonObject;
    }

    /**
     * 字典排序拼接
     *
     * @param params
     * @return
     */
    private static String buildSignStr(Map<String, Object> params) {
        if (null == params || params.size() == 0) {
            return null;
        }
        // 将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<>(params);
        Set<Map.Entry<String, Object>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接"key=value"格式，值为null的字段不拼接
        StringBuilder baseString = new StringBuilder();
        for (Map.Entry<String, Object> entry : entrys) {
            if (null != entry.getValue()) {
                baseString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        baseString.deleteCharAt(baseString.length() - 1);
        return baseString.toString();
    }

    private static void printMap(Map<String, Object> params) {
        String  paramStr="";
        for(String key : params.keySet()){
            paramStr+=key+":"+params.get(key)+" ";
        }
        System.out.println("服务端接受数据:{}"+paramStr);
    }

    /**
     * 解密
     *
     * @param params
     * @return
     */
    private static Map<String, Object> decrypt(Map<String, Object> params,String servicePrivateKey) {
        // SM2服务端私钥解密
        SM2 ssm2 = new SM2(servicePrivateKey, null);

        for (String key : params.keySet()) {
//            if (ConstantsList.paramsList.contains(key)) {
//                params.put(key, ssm2.decryptStr(String.valueOf(params.get(key)), KeyType.PrivateKey));
//            }
        }
        return params;
    }

    public static JSONObject generatorKey(){
        // 客户端创建公私钥对
        JSONObject jsonObject=new JSONObject();
        KeyPair cPair = SecureUtil.generateKeyPair("SM2");
        String  privateKeyHex = HexUtil.encodeHexStr(BCUtil.encodeECPrivateKey(cPair.getPrivate()));
        String  publicKeyHex = HexUtil.encodeHexStr(BCUtil.encodeECPublicKey(cPair.getPublic()));
        System.out.println("privateKeyHex="+privateKeyHex);
        System.out.println("publicKeyHex="+publicKeyHex);
        jsonObject.put(PRIVATE_KEY,privateKeyHex);
        jsonObject.put(PUBLIC_KEY,publicKeyHex);
        return jsonObject;
    }

    // 加密参数
    private static Map<String, Object> encrypt(Map<String, Object> params,String cilentPublicKey) {
        // SM2服务端公钥加密
        SM2 ssm2 = new SM2(null, cilentPublicKey);
        for (String key : params.keySet()) {
//            if (ConstantsList.paramsList.contains(key)) {
//                params.put(key, ssm2.encryptHex(String.valueOf(params.get(key)), KeyType.PublicKey));
//            }
        }
        return params;
    }


    /**
     * 服务器响应签名
     * 目标校验方法: clientVerifyServerResponseSign
     * @param data
     * @param clientPublicKey
     * @param servicePrivateKey
     * @return
     */
    public static JSONObject serverResponseSign(JSONObject data,String clientPublicKey,String servicePrivateKey) {
        // 打印参数
        // Map<String, Object> clientMap = data.toJavaObject(HashMap.class);
        Map<String, Object> clientMap = JSONObject.parseObject(data.toJSONString(), new TypeReference<Map<String, Object>>(){});
        printMap(clientMap);
        // SM2对参数加密
        clientMap = encrypt(clientMap,clientPublicKey);
        // 参数排序转字符串
        //String clientStr = buildSignStr(clientMap);
        //固定顺序
        String clientStr=CODE+"="+clientMap.get(CODE)+"&"+MSG+"="+clientMap.get(MSG)+"&"+DATA+"="+clientMap.get(DATA);
        // SM2加签
        SM2 csm2 = new SM2(servicePrivateKey, null);
        csm2.usePlainEncoding();
        String sign = HexUtil.encodeHexStr(csm2.sign(clientStr.getBytes(StandardCharsets.UTF_8)));
        clientMap.put("sign", sign);
        JSONObject jsonObject = new JSONObject(clientMap);

        return jsonObject;
    }


    /**
     * 来源方法 serverResponseSign
     * 服务端验证sign
     * @param data
     * @param clientPrivateKey
     * @param servicePublicKey
     * @return
     */
    public static JSONObject clientVerifyServerResponseSign(JSONObject data,String clientPrivateKey,String servicePublicKey) {
        // Map<String, Object> serviceMap = data.toJavaObject(HashMap.class);
        Map<String, Object> serviceMap = JSONObject.parseObject(data.toJSONString(), new TypeReference<Map<String, Object>>(){});
        // 获取签名
        String serviceSign = (String) serviceMap.get("sign");
        serviceMap.remove("sign");
        // 参数排序转字符串
        String serviceStr = CODE+"="+serviceMap.get(CODE)+"&"+MSG+"="+serviceMap.get(MSG)+"&"+DATA+"="+serviceMap.get(DATA);
        // 验签
        SM2 ssm2 = new SM2(null, servicePublicKey);
        ssm2.usePlainEncoding();
//        log.info("服务端验证字符串:{}",serviceStr);
//        log.info("服务端验证字符串:{}",serviceStr);
        System.out.println("服务端验证字符串:{}"+serviceStr);
        System.out.println("服务端验证公钥:{}"+servicePublicKey);
        boolean verify = ssm2.verify(serviceStr.getBytes(StandardCharsets.UTF_8), HexUtil.decodeHex(serviceSign));

        if(!verify) {
            throw new RuntimeException("校验不通过");
        }

        // SM2对参数解密
        serviceMap = decrypt(serviceMap,clientPrivateKey);
        // 打印参数
        printMap(serviceMap);
        JSONObject jsonObject = new JSONObject(serviceMap);
        return jsonObject;
    }

}
