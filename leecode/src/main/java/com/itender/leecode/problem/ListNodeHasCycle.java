package com.itender.leecode.problem;

import com.itender.leecode.listnode.ListNode;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 18:41
 * @Descript: 判断链表中是否有环
 */
public class ListNodeHasCycle {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针法
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }
}
