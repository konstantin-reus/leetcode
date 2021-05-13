package com.reus.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > 0) {
                break;
            }
            if (i - 1 >= 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }
            int sumToFind = 0 - sorted[i];
            List<List<Integer>> allTripletsWithCur = findTwoSumZero(sorted[i], sumToFind, i + 1, sorted);
            result.addAll(allTripletsWithCur);
        }
        return result;
    }

    private List<List<Integer>> findTwoSumZero(int curNum, int sumToFind, int from, int[] sortedNums) {
        if (sortedNums.length == 0) {
            return null;
        }
        int left = from;
        int right = sortedNums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {

            int curSum = sortedNums[left] + sortedNums[right];
            if (curSum == sumToFind) {
                List<Integer> l = new ArrayList<>();
                l.add(curNum);
                l.add(sortedNums[left]);
                l.add(sortedNums[right]);
                result.add(l);
                left++;
                right--;
                while (left < right && left >= 0 && sortedNums[left - 1] == sortedNums[left]) {
                    left++;
                }
            } else if (curSum > sumToFind) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
