package com.reus.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKfrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Queue<Pair> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while(j + 1 < nums.length && nums[j + 1] == nums[j]) {
                j++;
            }
            Pair pair = new Pair(nums[i], j - i + 1);
            heap.add(pair);
            i = j;
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll().val;
        }
        return result;
    }

    private static class Pair implements Comparable<Pair> {
        int val;
        int freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(freq, other.freq);
        }

    }
}
