package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
        } else {
            ListNode cur = head.next;
            while (cur != null && cur.val == head.val) {
                cur = cur.next;
            }
            return deleteDuplicates(cur);
        }
        return head;
    }
}
