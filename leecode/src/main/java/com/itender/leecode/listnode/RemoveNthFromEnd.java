package com.itender.leecode.listnode;

/**
 * @author : itender
 * @date : 2023/08/19/ 18:36
 * @desc : 移除链表倒数第n个元素
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(removeNthFromEnd(node1, 2));
    }


    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 示例 1：
     *
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     *
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     *
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     *
     *
     * @param head
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;
        ListNode fast = dumyHead;
        ListNode slow = dumyHead;
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumyHead.next;
    }
}
