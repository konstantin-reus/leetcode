package com.reus.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> threeSum = getThreeSum(nums, i + 1, target - nums[i]);
            if (!threeSum.isEmpty()) {
                for (List<Integer> l : threeSum) {
                    l.add(0, nums[i]);
                    result.add(l);
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> getThreeSum(int[] nums, int pos, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = pos; i < nums.length; i++) {
            List<List<Integer>> twoSum = getTwoSum(nums, i + 1, target - nums[i]);
            if (!twoSum.isEmpty()) {
                for (List<Integer> l : twoSum) {
                    l.add(0, nums[i]);
                    result.add(l);
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> getTwoSum(int[] nums, int pos, int target) {
        int left = pos;
        int right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(nums[left]);
                l.add(nums[right]);
                result.add(l);
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
                right--;
            }
        }
        return result;
    }
}
