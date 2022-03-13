package com.itender.juc.volatile1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 22:04
 * @Description: 不保证原子性
 */
public class VolatileDemo {
    // volatile不保证原子性
    // public volatile static int num = 0;
    public volatile static AtomicInteger num = new AtomicInteger(0);

    public static void add() {
        // 不是原子性操作
        // num++;
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        // 理论上num = 20000；
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        // main gc线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() +  " " + num);
    }
}
