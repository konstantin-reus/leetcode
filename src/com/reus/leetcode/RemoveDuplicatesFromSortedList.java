package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.val == head.val) {
            cur = cur.next;
        }
        head.next = deleteDuplicates(cur);
        return head;
    }
}
