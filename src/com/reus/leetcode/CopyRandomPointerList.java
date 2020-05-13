package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointerList {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNew = new HashMap<>();
        Node oldCur = head;
        while (oldCur != null) {
            Node created = oldToNew.get(oldCur);
            if (created == null) {
                created = new Node(oldCur.val);
                oldToNew.put(oldCur, created);
                oldCur = oldCur.next;
            }
        }
        oldCur = head;
        while (oldCur != null) {
            Node newNode = oldToNew.get(oldCur);
            newNode.next = oldToNew.get(oldCur.next);
            newNode.random = oldCur.random == null
                    ? null
                    : oldToNew.get(oldCur.random);
            oldCur = oldCur.next;
        }
        return oldToNew.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
