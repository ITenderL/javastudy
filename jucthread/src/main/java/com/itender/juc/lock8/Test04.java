package com.itender.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @Description: 8锁问题，就是锁的八个问题
 *               7.一个普通同步方法，一个静态同步方法，先打印打电话，在打印发短信
 *               8.两个对象，一个普通同步方法，一个静态同步方法，先打印打电话，在打印发短信
 * @CreateTime: 2022-02-19 20:06
 */
public class Test04 {
    public static void main(String[] args) {
        // 两个对象
        Phone4 phone4 = new Phone4();
        Phone4 phone44 = new Phone4();
        new Thread(() -> {
            Phone4.sendSms();
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            phone44.call();
        }, "B").start();

    }
}

/**
 * 唯一的class对象
 */
class Phone4{

    /**
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

    /**
     * 普通同步方法
     * 锁的是方法的调用者
     */
    public synchronized void call() {
        System.out.println("打电话");
    }

}
