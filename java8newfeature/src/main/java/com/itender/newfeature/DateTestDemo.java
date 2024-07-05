package com.itender.newfeature;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author itender
 * @date 2022/8/11 18:21
 * @desc
 */
public class DateTestDemo {
    public static void main(String[] args) {
        // System.out.println(DateUtil.now());
        //
        // String dateString = "2022/12/12 00:00:00";
        // System.out.println(DateUtil.parseDateTime("2022/12/12 23:59:59"));
        //
        // DateTime dateTime = DateUtil.offsetDay(DateUtil.parseDate("2022/12/12 23:59:59"), -24);
        //
        // String newdate = DateUtil.formatDateTime(dateTime);
        // System.out.println(newdate);
        // 品牌属性
        String date = "2024/1/7";
        DateTime dateTime = DateUtil.parse(date, "yyyy/MM/dd");
        System.out.println(DateUtil.format(dateTime, "yyyy-MM-dd"));

        // 上一周
        String d1 = LocalDate.now().minusWeeks(1).with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1L) + " 00:00:00";
        String d2 = LocalDate.now().minusWeeks(1).with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1L) + " 23:59:59";

        System.out.println("上一周开始日期: " + d1);
        System.out.println("上一周结束日期: " + d2);
        // LocalDate d3 = LocalDate.now().minusWeeks(2).with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1L);
        // LocalDate d4 = LocalDate.now().minusWeeks(2).with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1L);
        // System.out.println("上上一周开始日期: " + d3);
        // System.out.println("上上一周结束日期: " + d4);

        // 上一个月
        LocalDate now = LocalDate.now();
        String firstDayOfLastMonth = now.with(TemporalAdjusters.firstDayOfMonth()).minusMonths(1)+ " 00:00:00";
        String lastDayOfLastMonth = now.with(TemporalAdjusters.lastDayOfMonth()).minusMonths(1) + " 23:59:59";

        // LocalDateTime startOfLastMonth = LocalDateTime.of(firstDayOfLastMonth, LocalTime.MIN);
        // LocalDateTime endOfLastMonth = LocalDateTime.of(lastDayOfLastMonth, LocalTime.MAX);

        System.out.println("上一个月开始时间: " + firstDayOfLastMonth);
        System.out.println("上一个月结束时间: " + lastDayOfLastMonth);
    }
}
