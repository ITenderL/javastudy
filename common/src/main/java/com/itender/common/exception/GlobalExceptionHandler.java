package com.itender.common.exception;

import com.itender.common.entity.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author itender
 * @date 2022/3/25 9:49
 * @desc
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        log.error("服务错误：{}", e);
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }

@ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException e) {
        log.error("服务错误：{}", e);
        return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
    }
}
