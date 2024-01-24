package com.itender.leecode.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author itender
 * @date 2023/9/12 16:02
 * @desc 用队列实现栈
 */
public class MyStack1 {
    /**
     * 和栈中保持一样元素的队列
     */
    Queue<Integer> queue1;

    /**
     * 辅助队列
     */
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }


    /**
     * 解题思路：
     * 栈是一种先进后出的数据结构，而队列是一种先进先出的数据结构。
     * 我们使用两个队列queue1，和queue2.queue2为一个辅助队列。真正意义上的进栈，出栈都是由queue1来完成，
     * 当元素进栈，queue2添加元素，判断queue1中的元素是否为空，如果不为空，把queue1中的元素拿出来，放到queue2中。
     * 然后交换queue1和queue2.
     */
    /** 添加元素到栈顶 */
    public void push(int x){
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** 删除栈顶的元素并返回 */
    public int pop(){
        return queue1.poll();
    }

    /** 返回栈顶元素 */
    public int top(){
        return queue1.peek();
    }

    /** 判断栈是否为空 */
    public boolean empty(){
        return queue1.isEmpty();
    }
}
