package com.itender.newfeature;


import com.sun.deploy.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author itender
 * @date 2022/3/8 11:41
 * @desc
 */
public class NewFeatureDemo {
    public static void main(String[] args) {
        // List<String> list = Arrays.asList("小红", "小兰", "小绿", "小明", "小华", "小红", "小明");
        // Stream<String> filterList = list.stream().filter(s -> "小华".equals(s));
        // filterList.forEach(System.out::println);
        //
        // long count = list.stream().filter(s -> "小华".equals(s)).count();
        // System.out.println("小华的数量为：" + count);
        //
        // list.stream().limit(1).forEach(s -> System.out.println("取list中的第一个：" + s));
        //
        // list.stream().distinct().forEach(s -> System.out.println("去重之后的list：" + s));

        List<User> userList = new ArrayList<>();
        User hong = new User("小红", 15, 1L, "福田");
        User hua = new User("小华", 16, 2L, "南山");
        User lan = new User("小蓝", 17, 3L, "龙华");
        User ming = new User("小明", 18, 4L, null);
        User lv = new User("小绿", 16, 5L, "龙岗");
        User lv1 = new User("小绿", 19, 5L, "光明");
        userList.add(hong);
        userList.add(hua);
        userList.add(lan);
        userList.add(ming);
        userList.add(lv);
        userList.add(lv1);

        userList.stream().sorted(Comparator.comparing(User::getAge, Comparator.nullsLast(Integer::compareTo))).collect(Collectors.toList()).forEach(System.out::println );


        // list转成map
        Map<Long, String> map = userList.stream().collect(Collectors.toMap(User::getNumber, User::getName, (key1, key2) -> key2));
        // Map<Long, String> map = userList.stream().collect(Collectors.toMap(User::getNumber, User::getName));
        Map<Long, User> userMap = userList.stream().collect(Collectors.toMap(User::getNumber, user -> user, (key1, key2) -> key2));
        System.out.println("map为：" + map);
        System.out.println("userMap为：" + userMap);
        userList.stream().map(User::getAge).collect(Collectors.toList()).stream().sorted().distinct().forEach(s -> System.out.println(s));

        //对数组的统计，比如用
        List<Integer> number = Arrays.asList(1, 2, 5, 4, 7, 3, 9);

        int[] ints = number.stream().mapToInt(i -> i).toArray();
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());


        // 求和
        long sum = number.stream().mapToInt((x) -> x).summaryStatistics().getSum();
        // 最大值
        int max = number.stream().mapToInt(x -> x).summaryStatistics().getMax();
        int min = number.stream().mapToInt(x -> x).summaryStatistics().getMin();
        double average = number.stream().mapToInt(x -> x).summaryStatistics().getAverage();
        System.out.println("最大值；" + max + " 最小值：" + min + " 和为：" + sum + " 品均值为：" + average);

        Map<String, List<User>> listMap = userList.stream().collect(Collectors.groupingBy(s -> s.getName()));
        System.out.println("listMap为：" + listMap);

        int[] array = number.stream().mapToInt(i -> i).toArray();
        Arrays.stream(array).sorted().forEach(i -> System.out.println(i));

        Stream.of(array).collect(Collectors.toList());
        List<Integer> integerList = Arrays.stream(array).boxed().collect(Collectors.toList());
        integerList.stream().forEach(System.out::println);


        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        System.out.println("List转成string：" + StringUtils.join(stringList, ","));
    }
}

