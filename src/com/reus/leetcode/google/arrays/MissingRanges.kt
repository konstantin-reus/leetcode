package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/missing-ranges/
 */
class MissingRanges {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (nums.isEmpty()) {
            return listOf(listOf(lower, upper))
        }
        if (lower < nums[0]) {
            result += listOf(lower, nums[0] - 1)
        }
        for (i in 0..nums.size - 2) {
            if (nums[i+1] - nums[i] > 1) {
                result += listOf(nums[i] + 1, nums[i+1] - 1)
            }
        }
        if (upper > nums[nums.size - 1]) {
            result += listOf(nums[nums.size - 1] + 1, upper)
        }
        return result
    }
}