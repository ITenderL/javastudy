package com.itender.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: ITender
 * @Description: List集合不安全
 * @CreateTime: 2022-02-19 20:19
 */
public class UnsafeList {

    /**
     * java.util.ConcurrentModificationException 并发修改异常！
     * 并发下List是不安全的
     *    解决方案：
     *      1.List<String> list = new Vector<>();
     *      2.List<String> list = Collections.synchronizedList(new ArrayList<>());
     *      3.
     *
     * @param args
     */
    public static void main(String[] args) {
        // List<String> list = new ArrayList<>();
        // List<String> list = new Vector<>();
        // List<String> list = Collections.synchronizedList(new ArrayList<>());
        // CopyOnWrite 写入时复制，多线程调用的时候，
        // 再写入的时候避免覆盖，造成数据问题
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(1)).start();
        }
    }
}
