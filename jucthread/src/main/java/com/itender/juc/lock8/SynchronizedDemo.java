package com.itender.juc.lock8;

public class SynchronizedDemo {

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method1();
    }

    private synchronized void method1() {
        System.out.println(Thread.currentThread().getId() + ": method1()");
        method2();
    }

    private synchronized void method2() {
        System.out.println(Thread.currentThread().getId() + ": method2()");
        method3();
    }

    private synchronized void method3() {
        System.out.println(Thread.currentThread().getId() + ": method3()");
    }
}
