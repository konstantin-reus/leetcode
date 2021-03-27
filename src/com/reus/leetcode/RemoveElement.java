package com.reus.leetcode;

/**
 * https://leetcode.com/problems/remove-element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int right = findRight(nums, nums.length - 1, val);
        int left = 0;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right = findRight(nums, right - 1, val);
            }
            left++;
        }
        return left;
    }

    private int findRight(int[] nums, int pos, int val) {
        for (int i = pos; i >= 0; i--) {
            if (nums[i] != val) {
                return i;
            }
        }
        return -1;
    }
}
