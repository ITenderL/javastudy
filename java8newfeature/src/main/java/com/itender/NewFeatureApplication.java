package com.itender;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author itender
 * @date 2022/3/8 11:20
 * @desc
 */
@Slf4j
@SpringBootApplication
public class NewFeatureApplication {
    public static void main(String[] args) {
        SpringApplication.run(NewFeatureApplication.class, args);
        log.info("启动成功");
        log.error("elk整合成功了");
    }
}
