package com.itender.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapDemo {
    public static void main(String[] args) {
        final List<Room> roomList = initRoom();
        // Map方法
        List<String> peopleNameList = new ArrayList<>();
        roomList.forEach(room -> room.getPeopleList().forEach(people -> peopleNameList.add(people.getName())));
        peopleNameList.forEach(System.out::println);
        System.out.println("==============================flatmap=============================");
        // flatMap 方法
        List<String> peopleNameList2 = roomList.stream()
                .flatMap(r -> r.getPeopleList().stream().distinct())
                .map(Room.People::getName)
                .collect(Collectors.toList());
        peopleNameList2.forEach(System.out::println);
    }

    // 初始化10条数据
    private static List<Room> initRoom() {
        return IntStream.range(1, 11)
                .mapToObj(num -> new Room(num, Arrays.asList(new Room.People("name:" + num), new Room.People("name:" + 10 * num))))
                .collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Room {
        private int number;
        private List<People> peopleList;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        static class People {
            private String name;
        }
    }
}
