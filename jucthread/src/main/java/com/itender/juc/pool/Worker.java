package com.itender.juc.pool;

import cn.hutool.core.date.DateUtil;

/**
 * @author itender
 * @date 2023/8/7 14:41
 * @desc
 */
public class Worker implements Runnable {

    private String command;

    public Worker(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + command + " startTie = " + DateUtil.now());
        processCommand();
        System.out.println(Thread.currentThread().getName() + command +  " endTime = " + DateUtil.now());
    }

    private void processCommand() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + command +" 处理任务逻辑。。。。。。。。");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
