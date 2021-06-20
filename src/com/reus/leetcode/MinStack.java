package com.reus.leetcode;

public class MinStack {
    private Node minNode = null;
    private Node head;
    private Node tail;

    public void push(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            minNode = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            node.nextMin = minNode;
            if (tail.val < minNode.val) {
                minNode = tail;
            }
        }
    }

    public void pop() {
        Node cur = tail;
        if (tail == minNode) {
            minNode = tail.nextMin;
        }
        Node prev = tail.prev;
        if (prev != null) {
            prev.next = null;
        }
        tail = prev;
        if (tail == null) {
            head = null;
        }
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return minNode.val;
    }

    private static class Node {
        Node prev;
        Node next;
        int val;
        Node nextMin;

        public Node(int val) {
            this.val = val;
        }
    }
}
