package com.reus.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class RottingOranges {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        Queue<Integer> heap = new PriorityQueue<>();
        for (ListNode list : lists) {
            while (list != null) {
                heap.add(list.val);
                list = list.next;
            }
        }
        if (heap.isEmpty()) {
            return null;
        }
        ListNode newHead = new ListNode(heap.poll());
        ListNode cur = newHead;
        while (!heap.isEmpty()) {
            cur.next = new ListNode(heap.poll());
            cur = cur.next;
        }
        return newHead;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
