package com.itender.juc.suport;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 21:34
 * @Description: 信号量
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量，停车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                try {
                    // 获得
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位！");
                    // 停车两秒钟
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放
                    semaphore.release();
                }
            }, String.valueOf(i + 1)).start();
        }
    }
}
