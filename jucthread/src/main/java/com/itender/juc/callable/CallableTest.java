package com.itender.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: ITender
 * @Description:
 * @CreateTime: 2022-02-19 21:06
 */
public class CallableTest {
    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask<>(myThread);
        new Thread(futureTask, "callable").start();
        System.out.println(futureTask.get());
    }
}

class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("callable");
        return "123";
    }
}
