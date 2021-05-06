package com.reus.leetcode;

import com.reus.leetcode.util.Node;

/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list
 */
public class FlattenMultilevelLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node sentinelHead = new Node(-1, null, head, null);
        flatten(sentinelHead, head);
        sentinelHead.next.prev = null;
        return sentinelHead.next;
    }

    private Node flatten(Node prev, Node curr) {
        if (curr == null) {
            return prev;
        }
        prev.next = curr;
        curr.prev = prev;
        Node next = curr.next;
        Node childTail = flatten(curr, curr.child);
        curr.child = null;
        return flatten(childTail, next);
    }
}
