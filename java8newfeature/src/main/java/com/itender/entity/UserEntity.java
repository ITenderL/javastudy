package com.itender.entity;

import lombok.Data;

/**
 * @author analytics
 * @date 2024/8/11 13:20
 * @description
 */
@Data
public class UserEntity {
    private String name;
    private String age;
    private Long number;
    private String address;
    private byte[] bytes = new byte[1024 * 1024];
}
