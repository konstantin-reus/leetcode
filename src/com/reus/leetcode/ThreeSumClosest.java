package com.reus.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = Integer.MAX_VALUE;
        int minDelta = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int curSum = nums[left] + nums[right] + nums[i];
                if (curSum == target) {
                    return curSum;
                } else if (curSum < target) {
                    left++;
                } else if (curSum > target) {
                    right--;
                }
                int delta = Math.abs(target - curSum);
                if (delta < minDelta) {
                    minDelta = delta;
                    minSum = curSum;
                }
            }
        }
        return minSum;
    }
}
