package com.reus.leetcode;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = i == 0
                    ? 1 * nums[i]
                    : left[i - 1] * nums[i];
        }
        int c = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            right[c] = c == 0
                    ? nums[i] * 1
                    : nums[i] * right[c - 1];
            c++;
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int leftArg = i == 0
                    ? 1
                    : left[i - 1];
            int rightArg = right.length - i - 2 < 0
                    ? 1
                    : right[right.length - i - 2];
            result[i] = leftArg * rightArg;
        }
        return result;
    }
}
