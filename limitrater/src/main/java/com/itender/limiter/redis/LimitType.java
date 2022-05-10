package com.itender.limiter.redis;

import lombok.Getter;

/**
 * @author itender
 * @date 2022/3/29 17:11
 * @desc
 */
@Getter
public enum LimitType {
    /**
     * 自定义key
     */
    CUSTOMER,

    /**
     * 请求者IP
     */
    IP;
}
