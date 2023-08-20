package com.itender.newfeature;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @author itender
 * @date 2022/6/23 9:32
 * @desc
 */
@Slf4j
public class Testdemo {
    public static void main(String[] args) {
        // String str = "111-222-333-444";
        // int i = str.lastIndexOf("-");
        // String s = str.substring(i);
        // System.out.println(s);
        // float l = 2f;
        // float j = 1f;
        // float a = 0.000f;
        // System.out.println(a == 0);
        // int compare = Float.compare(l, j);
        // float abs = Math.abs(l - j);
        // System.out.println(abs);
        // System.out.println(compare);
        //
        // System.out.println(Objects.equals(a, 0f));
        //
        // String source = "大家好，我是%s, 我来自%s, 今年%d岁了";
        // System.out.println(String.format(source, "小明", "深圳", 20));
        //
        //
        // IntStream.range(0, 5).forEach(System.out::println);
        //
        // System.out.println(DateUtil.now());
        //
        // System.out.println(DateUtil.parseDate("2022/23/12"));
        // // System.out.println(DateUtil.parseDateTime("20222312000000"));
        //
        // double v = new BigDecimal("0.00").doubleValue();
        // DecimalFormat format = new DecimalFormat("0.00");
        // String format1 = format.format(0f);
        //
        // System.out.println(format.format(0f));
        //
        // float aa = 0;
        // System.out.println(Objects.equals(aa, 0f));
        //
        // try {
        //     // int i = 10;
        //     throw new RuntimeException("llllllll");
        // } catch (Exception e) {
        //     log.error("exception:{}, msg:{}, stackTrace:{}", e, e.getMessage(), ExceptionUtils.getStackTrace(e));
        // }
        //
        //
        // double x = 0.0001;
        // DecimalFormat decimalFormat = new DecimalFormat("0.000");
        // System.out.println(decimalFormat.format(x));
        //
        //

        String ll = "我是一个人";

        System.out.println(ll.replace(" ", ""));
        System.out.println(ll.trim());
    }
}
