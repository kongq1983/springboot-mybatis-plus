package com.kq.tool.encrpt;

/**
 * https://www.yuque.com/weihouqin5.0/hgtwkp/gdbg0w
 * @author kq
 * @date 2022-06-27 15:58
 * @since 2020-0630
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class MHDemo {
    //开发环境接入参数(▲由易通云提供)
    public static String app_baseUrl = "***";//接口根路径
    public static String app_id = "***";//服务商ID（按服务商分配）
    public static String app_secret = "***";//服务商密钥（按服务商分配）
    public static String uni_id = "***";////客户ID（按客户分配）
    public static String api_secret = "***";//客户密钥（按客户分配）

    //拼接出完整地址
    public static String req_url = app_baseUrl+"/"+uni_id+"/"+app_id;

    public static void main(String[] args) {
        Demo();
    }

    public static void Demo(){
//        //公共数据区
//        String method = "open.common.hello";//函数名
//        String nonce_str = "abcd1234";//8位长度随机字符串
//        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//10位长度当前unix时间戳
//        String app_mode = "2";//服务商模式，普通服务商固定传2
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("method", method);
//        map.put("nonce_str", nonce_str);
//        map.put("timestamp", timestamp);
//        map.put("app_mode", app_mode);
//
//        //业务数据区
//        Map<String, String> mapData = new HashMap<String, String>();
//        mapData.put("hello", "hello world!");
//        //Map 转成  JSONObject 字符串
//        JSONObject jsonObj=new JSONObject(mapData);
//        String data = jsonObj.toString();//进行json_encode
//        map.put("data", data);
//
//        //请求数据项签名值
//        String sign = maihu_sign(map);
//        map.put("sign", sign);
//
//        //发起post请求
//        String response = maihu_http_post_json((new JSONObject(map)).toString());
//        System.out.println(response);
    }

    //自定义签名函数
    public static String maihu_sign(Map<String, String> map){
        //step1-所有一级参数项（不含sign）字典序排序、去除空值项、&符号拼接，得到stringA
        //stringA示例数据：app_mode=2&data="{\"hello\": \"hello world!\"}"&method=open.common.hello...
        String[] keyArray;
        StringBuilder sb = new StringBuilder();
        try {
            //字典序排序
            keyArray = SortDictionary(map);
            if(keyArray.length>0){
                for (String k : keyArray) {
                    if (map.get(k).trim().length() > 0) // 参数值为空，则不参与签名
                        sb.append(k).append("=").append(map.get(k).trim()).append("&");
                }
            }
            //step2-将step1得到的stringA拼接服务商密钥及客户密钥，然后进行md5并转换成大写得到签名 此处注意字符串末尾带有&
            String stringA = sb.toString() + "app_secret=" + app_secret + "&api_secret=" + api_secret;
            try {
                return MD5(stringA);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } catch (Exception e1) {
            //e1.printStackTrace();
            return "";
        }
    }

    //自定义字典序排序函数
    public static String[] SortDictionary(Map<String, String> data) throws Exception {
        Set<String> keySet = data.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        return keyArray;
    }

    //自定义MD5函数
    public static String MD5(String data) throws Exception {
        java.security.MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
        }
        //md5后字母转大写
        return sb.toString().toUpperCase();
    }

    //自定义http接口请求函数
    public static String maihu_http_post_json(String strParms){
        StringBuffer sb=new StringBuffer();
        try {
            // 创建url资源
            URL url = new URL(req_url);
            // 建立http连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置允许输出
            conn.setDoOutput(true);
            // 设置允许输入
            conn.setDoInput(true);
            // 设置不用缓存
            conn.setUseCaches(false);
            // 设置传递方式
            conn.setRequestMethod("POST");
            // 设置维持长连接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 转换为字节数组
            byte[] data = (strParms.toString()).getBytes("UTF-8");
            // 设置文件长度
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            // 设置文件类型:
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            // 开始连接请求
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream()) ;
            // 写入请求的字符串
            out.write((strParms.toString()).getBytes("UTF-8"));
            out.flush();
            out.close();
            // 请求返回的状态
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                System.out.println("连接成功");
                // 请求返回的数据
                InputStream in1 = conn.getInputStream();
                try {
                    String readLine=new String();
                    BufferedReader responseReader=new BufferedReader(new InputStreamReader(in1,"UTF-8"));
                    while((readLine=responseReader.readLine())!=null){
                        sb.append(readLine).append("\n");
                    }
                    responseReader.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {
                System.out.println("error++");
            }
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return sb.toString();
    }
}