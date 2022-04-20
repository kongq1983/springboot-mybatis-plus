package com.kq.pattern;

/**
 * @author kq
 * @date 2022-04-20 14:18
 * @since 2020-0630
 */
public class EmailTest {

//    EMAIL("email","电子邮箱","(\\w+)\\w{5}@(\\w+)", "$1***@$2"),

//    public static final String EMAIL_REGEX = "(\\w+)\\w{5}@(\\w+)";
//    public static final String EMAIL_REGEX = "(\\w+)@(\\w+)(\\.[\\w-]+)";
    public static final String EMAIL_REGEX = "(\\w+)\\w{3}@(\\w+)(\\.[\\w-]+)";

    public static void main(String[] args) {

//        String email = "teest1@baomidou.com";
        String email = "teest1@baomidou.com";

        String replace = "$1***@$2";

        String result = email.replaceAll(EMAIL_REGEX, replace);


        System.out.println(email.matches(EMAIL_REGEX));
        System.out.println(result);
        System.out.println("test123456@163.com".replaceAll(EMAIL_REGEX, replace));
        System.out.println("test1@163.com".replaceAll(EMAIL_REGEX, replace));
        System.out.println("te@163.com".replaceAll(EMAIL_REGEX, replace));



    }

}
