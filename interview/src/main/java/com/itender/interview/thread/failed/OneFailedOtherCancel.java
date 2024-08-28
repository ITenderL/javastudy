package com.itender.interview.thread.failed;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author itender
 * @date 2023/11/03/ 12:03
 * @desc 一个任务执行失败，其他任务都结束
 */
public class OneFailedOtherCancel {
    public static void main(String[] args) throws IOException {
        MyTask t1 = new MyTask("t1", 3, true);
        MyTask t2 = new MyTask("t2", 4, true);
        MyTask t3 = new MyTask("t3", 1, false);

        t1.start();
        t2.start();
        t3.start();
        System.in.read();
    }

    public static class MyTask extends Thread {
        private String name;
        private int timeSeconds;
        private boolean success;

        public MyTask(String name, int timeSeconds, boolean success) {
            this.name = name;
            this.timeSeconds = timeSeconds;
            this.success = success;
        }

        @SneakyThrows
        @Override
        public void run() {
            // 模拟任务执行
            // 实际的任务时间是不确定的，可能在执行可能在io
            TimeUnit.SECONDS.sleep(timeSeconds);

            System.out.println(name + " 任务结束！");
        }
    }
}
