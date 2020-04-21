package com.reus.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * <p>
 * For example,
 * [2,3,4], the median is 3
 * <p>
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * <p>
 * <p>
 * Example:
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class MedianFinder {
    Queue<Integer> minHeap = new PriorityQueue<Integer>();
    Queue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    public void addNum(int num) {
        if (num > findMedian()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }
        rebalanceHeaps();
    }

    private void rebalanceHeaps() {
        int diff = minHeap.size() - maxHeap.size();
        if (diff == 0 || diff == 1) {
            return;
        } else if (diff > 1) {
            for (int i = 0; i < diff - 1; i++) {
                maxHeap.add(minHeap.poll());
            }
        } else if (diff < -1) {
            for (int i = 0; i < Math.abs(diff) - 1; i++) {
                minHeap.add(maxHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek().doubleValue();
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek().doubleValue();
        } else {
            return (minHeap.peek() + maxHeap.peek() * 1.0) / 2;
        }

    }
}
