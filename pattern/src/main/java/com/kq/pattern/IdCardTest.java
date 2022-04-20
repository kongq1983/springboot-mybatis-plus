package com.kq.pattern;

/**
 * @author kq
 * @date 2022-04-20 16:49
 * @since 2020-0630
 */
public class IdCardTest {

    public static void main(String[] args) {
        String idCard = "1234567890123456";

        String regex = "(\\w+)\\w{4}(\\w{5})";

        String replace = "$1***$2";
        // 1234567***23456
        System.out.println(idCard.replaceAll(regex, replace));


    }

}
