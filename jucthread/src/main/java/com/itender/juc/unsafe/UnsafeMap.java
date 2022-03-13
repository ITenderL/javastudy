package com.itender.juc.unsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ITender
 * @Description:
 * @CreateTime: 2022-02-19 20:54
 */
public class UnsafeMap {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>(16, 0.75);
        // Map<String, String> map = new HashMap<>();
        // Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
