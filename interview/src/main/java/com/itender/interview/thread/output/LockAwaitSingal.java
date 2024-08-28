package com.itender.interview.thread.output;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author itender
 * @date 2023/11/03/ 12:59
 * @desc
 */
public class LockAwaitSingal {
    public static void main(String[] args) {
        char[] char1 = "1234567".toCharArray();
        char[] char2 = "abcdefg".toCharArray();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : char1) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                 // 必须，否则无法停止程序
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : char2) {
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                // 必须，否则无法停止程序
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }, "t2").start();

    }
}
