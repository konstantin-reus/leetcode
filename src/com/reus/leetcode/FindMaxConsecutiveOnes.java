package com.reus.leetcode;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array if you can
 * flip at most one 0.
 * <p>
 * Example 1:
 * Input: [1,0,1,1,0]
 * Output: 4
 * Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
 * After flipping, the maximum number of consecutive 1s is 4.
 * <p>
 * Note:
 * <p>
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * Follow up:
 * What if the input numbers come in one by one as an infinite stream? In other words,
 * you can't store all numbers coming from the stream as it's too large to hold in memory.
 * Could you solve it efficiently?
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int curMax = Integer.MIN_VALUE;
        boolean isValid = true;
        boolean hasZero = false;
        while (left <= right && left < nums.length && right < nums.length) {
            if (nums[right] == 0) {
                if (hasZero) {
                    isValid = false;
                } else {
                    hasZero = true;
                }
            }
            if (isValid) {
                curMax = Math.max(curMax, right - left + 1);
                right++;
            } else {
                left++;
                hasZero = hasZero && nums[left - 1] == 1;
                if (nums[left - 1] == 0) {
                    isValid = true;
                }
            }
        }
        return curMax;
    }
}
