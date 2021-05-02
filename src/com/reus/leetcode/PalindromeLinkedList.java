package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        int distance = 0;
        ListNode firstHalfTail = null;
        while (slow != null && fast != null && fast.next != null) {
            firstHalfTail = slow;
            slow = slow.next;
            fast = fast.next.next;
            distance++;
        }
        firstHalfTail.next = reverse(slow);
        ListNode firstHalfP = head;
        ListNode secondHalfP = firstHalfTail.next;
        for (int i = 0; i < distance; i++) {
            if (firstHalfP.val != secondHalfP.val) {
                return false;
            }
            firstHalfP = firstHalfP.next;
            secondHalfP = secondHalfP.next;
        }
        firstHalfTail.next = reverse(firstHalfTail.next);
        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode next = cur.next;
        head.next = null;
        while (cur != null) {
            cur.next = head;
            head = cur;
            cur = next;
            if (cur != null) {
                next = cur.next;
            } else {
                return head;
            }
        }
        return head;
    }
}
