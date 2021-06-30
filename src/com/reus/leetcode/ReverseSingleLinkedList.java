package com.reus.leetcode;

import com.reus.leetcode.util.ListNode;

public class ReverseSingleLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next = new ListNode(5);

        ReverseSingleLinkedList r = new ReverseSingleLinkedList();
//        ListNode result = r.reverseList(head);
//        System.out.println(result);
    }

//    public ListNode reverseList(ListNode head) {
//        return reverse(null, head, head.next);
//    }

//    private ListNode reverse(ListNode prev, ListNode cur) {
//        if (cur == null) {
//            return prev;
//        }
//        cur.next = prev;
//        if (next == null) {
//            return cur;
//        }
//        return reverse(cur, cur.next, cur.next.next);
//    }
}
