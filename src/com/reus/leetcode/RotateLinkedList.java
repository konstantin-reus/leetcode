package com.reus.leetcode;

/**
 * https://leetcode.com/problems/rotate-list/
 */
public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        k %= size;
        if (k == 0) {
            return head;
        }
        ListNode right = head;
        ListNode left = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        right.next = head;
        ListNode newHead = left.next;
        left.next = null;
        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
