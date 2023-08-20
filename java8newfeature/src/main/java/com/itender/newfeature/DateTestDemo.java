package com.itender.newfeature;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

/**
 * @author itender
 * @date 2022/8/11 18:21
 * @desc
 */
public class DateTestDemo {
    public static void main(String[] args) {
        System.out.println(DateUtil.now());

        String dateString = "2022/12/12 00:00:00";
        System.out.println(DateUtil.parseDateTime("2022/12/12 23:59:59"));

        DateTime dateTime = DateUtil.offsetDay(DateUtil.parseDate("2022/12/12 23:59:59"), -24);

        String newdate = DateUtil.formatDateTime(dateTime);
        System.out.println(newdate);
    }
}
