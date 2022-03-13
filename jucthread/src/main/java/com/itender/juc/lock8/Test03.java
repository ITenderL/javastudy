package com.itender.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @Description: 8锁问题，就是锁的八个问题
 *               5.两个静态的同步方法，先打印发短信，后打印打电话
 *               6.两个对象，两个静态的同步方法，先打印发短信，后打印打电话
 * @CreateTime: 2022-02-19 19:59
 */
public class Test03 {
    public static void main(String[] args) {
        // 两个对象
        Phone3 phone3 = new Phone3();
        Phone3 phone33 = new Phone3();
        new Thread(() -> {
            phone3.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone33.call();
        }, "B").start();

    }
}

class Phone3{

    /**
     * synchronized 锁的对象是方法的调用者！phone
     * static静态的，类一加载就有了
     * 静态的static，锁的是class
     */
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短息");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }

}
