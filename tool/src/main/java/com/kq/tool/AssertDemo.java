package com.kq.tool;

import java.util.Date;

/**
 * @author kq
 * @date 2022-05-23 19:33
 * @since 2020-0630
 */
public class AssertDemo {

    public static void main(String[] args) {

        int a = 10;
        assert  a>15;
        assert  a<15;

        Date date = new Date(0);
        date.setTime(0);

    }


}
