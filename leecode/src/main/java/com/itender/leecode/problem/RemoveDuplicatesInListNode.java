package com.itender.leecode.problem;

import com.itender.leecode.entity.ListNode;

import java.util.List;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 18:29
 * @Descript: 删除有序链表中的重复元素
 */
public class RemoveDuplicatesInListNode {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = removeDuplicates(node1);
        System.out.println(listNode);
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode currNode = head;
        while (currNode.next != null) {
            if (currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
        return head;
    }
}
