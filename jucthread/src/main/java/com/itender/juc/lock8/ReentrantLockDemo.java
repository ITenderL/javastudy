package com.itender.juc.lock8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author itender
 * @date 2022/11/3 16:23
 * @desc
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
    }
}
