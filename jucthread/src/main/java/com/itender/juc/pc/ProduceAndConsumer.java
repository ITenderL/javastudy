package com.itender.juc.pc;

/**
 * @Author: ITender
 * @Description: 线程之间的通信： 生产者，消费者问题！ 等待唤醒，通知唤醒
 * 线程交替执行 A B 操作同一个变量 num num = 0
 * A num + 1
 * B nun - 1
 * @CreateTime: 2022-02-18 20:18
 */
public class ProduceAndConsumer {
    public static void main(String[] args) {
        Data data = new Data();
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
class Data {
    private int number = 0;

    /**
     * +1操作
     */
    public synchronized void increment() throws Exception {

        while (number != 0) {
            // 等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其他线程我+1完毕
        this.notifyAll();
    }

    /**
     * -1 操作
     */
    public synchronized void decrement() throws Exception {
        while (number == 0) {
            // 等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        // 通知其他线程我-1完毕
        this.notifyAll();
    }

}
