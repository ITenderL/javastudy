package com.itender.juc.theadlocal;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author itender
 * @date 2022/11/2 15:24
 * @desc
 */
public class ThreadLocalTest {

    private List<String> messages = Lists.newArrayList();
    public static final ThreadLocal<ThreadLocalTest> HOLDER = ThreadLocal.withInitial(ThreadLocalTest::new);

    public static void add(String message) {
        HOLDER.get().messages.add(message);
    }

    public static List<String> clear() {
        List<String> messages = HOLDER.get().messages;
        HOLDER.remove();
        System.out.println("size : " + HOLDER.get().messages.size());
        return messages;
    }

    public static void main(String[] args) {
        ThreadLocalTest.add("itender 很帅！");
        System.out.println(HOLDER.get().messages);
        ThreadLocalTest.clear();
    }
}
