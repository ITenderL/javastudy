package com.itender.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.itender.exception.BizException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.itender.enums.BizExceptionEnum.USER_ID_CAN_NOT_BE_NULL_EXCEPTION;

/**
 * @author yuanhewei
 * @date 2024/1/8 18:00
 * @description
 */
public class DateTestDemo {
    public static void main(String[] args) throws ParseException {
        Long longDate = 1704938399999L;
        SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date date = new Date(longDate);
        // String strDate = formatTime.format(date);
        // 当期结束时间
        Date currentDate = formatTime.parse("2024-01-11 23:59:59");
        // 上期结束时间
        Date lastDate = formatTime.parse("2024-01-10 23:59:59");
        System.out.println("当期结束时间: " + currentDate.getTime() + " \n上期结束时间：" + lastDate.getTime());
        System.out.println("当前小时：" + DateUtil.hour(new Date(), true));
        List<DateTime> dateTimes = DateUtil.rangeToList(new Date(1704902400000L), new Date(), DateField.HOUR);
        dateTimes.forEach(System.out::println);

        Date dateTime = DateUtil.parse("2024-01-15 00:59:59", "yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime.getTime());
        throw new BizException(USER_ID_CAN_NOT_BE_NULL_EXCEPTION);
    }
}
