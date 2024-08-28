package com.itender.exception;

import com.itender.enums.BizExceptionEnum;

import java.text.MessageFormat;

/**
 * @author yuanhewei
 * @date 2024/1/16 16:28
 * @description
 */
public class BizException extends RuntimeException {
    private final int code;

    private final String message;

    public BizException(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }

    public BizException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException(Throwable cause, int code, String message) {
        super(cause);
        this.code = code;
        this.message = message;
    }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("程序运行异常！错误码：{0}，异常信息：{1}", this.code, this.message);
    }
}
