package com.itender.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-16 19:00
 */
public class CreateThread {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        AtomicInteger atomicInteger = new AtomicInteger(1);
    }

    private static void byThread() {
        Thread thread = new Thread() {

        };
    }

    private static void byRunnable() {

    }
}
