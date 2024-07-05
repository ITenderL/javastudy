package com.itender.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author yuanhewei
 * @date 2024/5/23 14:48
 * @description
 */
@SpringBootTest

class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis() {
        stringRedisTemplate.opsForValue().set("itender", "cool");
        String result = stringRedisTemplate.opsForValue().get("itender");
        System.out.println(result);
    }
}
