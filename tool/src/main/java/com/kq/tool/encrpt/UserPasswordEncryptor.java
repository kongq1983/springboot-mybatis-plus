package com.kq.tool.encrpt;

import cn.hutool.crypto.SmUtil;

/**
 * @author kq
 * @date 2022-07-06 10:50
 * @since 2020-0630
 */
public class UserPasswordEncryptor {

    public static String encryptPwd(String accountNumber, String password) {
        return SmUtil.sm3(accountNumber + password);
    }

    public static void main(String[] args) {
        System.out.println(encryptPwd("100003","100003"));
        System.out.println(encryptPwd("100005","100005"));
        System.out.println(encryptPwd("330483199611140337","140337"));
        System.out.println(encryptPwd("330483199611140337","123456"));
        // 20a1ddb33e28b23a0cbddd315dacbe03ac3d9d68bd9ab00e14e29542377a217d
        System.out.println(encryptPwd("330483199611140337","310012"));
        System.out.println(encryptPwd("330411199804302222","310012"));
        System.out.println(encryptPwd("2022201003001","310012"));
        System.out.println(encryptPwd("2022201003001","003001"));
        System.out.println(encryptPwd("2207040000","040000"));
        System.out.println(encryptPwd("2207040000","310012"));
        System.out.println(encryptPwd("2207040000","123456"));
        System.out.println(encryptPwd("2207040000","123456"));
        System.out.println(encryptPwd("2207040000",""));
        System.out.println(encryptPwd("king","000000"));
    }

}
