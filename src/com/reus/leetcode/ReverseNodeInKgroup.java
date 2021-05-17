package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class ReverseNodeInKgroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newTail = head;
        ListNode cur = head;
        int c = 0;
        while (c < k && cur != null) {
            cur = cur.next;
            c++;
        }
        ListNode newHead = head;
        if (c == k) {
            newHead = reverse(head, k);
            newTail.next = reverseKGroup(cur, k);
        }
        return newHead;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        int c = 0;
        while (cur != null && c < k) {
            cur = cur.next;
            c++;
        }
        if (c < k) {
            return head;
        }
        cur = head;
        ListNode reverseHead = null;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = next;
        }
        return reverseHead;
    }
}
