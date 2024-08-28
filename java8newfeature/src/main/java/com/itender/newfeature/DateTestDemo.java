package com.itender.newfeature;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author itender 用户画像
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

        DateTime date = DateUtil.date();
        System.out.println(date);


        User user = User.builder().date(DateUtil.date()).build();
        System.out.println(JSON.toJSONString(user));


    }
    @Builder
    @Data
    public static class User{
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonFormat(
                timezone = "GMT+8",
                pattern = "yyyy-MM-dd HH:mm:ss"
        )
        private Date date;
    }
}
