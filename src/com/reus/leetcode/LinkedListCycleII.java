package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        boolean cycleFound = false;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
            if (fast == slow) {
                cycleFound = true;
                break;
            }
        }
        if (!cycleFound) {
            return null;
        }
        ListNode cur = head;
        while (cur != fast) {
            cur = cur.next;
            fast = fast.next;
        }
        return cur;

    }
}
