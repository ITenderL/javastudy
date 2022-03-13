package com.itender.juc.volatile1;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 21:54
 * @Description: volatile保证可见性
 */
public class JMMDemo {
    // 不加volatile，死循环
    // 加volatile，可以保证可见性
    public volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(2);

        num = 1;

        System.out.println(num);

    }
}
