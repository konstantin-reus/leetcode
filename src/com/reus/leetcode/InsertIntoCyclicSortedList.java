package com.reus.leetcode;

import com.reus.leetcode.util.Node;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/solution/
 */
public class InsertIntoCyclicSortedList {
    public Node insert(Node head, int insertVal) {
        Node n = new Node(insertVal);
        if (head == null) {
            n.next = n;
            return n;
        } else if (head.next == null) {
            head.next = n;
            n.next = head;
            return head;
        }
        Node left = head;
        Node right = head.next;
        boolean isDone = false;
        while (!isDone) {
            if (right == head ||
                    (left.val <= insertVal && insertVal <= right.val)
                    || (left.val > right.val && (insertVal <= right.val || left.val <= insertVal))) {
                isDone = true;
                break;
            } else {
                left = left.next;
                right = right.next;
            }
        }
        left.next = n;
        n.next = right;
        return head;
    }
}
