package com.itender.leecode.entity;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 18:00
 * @Descript: 链表实体类
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
