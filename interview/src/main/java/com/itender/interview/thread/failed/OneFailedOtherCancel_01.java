package com.itender.interview.thread.failed;

import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author itender
 * @date 2023/11/03/ 12:03
 * @desc 一个任务执行失败，其他任务都结束   交替输出
 */
public class OneFailedOtherCancel_01 {
    public static void main(String[] args) throws IOException {
        MyTask t1 = new MyTask("t1", 3, true);
        MyTask t2 = new MyTask("t2", 4, true);
        MyTask t3 = new MyTask("t3", 1, false);
        // t3.setResult(Result.FAILED);

        List<MyTask> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        // 启动线程
        list.forEach(Thread::start);
        // 启动监视
        for (; ; ) {
            for (MyTask myTask : list) {
                if (myTask.getResult() == Result.FAILED) {
                    System.exit(0);
                }
            }
        }
    }

    public enum Result {
        NOTEND,
        SUCCESS,
        FAILED
    }

    public static class MyTask extends Thread {
        private Result result = Result.NOTEND;
        private String name;
        private int timeSeconds;
        private boolean success;

        public Result getResult() {
            return result;
        }

        public void setResult(Result result) {
            this.result = result;
        }

        public int getTimeSeconds() {
            return timeSeconds;
        }

        public void setTimeSeconds(int timeSeconds) {
            this.timeSeconds = timeSeconds;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

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

            result = success ? Result.SUCCESS : Result.FAILED;
        }
    }
}
