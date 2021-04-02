package com.reus.leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream
 */
public class MovingAverage {
    private final int size;
    private final LinkedList<Integer> vals = new LinkedList<>();
    private long curSum = 0;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (vals.size() < size) {
            vals.add(val);
            curSum += val;
            return curSum * 1.0 / vals.size();
        } else {
            curSum -= vals.removeFirst();
            curSum += val;
            vals.add(val);
            return curSum * 1.0 / size;
        }

    }
}
