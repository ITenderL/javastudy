package com.itender.enums;

import lombok.Getter;

/**
 * @author yuanhewei
 * @date 2024/1/16 16:32
 * @description
 */
@Getter
public enum BizExceptionEnum {

    USER_ID_CAN_NOT_BE_NULL_EXCEPTION(505, "用户ID不能为空！");


    private final Integer code;

    private final String message;

    BizExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
