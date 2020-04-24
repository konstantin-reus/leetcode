package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

class LruCache {
    private Map<Integer, Node> cache = new HashMap<>();

    private Node head = null;
    private Node tail = null;
    private int MAX;

    public LruCache(int capacity) {
        MAX = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node result = cache.get(key);
        moveToHead(result);
        return result.value;
    }

    private void moveToHead(Node node) {
        if (head == node) return;
        Node prev = node.prev;
        Node next = node.next;

        if (prev != null) prev.next = next;
        if (next != null) {
            next.prev = node.prev;
            if (node == tail) tail = next;
        }
        if (head != null) {
            head.next = node;
        }
        node.prev = head;
        node.next = null;
        head = node;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node();
            node.key = key;
            node.value = value;
            node.prev = head;
            if (head != null) head.next = node;
            head = node;
            if (tail == null) tail = node;
            cache.put(key, node);
            if (cache.size() > MAX) removeEldest(node);
        }
    }

    private void removeEldest(Node insertedNode) {
        if (tail == null) return;
        cache.remove(tail.key);
        Node newTail = tail.next;
        if (newTail == null) return;
        newTail.prev = null;
        tail = newTail;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}
