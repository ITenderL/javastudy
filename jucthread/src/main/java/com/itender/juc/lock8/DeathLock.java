package com.itender.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-23 17:06
 * @Description: 死锁
 */
public class DeathLock {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        new Thread(new MyThread(obj1, obj2)).start();
        new Thread(new MyThread(obj2, obj1)).start();
    }
}

class MyThread implements Runnable {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public MyThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1) {
            System.out.println(Thread.currentThread().getName() + "Locked" + obj1 + " and request " + obj2);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println(Thread.currentThread().getName() + "Locked" + obj2 + " and request " + obj1);
            }
        }
    }
}
