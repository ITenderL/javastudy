package com.itender.interview.thread.deathlock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author : itender
 * @date : 2023/11/02/ 12:57
 * @desc :
 */
public class DeadLock {
    public static void main(String[] args) {
        ChopStick ch0 = new ChopStick();
        ChopStick ch1 = new ChopStick();
        ChopStick ch2 = new ChopStick();
        ChopStick ch3 = new ChopStick();
        ChopStick ch4 = new ChopStick();

        Philosopher p0 = new Philosopher("p0", ch0, ch1, 0);
        Philosopher p1 = new Philosopher("p1", ch1, ch2, 1);
        Philosopher p2 = new Philosopher("p2", ch2, ch3, 2);
        Philosopher p3 = new Philosopher("p3", ch3, ch4, 3);
        Philosopher p4 = new Philosopher("p4", ch4, ch0, 4);

        p0.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
    }

    public static class ChopStick{

    }

    /**
     * 哲学家
     */
    public static class Philosopher extends Thread{
        private final ChopStick left;
        private final ChopStick right;

        private Integer index;

        public Philosopher(String name, ChopStick left, ChopStick right, Integer index) {
            this.setName(name);
            this.left = left;
            this.right = right;
            this.index = index;
        }

        @SneakyThrows
        @Override
        public void run() {
            // 死锁状态
            // synchronized (left) {
            //     TimeUnit.SECONDS.sleep(1L + index);
            //     synchronized (right) {
            //         TimeUnit.SECONDS.sleep(1L);
            //         System.out.println(index + "号哲学家已经吃完了！");
            //     }
            // }
            // 解决哲学加就餐问题，第0个哲学家先拿左手，再拿右手筷子，其他先拿右手，再拿左手
            // 优化：可以奇数先左手在右手，偶数先右手在左手
            if (index == 0) {
                synchronized (left) {
                    TimeUnit.SECONDS.sleep(1L + index);
                    synchronized (right) {
                        TimeUnit.SECONDS.sleep(1L);
                        System.out.println(index + "号哲学家已经吃完了！");
                    }
                }
            } else {
                synchronized (right) {
                    TimeUnit.SECONDS.sleep(1L + index);
                    synchronized (left) {
                        TimeUnit.SECONDS.sleep(1L);
                        System.out.println(index + "号哲学家已经吃完了！");
                    }
                }
            }
        }
    }
}
