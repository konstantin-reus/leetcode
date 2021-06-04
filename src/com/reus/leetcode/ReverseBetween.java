package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode cur = head;
        for (int i = 0; i < right - 1; i++) {
            cur = cur.next;
        }
        ListNode newHead = head;
        if (left == 1) {
            newHead = cur;
        }
        ListNode tail = cur.next;
        ListNode prev = null;
        cur = head;
        for (int i = 0; i < left - 1; i++) {
            prev = cur;
            cur = cur.next;
        }
        ListNode beforeLeft = prev;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = cur.next;
            if (i == 0) {
                cur.next = tail;
            } else {
                cur.next = prev;
            }
            prev = cur;
            cur = next;
        }
        if (beforeLeft != null) {
            beforeLeft.next = prev;
        }
        return newHead;
    }
}
