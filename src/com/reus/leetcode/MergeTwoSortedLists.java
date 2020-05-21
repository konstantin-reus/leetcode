package com.reus.leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = merge(l1, l2);
        ListNode tail = result;
        while (l1 != null || l2 != null) {
            if (l1 != null && l1.val == tail.val) {
                l1 = l1.next;
            } else if (l2 != null && l2.val == tail.val) {
                l2 = l2.next;
            }
            if (l1 == null && l2 == null) {
                return result;
            }
            tail.next = merge(l1, l2);
            tail = tail.next;
        }
        return result;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return new ListNode(l2.val);
        } else if (l2 == null && l1 != null) {
            return new ListNode(l1.val);
        }
        return l1.val <= l2.val
                ? new ListNode(l1.val)
                : new ListNode(l2.val);
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
