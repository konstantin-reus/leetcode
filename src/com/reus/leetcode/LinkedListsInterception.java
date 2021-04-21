package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

public class LinkedListsInterception {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = countSize(headA);
        int sizeB = countSize(headB);
        int diffLength = Math.abs(sizeA - sizeB);

        ListNode longerCur = sizeA > sizeB
                ? headA
                : headB;
        ListNode shorterCur = longerCur == headA
                ? headB
                : headA;

        for (int i = 0; i < diffLength; i++) {
            longerCur = longerCur.next;
        }

        while (longerCur != null && shorterCur != null) {
            if (longerCur == shorterCur) {
                return longerCur;
            } else {
                longerCur = longerCur.next;
                shorterCur = shorterCur.next;
            }
        }
        return null;
    }

    private int countSize(ListNode cur) {
        int i = 0;
        while (cur != null) {
            cur = cur.next;
            i++;
        }
        return i;
    }
}
