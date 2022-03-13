package com.itender.juc.pool;

import java.util.concurrent.*;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-23 14:59
 * @Description: 线程池
 */
public class Demo1 {
    public static void main(String[] args) {
        // 固定大小的线程池
        // ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        // 单例的线程池，只有一个运行的线程
        // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        // 可缓存的线程池
        // ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        /**
         * 自定义线程池
         * 拒绝策略：
         *     new ThreadPoolExecutor.AbortPolicy()：
         *     new ThreadPoolExecutor.CallerRunsPolicy()：
         *     new ThreadPoolExecutor.DiscardPolicy()：
         *     new ThreadPoolExecutor.DiscardOldestPolicy()：
         * 如何设置最大线程数：
         *     1.cpu 密集型：电脑几核就是几，保证cpu效率最高
         *     2.IO 密集型：程序中十分消耗IO的任务的个数，线程数要大于这个数。一般是这个数的两倍
         *     程序： 15个大任务
         *
         */
        // 获取机器的cpu核数
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                // 抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i <= 9; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "ok!");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }


}
