package com.itender.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @Description: 8锁问题，就是锁的八个问题
 *               1.先输出发短信，在输出打电话
 * @CreateTime: 2022-02-19 19:40
 */
public class Test01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.call();
        }, "B").start();

    }
}

class Phone{

    /**
     * synchronized 锁的对象是方法的调用者！phone
     * 两个方法用的是同一把锁，谁先拿到谁先执行
     */
    public synchronized void sendSms() {
        System.out.println("发短息");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}
