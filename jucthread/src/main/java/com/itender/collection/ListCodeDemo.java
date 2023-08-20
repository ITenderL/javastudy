package com.itender.collection;

import cn.hutool.core.date.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-23 16:57
 * @Description: List源码
 */
public class ListCodeDemo {
    public static void main(String[] args) {

        double ceil = Math.floor(11 / 50);
        System.out.println(DateUtil.today());
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
    }
}
