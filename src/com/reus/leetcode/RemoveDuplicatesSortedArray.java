package com.reus.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int left = i;
            int right = left + 1;
            while (right < l && nums[left] == nums[right]) {
                right++;
            }
            int repeated = right - left - 1;
            if (repeated > 0) {
                shiftLeft(nums, right, repeated);
                l -= repeated;
            }

        }
        return l;
    }

    private void shiftLeft(int[] nums, int pos, int distance) {
        for (int i = pos; i < nums.length && i - distance >= 0; i++) {
            nums[i - distance] = nums[i];
        }
    }
}
