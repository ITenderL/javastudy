package com.itender.juc.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ITender
 * @Description: 线程之间的通信： 生产者，消费者问题！ 等待唤醒，通知唤醒
 * 线程交替执行 A B 操作同一个变量 num num = 0
 * A num + 1
 * B nun - 1
 * @CreateTime: 2022-02-18 20:18
 */
public class JUCProduceAndConsumer {
    public static void main(String[] args) {
        Data2 data = new Data2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

/**
 * 数字资源
 * 实现生产者 消费者：判断等待，业务处理，通知
 */
class Data2 {
    private int number = 0;
    Lock lock = new ReentrantLock(false);
    Condition condition = lock.newCondition();
    // 等待
    // condition.await();
    // 唤醒
    // condition.signal();

    /**
     * +1操作
     */
    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                // 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知其他线程我+1完毕
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * -1 操作
     */
    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                // 等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            // 通知其他线程我-1完毕
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
