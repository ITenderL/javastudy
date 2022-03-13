package com.itender.leecode.problem;

import com.itender.leecode.entity.ListNode;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 16:31
 * @description: 反转链表
 */
public class ReverseList {
    /**
     * 迭代链表反转
     *
     * @param head
     * @return
     */
    public static ListNode iterate(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node = iterate(node1);
        System.out.println(node);
    }

}
