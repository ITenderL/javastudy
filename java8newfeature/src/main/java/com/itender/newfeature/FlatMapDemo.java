package com.itender.newfeature;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanhewei
 * @date 2024/7/5 10:11
 * @description
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        Hobby hobby1 = Hobby.builder()
                .id(1)
                .name("吃饭")
                .build();
        Hobby hobby2 = Hobby.builder()
                .id(2)
                .name("睡觉")
                .build();
        Hobby hobby3 = Hobby.builder()
                .id(3)
                .name("唱歌")
                .build();
        Hobby hobby4 = Hobby.builder()
                .id(4)
                .name("跳舞")
                .build();
        Hobby hobby5 = Hobby.builder()
                .id(5)
                .name("看电视")
                .build();
        Hobby hobby6 = Hobby.builder()
                .id(6)
                .name("打游戏")
                .build();
        List<Hobby> hobbyList1 = Lists.newArrayList(hobby1, hobby2, hobby3);
        List<Hobby> hobbyList2 = Lists.newArrayList(hobby4, hobby5, hobby6);
        Person person1 = Person.builder()
                .id(1)
                .name("张三")
                .hobbies(hobbyList1)
                .build();
        Person person2 = Person.builder()
                .id(2)
                .name("李四")
                .hobbies(hobbyList2)
                .build();
        List<Person> persons = Lists.newArrayList(person1, person2);
        List<String> hobbyList = persons.stream().flatMap(p -> p.getHobbies().stream()).map(Hobby::getName).collect(Collectors.toList());
        System.out.println("hobbyList = " + JSON.toJSONString(hobbyList));
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        /**
         * 主键id
         */
        private Integer id;

        /**
         * 名称
         */
        private String name;

        /**
         * 爱好
         */
        private List<Hobby> hobbies;
    }

    /**
     * 爱好实体类
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Hobby {
        /**
         * 主键id
         */
        private Integer id;

        /**
         * 名称
         */
        private String name;
    }
}
