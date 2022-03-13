package com.itender.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ITender
 * @Description:
 * @CreateTime: 2022-02-19 19:23
 */
public class SortedExecute {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        }, "C").start();
    }
}

class Data3{
    private Lock lock = new ReentrantLock(false);
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int number = 1;

    /**
     * 判断-> 执行业务（等待） -> 通知
     */
    public void printA() {
        lock.lock();
        try {
            // 判断-> 执行业务（等待） -> 通知
            while (number != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> AAAAAAAA");
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            // 判断-> 执行业务（等待） -> 通知
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> BBBBBBBB");
            number = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            // 判断-> 执行业务（等待） -> 通知
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "=> CCCCCCCC");
            number = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
