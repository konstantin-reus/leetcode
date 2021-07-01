package com.reus.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-stack
 */
public class MaximumFrequencyStack {
    Queue<Node> heap = new PriorityQueue<>(Comparator.comparing(Node::getFreq).thenComparing(Node::getPosition).reversed());
    Map<Integer, Integer> valToFreq = new HashMap<>();
    int curPos = 0;

    public void push(int val) {
        valToFreq.putIfAbsent(val, 0);
        int freq = valToFreq.get(val) + 1;
        valToFreq.put(val, freq);
        Node node = new Node(val, freq, curPos++);

        heap.add(node);
    }

    public int pop() {
        Node result = heap.poll();
        valToFreq.put(result.val, valToFreq.get(result.val) - 1);
        return result.val;
    }

    private static class Node {
        int val;
        int freq;
        int position;
        public Node(int val, int freq, int position) {
            this.val = val;
            this.freq = freq;
            this.position = position;
        }

        public int getVal() {
            return val;
        }

        public int getFreq() {
            return freq;
        }

        public int getPosition() {
            return position;
        }
    }
}
