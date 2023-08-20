package com.itender.newfeature.lambdaobj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author itender
 * @date 2022/7/6 15:47
 * @desc
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;

    private String sex;

    private Integer age;
}
