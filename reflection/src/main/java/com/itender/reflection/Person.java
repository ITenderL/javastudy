package com.itender.reflection;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author itender
 * @date 2023/1/28 14:46
 * @desc
 */
@Data
@ToString
@Accessors(chain = true)
public class Person {

    private String name;

    private String sex;

    private Integer age;

    private String address;
}
