package com.itender.spring.ioc;

import com.itender.spring.service.MessageService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author itender
 * @date 2022/5/20 14:17
 * @desc
 */
public class SpringIoc {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationfile.xml");
        System.out.println("Spring Context 启动成功！");
        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
