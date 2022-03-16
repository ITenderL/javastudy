package com.itender.newfeature;

/**
 * @author itender
 * @date 2022/3/8 11:56
 * @desc
 */
// @Data
// @NoArgsConstructor
// @AllArgsConstructor
public class User {
    private String name;

    private Integer age;

    private Long number;

    private String address;

    public User(String name, int age, long number, String address) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
