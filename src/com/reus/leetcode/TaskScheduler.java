package com.reus.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/task-scheduler/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idleSlots = (maxFreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(maxFreq - 1, freq[i]);
        }
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}
