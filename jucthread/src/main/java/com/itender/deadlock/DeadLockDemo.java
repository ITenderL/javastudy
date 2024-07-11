package com.itender.deadlock;

/**
 * @author yuanhewei
 * @date 2024/7/11 14:17
 * @description 简单的死锁代码实现
 */
public class DeadLockDemo {

    private static Object resource1 = new Object();

    private static Object resource2 = new Object();
    public static void main(String[] args) {
        // 线程1，先获取资源1的锁，休眠1s然后获取资源2的锁
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println("thread-1 acquire resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-1 acquire resource1 waiting acquire resource2");
                synchronized (resource2) {
                    System.out.println("thread-1 acquire resource2");
                }
            }
        }, "thread-1").start();

        // 线程2，先获取资源2的锁，睡眠1s然后获取资源1的锁
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println("thread-2 acquire resource2 ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread-2 acquire resource2 waiting acquire resource1");
                synchronized (resource1) {
                    System.out.println("thread-2 acquire resource1");
                }
            }
        }, "thread-2").start();
    }
}
