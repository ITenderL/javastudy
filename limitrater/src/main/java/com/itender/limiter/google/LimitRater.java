package com.itender.limiter.google;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author itender
 * @date 2022/3/29 17:42
 * @desc
 */
@Slf4j
@RestController
public class LimitRater {
    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();
    RateLimiter rateLimiter = RateLimiter.create(4);

    @GetMapping("/limit")

    public int testLimiter2() {
        log.info("等待时间：{}", rateLimiter.acquire());
        if (!rateLimiter.tryAcquire(1, TimeUnit.SECONDS)) {
            log.info("请求超时：{}", rateLimiter.acquire());
            return 0;
        }
        return ATOMIC_INTEGER.incrementAndGet();
    }
}
