package com.reus.leetcode;

/**
 * https://leetcode.com/problems/next-permutation/
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order
 * (i.e., sorted in ascending order).
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * <p>
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 * <p>
 * Input: nums = [1]
 * Output: [1]
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        i--;
        if (i == -1) {
            reverse(0, nums);
            return;
        }
        int reverseFrom = i + 1;
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        if (j >= 0) {
            swap(i, j, nums);
        }
        reverse(reverseFrom, nums);
    }

    private void reverse(int from, int[] nums) {
        int j = nums.length - 1;
        for (int i = from; i < (from + nums.length) / 2; i++) {
            swap(i, j--, nums);
        }
    }


    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
