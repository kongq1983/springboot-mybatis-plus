package com.kq.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author kq
 * @date 2022-05-07 10:42
 * @since v1
 */
public class DateUtil {

    /**
     * 默认日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 这个不要改，不够自己加别的format
     */
    public static final String MONTH_FORMAT = "yyyyMM";

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL_SIMPLE_DATE_FORMAT = ThreadLocal
            .withInitial(() -> new SimpleDateFormat());

    public static String[] DAY_OF_WEEK_NAME = {"周日","周一","周二","周三","周四","周五","周六"};

    /**
     * 如果没有日期  则默认日期（主要用于比较）
     */
    public static final Date DEFAULT_EMPTY_DATE = stringToDate("2022-01-01");

    /**
     * 获取今天是星期几 (星期一:1  星期二:2 星期三:3 星期四:4 星期五:5 星期六:6 星期天:7)
     * @return
     */
    public static int getTodayOfWeek() {
        return getDateOfWeek(new Date());
    }


    /**
     * 周几显示
     * @param date
     * @return
     */
    public static String getDayOfWeekName(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return DAY_OF_WEEK_NAME[weekDay-1];
    }


    /**
     * 获取指定日期是星期几 (星期一:1  星期二:2 星期三:3 星期四:4 星期五:5 星期六:6 星期天:7)
     * @param date
     * @return
     */
    public static int getDateOfWeek(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        //一周第一天是否为星期天
        boolean isFirstSunday = (calendar.getFirstDayOfWeek() == Calendar.SUNDAY);
//        System.out.println("isFirstSunday="+isFirstSunday);
        //获取周几
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if (weekDay == 0) {
                weekDay = 7;
            }
        }
        //打印周几
//        System.out.println(weekDay);

        return weekDay;

    }

    /**
     * 去掉时分秒
     * @param date
     * @return
     * @throws Exception
     */
    public static Date dealToOnlyDate(Date date) {

        if(date==null) {
            return null;
        }

        SimpleDateFormat sdf = THREAD_LOCAL_SIMPLE_DATE_FORMAT.get();
        sdf.applyPattern(DEFAULT_DATE_FORMAT);
        String stringDate = sdf.format(date);
        Date strToDate ;
        try {
            strToDate = sdf.parse(stringDate);
        }catch (ParseException e) {
           return null;
        }
        return strToDate;

    }

    /**
     * string to date (yyyy-MM-dd)
     * @param stringDate
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String stringDate)  {
        SimpleDateFormat sdf = THREAD_LOCAL_SIMPLE_DATE_FORMAT.get();
        sdf.applyPattern(DEFAULT_DATE_FORMAT);

        Date strToDate ;
        try {
            strToDate = sdf.parse(stringDate);
        }catch (ParseException e) {
            return null;
        }
        return strToDate;
    }

    public static Date stringToDateTime(String stringDate)  {
        SimpleDateFormat sdf = THREAD_LOCAL_SIMPLE_DATE_FORMAT.get();
        sdf.applyPattern(DEFAULT_DATE_TIME_FORMAT);

        Date strToDate ;
        try {
            strToDate = sdf.parse(stringDate);
        }catch (ParseException e) {
            return null;
        }
        return strToDate;
    }


    /**
     * 获取本月1号和下月1号
     * @param year
     * @param month
     * @return
     */
    public static Date[] getThisMonthStartAndNextMonthStartDate(Integer year,Integer month) {
        // Calendar 这个类其中月是个比较特别的,是从0开始计算的,如果你要显示5月,传入的就要是4.
        Calendar cal = Calendar.getInstance();
        cal.set(year,month-1,1);

        Date startDate = dealToOnlyDate(cal.getTime());
        Date endDate = getAddOneMonth(startDate);

        return new Date[]{startDate,endDate};

    }

    /**
     * 获取本月1号 和 下月1号
     * @return
     */
    public static Date[] getThisMonthStartAndNextMonthStartDate() {
        // Calendar 这个类其中月是个比较特别的,是从0开始计算的,如果你要显示5月,传入的就要是4.
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE,1); // 设置1号
        Date startDate = dealToOnlyDate(cal.getTime());
        Date endDate = getAddOneMonth(startDate);

        return new Date[]{startDate,endDate};

    }


    /**
     * 添加1个月
     * @param date
     * @return
     */
    public static Date getAddOneMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month + 1);

        return c.getTime();
    }


    /**
     * 减天数
     * @param date
     * @param addDay
     * @return
     */
    public static Date getSubDate(Date date,int addDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - addDay);

        return c.getTime();
    }


    /**
     * 加天数
     * @param date
     * @param addDay
     * @return
     */
    public static Date getAddDate(Date date,int addDay) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + addDay);

        return c.getTime();
    }


    /**
     * 精确到毫秒 用于订单生成
     * @return
     */
    public static String getFormatDateForCode() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return f.format(date);
    }

    /**
     * 获取默认日期格式
     * @param date
     * @return
     */
    public static String getDefaultStringDate(Date date) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        return f.format(date);
    }


    /**
     * 判断是否是今天之前的日期(不包括当天)
     * @param date
     * @return
     */
    public static boolean isBeforeToday(Date date) {
        Date today = dealToOnlyDate(new Date());
        Date saleDate = dealToOnlyDate(date);

        if(saleDate.getTime()<today.getTime()) {
            return true;
        }

        return false;

    }


    /**
     * 判断年月日是否同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSomeDate(Date date1, Date date2) {

        if(date1==null||date2==null) {
            return false;
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        int year1 = c.get(Calendar.YEAR);
        int month1 = c.get(Calendar.MONTH) + 1;
        int day1 = c.get(Calendar.DATE);

        c.setTime(date2);

        int year2 = c.get(Calendar.YEAR);
        int month2 = c.get(Calendar.MONTH) + 1;
        int day2 = c.get(Calendar.DATE);

        return (year1==year2) && (month1==month2) && (day1==day2);

    }

    /**
     * 今天之前（包括当天）
     * @param date
     * @return
     */
    public static boolean isBeforeAndIncludeToday(Date date) {
        Date today = dealToOnlyDate(new Date());
        Date saleDate = dealToOnlyDate(date);

        if(today!=null && saleDate!=null && saleDate.getTime()<=today.getTime()) {
            return true;
        }

        return false;

    }

    /**
     * 结束日期是否在开始日期之前
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isBeforeStartDate(Date startDate,Date endDate) {
        Date start = dealToOnlyDate(startDate);
        Date end = dealToOnlyDate(endDate);

        if(end.getTime()<start.getTime()) {
            return true;
        }

        return false;

    }


    /**
     * 获取今天及今天之后的日期
     * @param addDay  今后几天
     * @return
     */
    public static List<Date> getDateList(int addDay) {

        Date date = new Date();
        List<Date> list = new ArrayList<>();
        list.add(date);

        for(int i=1;i<addDay;i++) {
            list.add(getAddDate(date,i));
        }

        return list;

    }



    /**
     * 处理开始时间
     * @param date
     * @return
     */
    public static Date dealStartDate(Date date) {
        if(date==null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();

    }

    /**
     * 处理结束时间
     * @param date
     * @return
     */
    public static Date dealEndDate(Date date) {
        if(date==null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);

        return calendar.getTime();

    }


    /**
     * format
     * @param date
     * @return
     */
    public static String getDateFormat(Date date,String format) {
        if(date==null) {
            return null;
        }
        SimpleDateFormat f = new SimpleDateFormat(format);
        return f.format(date);
    }

    /**
     * 获取开始日期和结束日期之差
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getBetweenDays(Date startDate, Date endDate) {
        int betweenDays = 0;
        Date vStartDate = dealStartDate(startDate);
        Date vEndDate = dealStartDate(endDate);

        long start = vStartDate.getTime();
        long end = vEndDate.getTime();

        betweenDays = (int) (Math.abs(end - start)/(24*3600*1000));

        return betweenDays+1;
    }


//    public static List<String> getStringBetweenDates(Date startDate, Date endDate) {
//
//        List<Date> list = getBetweenDates(startDate, endDate);
//
//        return list.stream().map(date-> getDefaultStringDate(date)).collect(Collectors.toList());
//
//    }

//    public static void main(String[] args) throws Exception{
////        System.out.println("today: "+getTodayOfWeek());
////        System.out.println("2022-05-08: "+getDateOfWeek(stringToDate("2022-05-08")));
////        System.out.println("2022-05-09: "+getDateOfWeek(stringToDate("2022-05-09")));
//
//        System.out.println(new Date());
//        System.out.println(getSimpleFormatDate(new Date()));
//
//    }

    public static void main(String[] args) {
//        Date[] dates = getThisMonthStartAndNextMonthStartDate(2022,5);
        Date[] dates = getThisMonthStartAndNextMonthStartDate();

        System.out.println(dates[0]);
        System.out.println(dates[1]);

        System.out.println(getFormatDateForCode());

        Date startDate = stringToDate("2022-05-01");
        Date endDate = stringToDate("2022-05-31");
        int diffDays = getBetweenDays(startDate,endDate);




        System.out.println("diffDays="+diffDays);

    }

}
