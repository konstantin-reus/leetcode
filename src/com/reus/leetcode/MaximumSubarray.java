package com.reus.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has
 * the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,  1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int totalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            totalMax = Math.max(totalMax, curMax);
        }
        return totalMax;
    }
}
