package com.itender.juc.blockq;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-22 18:43
 * @Description: 阻塞队列
 */
public class BlockQDemo {
    public static void main(String[] args) {
        // test1();
        // test3();
    }

    /**
     * 抛出异常
     */
    public static void test1() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // 入队
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        // 出队
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        // java.util.NoSuchElementException
        System.out.println(blockingQueue.remove());

        // 检测队首元素
        System.out.println(blockingQueue.element());
    }


    /**
     * 不抛出异常，有返回值
     */
    public static void test2() {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // 入队
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 不抛异常，返回false
        System.out.println(blockingQueue.offer("c"));

        // 出队
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 返回null
        System.out.println(blockingQueue.poll());

        // 检测队首元素
        System.out.println(blockingQueue.peek());
    }

    /**
     * 阻塞，一直等待
     */
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // 入队
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 阻塞，一直等待
        blockingQueue.put("d");

        // 出队
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // 返回null
        System.out.println(blockingQueue.take());
    }

    /**
     * 阻塞，超时等待
     */
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        // 入队
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 不抛异常，返回false,2秒后中断
        System.out.println(blockingQueue.offer("c", 2, TimeUnit.SECONDS));

        // 出队
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        // 返回null, 2秒后中断
        blockingQueue.poll(2, TimeUnit.SECONDS);

        // 检测队首元素
        System.out.println(blockingQueue.peek());
    }
}
