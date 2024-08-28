package com.itender.leecode.stackandqueue;

import java.util.Stack;

/**
 * @author itender
 * @date 2023/9/12 15:48
 * @desc 用栈实现队列
 */
public class MyQueue1 {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue1() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

/**
 * 思路：使用两个栈，一个栈负责添加元素，一个栈负责弹出元素。队列是先进先出的数据结构，而栈是先进后出的数据结构。
 * 当元素进入队列，我们将元素入栈到stackIn，当出栈的时候，首先看下stackOut中的元素是否为空，如果不为空直接弹出stackOut中的元素。
 * 如果stackOut为空，先将stackIn中的元素出栈，然后将stackIn中的所有出栈的元素进栈到stackOut中，然后再出栈。
 */
    /**
     * 添加元素到队尾
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 删除队头的元素并返回
     */
    public int pop() {
        beforeOut();
        return stackOut.pop();
    }

    /**
     * 返回队头元素
     */
    public int peek() {
        beforeOut();
        return stackOut.peek();
    }

    /**
     * 判断队列是否为空
     */
    public boolean empty() {
        return stackOut.isEmpty() && stackIn.isEmpty();
    }

    public void beforeOut() {
        if (!stackOut.isEmpty()) {
            return;
        }
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
