package com.itender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-24 16:30
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.itender.mybatis.dao")
public class MybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }
}
