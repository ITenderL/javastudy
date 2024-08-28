package com.itender.interview.thread.output;


/**
 * @author itender
 * @date 2023/11/03/ 12:59
 * @desc
 */
public class WaitNotify {
    public static void main(String[] args) {
        final Object o = new Object();
        char[] char1 = "1234567".toCharArray();
        char[] char2 = "abcdefg".toCharArray();
        new Thread(() -> {
            synchronized (o) {
                for (char c : char1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        // 让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 必须，否则无法停止程序
                o.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (o) {
                for (char c : char2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        // 让出锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 必须，否则无法停止程序
                o.notify();
            }
        }, "t2").start();
    }
}
