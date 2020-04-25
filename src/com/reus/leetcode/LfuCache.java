package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LfuCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;
    private int MAX_CAPACITY;

    public LfuCache(int capacity) {
        MAX_CAPACITY = capacity;
    }

    public int get(int key) {
        if (MAX_CAPACITY == 0) return -1;
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        node.used = node.used + 1;
        rebalance(node);
        return node.value;
    }

    private void rebalance(Node node) {
        Node next = node.next;
        if (next == null) {
            return;
        }
        while (node != null && next != null && next.used <= node.used) {
            node.next = next.next;
            if (node.next != null) node.next.prev = node;
            next.next = node;
            next.prev = node.prev;
            if (node.prev != null) {
                node.prev.next = next;
            }
            if (node == tail) {
                tail = next;
            }
            if (next == head) {
                head = node;
            }
            node.prev = next;
            next = node.next;
        }
    }

    public void put(int key, int value) {
        if (MAX_CAPACITY == 0) return;
        Node node = cache.get(key);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            node.used = 0;
            addNode(node);
        } else {
            node.used = node.used + 1;
            node.value = value;
            rebalance(node);
        }
    }

    private void checkCacheSize() {
        if (cache.size() > MAX_CAPACITY - 1) {
            removeFromTail();
        }
    }

    private void removeFromTail() {
        cache.remove(tail.key);
        Node next = tail.next;
        if (next != null) {
            next.prev = null;
            tail = next;
        }
    }

    private void addNode(Node node) {
        checkCacheSize();
        cache.put(node.key, node);
        if (head == null) head = node;
        if (tail == null) {
            tail = node;
        } else {

            tail.prev = node;
            node.next = tail;
            tail = node;
            rebalance(node);
        }
    }

    private static class Node {
        Node next;
        Node prev;
        int key;
        int value;
        int used;
    }
}
