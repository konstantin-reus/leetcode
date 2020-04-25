package com.reus.leetcode;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReachable = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReachable && i != 0) {
                return false;
            }
            maxReachable = Math.max(i + nums[i], maxReachable);
            if (maxReachable >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
