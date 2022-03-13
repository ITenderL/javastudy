package com.itender.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @Description: 8锁问题，就是锁的八个问题
 *               3.hello非同步方法，先输出hello,在输出发短信
 *               4.两个对象，两个同步方法，先输出打电话，在输出发短信
 * @CreateTime: 2022-02-19 19:40
 */
public class Test02 {
    public static void main(String[] args) {
        // 两个对象
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(() -> {
            phone1.sendSms();
        }, "A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone2.call();
        }, "B").start();

    }
}

class Phone2{

    /**
     * synchronized 锁的对象是方法的调用者！phone
     * 两个方法用的是同一把锁，谁先拿到谁先执行
     */
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短息");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

    /**
     * 没有锁，不受锁的影响
     */
    public  void hello() {
        System.out.println("hello");
    }

}
