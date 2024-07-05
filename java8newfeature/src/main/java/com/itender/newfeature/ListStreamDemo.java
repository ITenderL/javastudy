package com.itender.newfeature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanhewei
 * @date 2024/2/28 15:02
 * @description
 */
public class ListStreamDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        // skip
        // list.stream().skip(5).collect(Collectors.toList()).forEach(System.out::println);
        // list.stream().skip(5).limit(3).collect(Collectors.toList()).forEach(System.out::println);

        list.stream().skip(10).collect(Collectors.toList()).forEach(System.out::println);
    }
}
