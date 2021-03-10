package com.reus.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * <p>
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * O(n) solution
 */
public class SortedSquares {
    public static void main(String[] args) {
        SortedSquares s = new SortedSquares();
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        int[] result = s.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, -4, -3, -2, -1})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, -4, -3, -2, -1, 0})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{1, 2, 3, 4, 5})));
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int negativePointer = -1;
        int positivePointer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativePointer = i; //minimal negative found
            }
            if (nums[i] >= 0 && positivePointer == -1) {
                positivePointer = i; //minimal positive found
            }
        }

        for (int i = 0; i < result.length; i++) {
            if (negativePointer == -1 && positivePointer == -1) {
                return result;
            }
            if (positivePointer == -1 ||
                    (negativePointer != -1 && Math.abs(nums[negativePointer]) < Math.abs(nums[positivePointer]))) {
                result[i] = nums[negativePointer] * nums[negativePointer];
                negativePointer--;
                if (negativePointer < 0) {
                    negativePointer = -1;
                }
            } else if (negativePointer == -1 || (
                    positivePointer != -1 && Math.abs(nums[negativePointer]) >= Math.abs(nums[positivePointer]))) {
                result[i] = nums[positivePointer] * nums[positivePointer];
                positivePointer++;
                if (positivePointer > nums.length - 1) {
                    positivePointer = -1;
                }
            }
        }
        return result;
    }
}
