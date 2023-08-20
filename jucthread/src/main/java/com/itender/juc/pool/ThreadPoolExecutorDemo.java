package com.itender.juc.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author itender
 * @date 2023/8/7 14:37
 * @desc
 */
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                // 核心线程数 5
                CORE_POOL_SIZE,
                // 最大线程数 10
                MAX_POOL_SIZE,
                // 超过核心线程数，线程最大存活时间
                KEEP_ALIVE_TIME,
                // 时间单位
                TimeUnit.MINUTES,
                // 工作队列最大值
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                r -> {
                    Thread thread = new Thread(r);
                    thread.setName("pool-");
                    return thread;
                },
        new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i < 10; i++) {
            // 创建任务
            Worker myRunnable = new Worker("" + i);
            // 执行任务
            threadPoolExecutor.execute(myRunnable);
        }
        // 种植线程池，不接受新任务，但是有工作线程处理队列中的任务
        threadPoolExecutor.shutdown();

        while (!threadPoolExecutor.isTerminated()) {

        }
        System.out.println("Finished All Threads!");
    }
}
