package com.itender.newfeature;

import org.springframework.util.StopWatch;

/**
 * @author itender
 * @date 2022/8/29 14:48
 * @desc
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start("A");
        Thread.sleep(500);
        sw.stop();
        sw.start("B");
        Thread.sleep(300);
        sw.stop();
        sw.start("C");
        Thread.sleep(200);
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.prettyPrint());
    }
}
