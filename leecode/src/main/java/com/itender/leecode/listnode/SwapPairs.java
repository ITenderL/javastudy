package com.itender.leecode.listnode;

/**
 * @author : itender
 * @date : 2023/08/19/ 18:23
 * @desc :
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(swapPairs(node1));
    }

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：[1]
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dumyHead = new ListNode(0);
        dumyHead.next = head;
        ListNode cur = dumyHead;
        ListNode fistNode;
        ListNode secondNode;
        ListNode temp;
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            fistNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = fistNode;
            fistNode.next = temp;
            cur = fistNode;
        }
        return dumyHead.next;
    }
}
