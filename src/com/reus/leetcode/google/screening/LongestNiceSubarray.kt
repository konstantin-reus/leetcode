package com.reus.leetcode.google.screening

/**
 * https://leetcode.com/problems/longest-nice-subarray/
 */
class LongestNiceSubarray {
    fun longestNiceSubarray(nums: IntArray): Int {
        if (nums.size == 1) {
            return 1
        }
        var left = 0
        var right = 1
        var cur = nums[left]
        var result = 1
        while (right <= nums.size - 1 && left < right) {
            if (cur and nums[right] == 0) {
                result = Math.max(result, right - left + 1)
            } else {
                while (left < right && cur and nums[right] != 0) {
                    cur = cur and nums[left].inv()
                    left++
                }
            }
            cur = cur or nums[right]
            right++
        }
        return result
    }
}
