package com.itender.juc.suport;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 21:06
 * @Description:CountDownLatch 计数器
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6,必须要执行的任务的时候再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " => Go Out!");
                // 数量 -1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 等待计数器归零，向下运行
        countDownLatch.await();
        System.out.println("Close Door!");
    }
}
