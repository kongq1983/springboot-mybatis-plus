package com.kq.tool.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author kq
 * @date 2022-05-18 16:29
 * @since 2020-0630
 */
public class LocalDateUtil {

    public static void main(String[] args) {
        String date = LocalDate.now().toString();
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(date);



//        String pattern = "([01][0-9][2][0-3]):[0-5][0-9]";
        String pattern = "([01][0-9]|[2][0-3]):[0-5][0-9]";

        System.out.println("00:00".matches(pattern));
        System.out.println("06:00".matches(pattern));
        System.out.println("19:00".matches(pattern));
        System.out.println("20:00".matches(pattern));
        System.out.println("23:00".matches(pattern));
        System.out.println("23:59".matches(pattern));
        System.out.println("24:00".matches(pattern));

        System.out.println("-------------------------------------------------------");

        // "06:00-08:00
        String regex = "(([01][0-9]|[2][0-3]):[0-5][0-9])-(([01][0-9]|[2][0-3]):[0-5][0-9])";
        System.out.println("06:00-08:00".matches(regex));
        System.out.println("00:00-23:59".matches(regex));
        System.out.println("10:00-18:00".matches(regex));
        System.out.println("10:00 - 18:00".matches(regex));

        System.out.println("-------------------------------------------------------");

        String time = "14:00-15:00";
        String[] times = time.split("-");
        System.out.println(times[0]);
        System.out.println(times[1]);

        LocalTime startTime = LocalTime.parse(times[0]);
        LocalTime endTime = LocalTime.parse(times[1]);

        LocalTime nowTime = LocalTime.now();
        if(nowTime.isAfter(startTime)) {
            System.out.println("nowTime.isAfter(startTime)");
        }

        if(endTime.isAfter(nowTime)) {
            System.out.println("endTime.isAfter(nowTime)");
        }


    }

}
