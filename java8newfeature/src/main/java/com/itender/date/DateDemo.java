package com.itender.date;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yuanhewei
 * @date 2024/1/8 17:56
 * @description
 */
public class DateDemo {


    private static final String FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {
        System.out.println("====== JDK7及之前 ======");
        Long l1 = getMillis1();
        Long l2 = date2Millis(new Date());
        Long l3 = calendar2Millis(Calendar.getInstance());
        Long l4 = string2Millis(new SimpleDateFormat(FORMAT_STR).format(new Date()), FORMAT_STR);//为了与以上几个保持一致
        System.out.println(l1 + "\n" + l2 + "\n" + l3 + "\n" + l4);//会有几毫秒的差别

        System.out.println("====== JDK8 ======");
        Long l5 = getMillis2();
        Long l6 = localDateTime2Millis(LocalDateTime.now());
        Long l7 = localDate2Millis(LocalDate.now());
        Long l8 = clock2Millis(Clock.systemUTC());
        Long l9 = zoneDateTime2Millis(ZonedDateTime.now());
        Long l10 = string2MillisWithJDK8(LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)), FORMAT_STR);//为了与以上几个保持一致
        System.out.println(l5 + "\n" + l6 + "\n" + l7 + "\n" + l8 + "\n" + l9 + "\n" + l10);//会有几毫秒的差别
    }


    /**
     * 获取时间戳
     */
    public static Long getMillis1() {
        return System.currentTimeMillis();
    }

    /**
     * Date转时间戳
     */
    public static Long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * Calendar转时间戳
     */
    public static Long calendar2Millis(Calendar calendar) {
        return calendar.getTime().getTime();
    }

    /**
     * 日期字符串转时间戳
     */
    public static Long string2Millis(String dateStr, String formatStr) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
            return simpleDateFormat.parse(dateStr).getTime();
        } catch (Exception e) {
            return 0L;
        }
    }

    /* JDK8 */

    /**
     * 获取时间戳
     */
    public static Long getMillis2() {
        return Instant.now().toEpochMilli();
    }

    /**
     * LocalDateTime转时间戳
     */
    public static Long localDateTime2Millis(LocalDateTime localDateTime) {
        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * LocalDate转时间戳
     */
    public static Long localDate2Millis(LocalDate localDate) {
        return LocalDateTime.of(localDate, LocalTime.MIN).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    /**
     * Clock转时间戳
     */
    public static Long clock2Millis(Clock clock) {
        return clock.millis();
    }

    /**
     * ZoneDateTIme转时间戳(这个不常用吧~)
     */
    public static Long zoneDateTime2Millis(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toLocalDateTime().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();//!!!好费劲
    }

    /**
     * String转时间戳(JDK8)
     */
    public static Long string2MillisWithJDK8(String dateStr, String formatStr) {
        return LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(formatStr)).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

}
