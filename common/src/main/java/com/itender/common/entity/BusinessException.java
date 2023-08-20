package com.itender.common.entity;

import lombok.Data;

/**
 * @author itender
 * @date 2022/3/25 12:30
 * @desc
 */
@Data
public class BusinessException extends RuntimeException {
    /**
     * 状态码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
