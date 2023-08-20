package com.itender.leecode.problem;

import com.itender.leecode.listnode.ListNode;

/**
 * @author itender
 * @date 2022/10/31 16:15
 * @desc 链表中环的入口
 */
public class ListNodeCycleStart {
    public static void main(String[] args) {

    }

    public ListNode findListNodeCycleStart(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
