package com.reus.leetcode;

/**
 * https://leetcode.com/problems/missing-number
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n * (n+1) / 2;
        for (int i = 0; i < nums.length; i++) {
            totalSum -= nums[i];
        }
        return totalSum;
    }
}
