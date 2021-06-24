package com.reus.leetcode;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int pos = bSearch(nums, 0, nums.length - 1, target);
        if (pos != -1) {
            return pos;
        }
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    private int bSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        return nums[middle] > target
                ? bSearch(nums, left, middle - 1, target)
                : bSearch(nums, middle + 1, right, target);
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        if (target > nums[right]) {
            return right + 1;
        } else if (target < nums[left]) {
            return left;
        }
        if (left > right) {
            return left;
        }
        int middle = left + (right - left) / 2;
        if (nums[middle] < target) {
            return searchInsert(nums, target, middle + 1, right);
        } else {
            return searchInsert(nums, target, left, middle - 1);
        }
    }
}
