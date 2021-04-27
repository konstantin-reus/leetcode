package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 */
public class RemoveLinkedListNodes {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode prev = sentinel;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return sentinel.next;
    }
}
