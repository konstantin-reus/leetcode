package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 1) {
            return head;
        }
        ListNode front = head;
        ListNode back = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        ListNode beforeBack = null;
        while (front != null) { // by the end front points to null, back to Nth from the end node
            front = front.next;
            beforeBack = back;
            back = back.next;
        }
        if (beforeBack == null) { // the head of the list is to be removed
            return back.next;
        }
        beforeBack.next = back.next;
        return head;
    }
}
