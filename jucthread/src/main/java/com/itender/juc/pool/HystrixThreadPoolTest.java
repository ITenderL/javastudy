package com.itender.juc.pool;

import com.netflix.hystrix.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HystrixThreadPoolTest {
    // 变量
    public static final int coreSize = 5, maximumSize = 100, maxQueueSize = -1, rejThresholdSize = 30;

    public static void main(String[] args) throws InterruptedException {
        HystrixCommand.Setter commandConfig = generateCommandConfig(coreSize, maximumSize, maxQueueSize, rejThresholdSize);

        // Run command once, so we can get metrics.
        runOnce(commandConfig);

        // 模拟并发
        final CountDownLatch stopLatch = new CountDownLatch(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < coreSize + maximumSize + maxQueueSize + rejThresholdSize; i++) {
            final int fi = i + 1;
            String threadName = "TestThread-" + fi;
            Thread thread = new Thread(() -> {
                try {
                    HystrixCommand<Void> command = new HystrixCommand<Void>(commandConfig) {
                        @Override
                        protected Void run() throws Exception {
                            stopLatch.await();
                            return null;
                        }
                    };
                    command.execute();
                } catch (Exception e) {
                    System.out.println("Thread:" + threadName + " got rejected.");
                    System.out.println();
                }
            });
            thread.setName(threadName);
            threads.add(thread);
            thread.start();
            Thread.sleep(200);

            System.out.println("start:" + threadName);
            printThreadPoolStatus();
        }

        // 线程执行释放
        stopLatch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }

        TimeUnit.SECONDS.sleep(70);
        printThreadPoolStatus();
    }

    static void printThreadPoolStatus() {
        for (HystrixThreadPoolMetrics threadPoolMetrics : HystrixThreadPoolMetrics.getInstances()) {
            String name = threadPoolMetrics.getThreadPoolKey().name();
            Number poolSize = threadPoolMetrics.getCurrentPoolSize();
            Number queueSize = threadPoolMetrics.getCurrentQueueSize();
            Number currentActiveCount = threadPoolMetrics.getCurrentActiveCount();
            Number currentMaximumPoolSize = threadPoolMetrics.getCurrentMaximumPoolSize();
            System.out.println("ThreadPoolKey: " + name + " PoolSize: " + poolSize );
            System.out.println("ThreadPoolKey: " + name + " QueueSize: " + queueSize);
            System.out.println("ThreadPoolKey: " + name + ", currentMaximumPoolSize: " + currentMaximumPoolSize );
            System.out.println("ThreadPoolKey: " + name + ", currentActiveCount: " + currentActiveCount );
        }
    }


    static HystrixCommand.Setter generateCommandConfig(int coreSize, int maximumSize, int maxQueueSize, int rejThresholdSize) {
        final String commandName = "TestThreadPoolCommand";
        final HystrixCommand.Setter commandConfig = HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandName))
                .andCommandKey(HystrixCommandKey.Factory.asKey(commandName))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withExecutionTimeoutEnabled(false))
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withCoreSize(coreSize)
                                .withMaximumSize(maximumSize)
                                .withKeepAliveTimeMinutes(1)
                                .withAllowMaximumSizeToDivergeFromCoreSize(true)
                                .withMaxQueueSize(maxQueueSize)
                                .withQueueSizeRejectionThreshold(rejThresholdSize));
        return commandConfig;
    }

    static void runOnce(HystrixCommand.Setter commandConfig) throws InterruptedException {
        HystrixCommand<Void> command = new HystrixCommand<Void>(commandConfig) {
            @Override
            protected Void run() {
                return null;
            }
        };
        command.execute();
        Thread.sleep(100);
    }

}