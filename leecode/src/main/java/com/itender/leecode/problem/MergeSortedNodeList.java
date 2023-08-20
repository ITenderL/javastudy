package com.itender.leecode.problem;

import com.itender.leecode.listnode.ListNode;

/**
 * @Author: ITender
 * @CreateTime: 2022-02-14 17:59
 * @Descript: 合并两个有序的链表，
 */
public class MergeSortedNodeList {
    public static void main(String[] args) {
        ListNode node1_4 = new ListNode(4, null);
        ListNode node1_2 = new ListNode(2, node1_4);
        ListNode node1_1 = new ListNode(1, node1_2);

        ListNode node2_3 = new ListNode(3, null);
        ListNode node2_2 = new ListNode(2, node2_3);
        ListNode node2_1 = new ListNode(1, node2_2);
        ListNode listNode = merge(node1_1, node2_1);
        if (listNode != null) {
            System.out.println("合并完成！");
        }
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode resultNode = new ListNode(0, null);
        ListNode p = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return resultNode.next;
    }
}
