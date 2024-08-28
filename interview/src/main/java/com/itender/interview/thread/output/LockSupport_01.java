package com.itender.interview.thread.output;

import java.util.concurrent.locks.LockSupport;

/**
 * @author itender
 * @date 2023/11/03/ 12:36
 * @desc 两个线程交替输出 t1：1234567 t2：abcdefg 贪吃蛇
 */
public class LockSupport_01 {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] char1 = "1234567".toCharArray();
        char[] char2 = "abcdefg".toCharArray();
        t1 = new Thread(() -> {
            for (char c : char1) {
                System.out.print(c);
                // 叫醒t2
                LockSupport.unpark(t2);
                // 当前线程阻塞
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : char2) {
                // 当前线程阻塞
                LockSupport.park();
                System.out.print(c);
                // 叫醒t1
                LockSupport.unpark(t1);
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}
