package com.itender.juc.suport;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 21:24
 * @Description: 栅栏，屏障，加法计数器
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        // 集齐7颗龙珠，召唤神龙
        // 召唤神龙的线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙成功！");
        });

        for (int i = 0; i < 7; i++) {
            // lambda能拿到i吗？不能
            final int tmp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "收集了" + tmp + "颗龙珠！");
                try {
                    // 等待七个线程都执行完了，再向下执行
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
