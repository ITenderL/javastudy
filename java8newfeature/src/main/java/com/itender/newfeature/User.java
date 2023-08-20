package com.itender.newfeature;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author itender
 * @date 2022/3/8 11:56
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;

    private String age;

    private Long number;

    private String address;

    public User(String name, String age, long number, String address) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                ", address='" + address + '\'' +
                '}';
    }


}
