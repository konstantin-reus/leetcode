package com.reus.leetcode;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);

            if (nums[cur] < 0) {
                return cur;
            } else {
                nums[cur] *= -1;
            }
        }
        return -1;
    }
}
