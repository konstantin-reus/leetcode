package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LruCacheII {

    public static void main(String[] args) {
        LruCacheII l = new LruCacheII(2);
        l.put(1,1);
        l.put(2,2);
        System.out.println(l.get(1));
        l.put(3,3);
        System.out.println(l.get(2));
        l.put(4,4);
        System.out.println(l.get(1));
        System.out.println(l.get(3));
        System.out.println(l.get(4));
    }

    private final Map<Integer, Node> nodes = new HashMap<>();
    private final int capacity;
    private int size = 0;
    private Node head;
    private Node tail;


    public LruCacheII(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodes.containsKey(key)) {
            return -1;
        }
        Node node = nodes.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (nodes.containsKey(key)) {
            update(key, value);
        } else {
            insert(key, value);
        }
    }

    private void update(int key, int value) {
        Node node = nodes.get(key);
        node.val = value;
        moveToHead(node);
    }

    private void insert(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
        }
        moveToHead(node);
        nodes.put(key, node);
        size++;
        evict();

    }

    private void moveToHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        } else  if (head == node) {
            return;
        } else if (tail == node) {
            Node cur = tail;
            tail = tail.prev;
            tail.next = null;
            cur.prev = null;
            cur.next = head;
            head.prev = cur;
            head = cur;
        } else {
            if (node.prev != null) {
                node.prev.next = node.next;
            }
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }

    }

    private void evict() {
        if (size > capacity) {
            Node cur = tail;
            tail.prev.next = null;
            tail = tail.prev;
            cur.prev = null;
            nodes.remove(cur.key);
            size--;
        }
    }



    private static class Node {
        Node prev;
        Node next;
        int val;
        int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

