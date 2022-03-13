package com.itender.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-20 22:25
 * @Description: CAS
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(2020);
        i.compareAndSet(2020, 2021);

        System.out.println(i.get());
    }

}
