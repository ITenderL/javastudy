package com.itender.spring.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author itender
 * @date 2022/5/12 17:18
 * @desc spring循环依赖源码研究
 */
public class CycleDependency {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("circle/circle.xml");
    }
}
