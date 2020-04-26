package com.reus.leetcode;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = 0;
        maxRight[maxRight.length - 1] = 0;
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }
}
