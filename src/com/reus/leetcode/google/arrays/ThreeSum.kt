package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/3sum/
 */
class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sorted = nums.sorted()
        val result = mutableSetOf<List<Int>>()
        for (i in 0..sorted.size - 1) {
            val curEntry: List<Int> = mutableListOf(sorted[i])
            val rest = sorted.takeLast(sorted.size - i - 1).toIntArray()
            val sumToFind = 0 - sorted[i]
            val toAdd: Set<List<Int>> = twoSum(rest, sumToFind)
            if (toAdd.isEmpty().not()) {
                result.addAll(toAdd.map { it + curEntry })
            }
        }
        return result.toList()
    }

    private fun twoSum(nums: IntArray, toFind: Int): Set<List<Int>> {
        if (nums.size < 2) {
            return emptySet()
        }
        var left = 0
        var right = nums.size - 1
        val result = mutableSetOf<List<Int>>()
        while (left < right) {
            val curSum = nums[left] + nums[right]
            if (curSum == toFind) {
                result.add(listOf(nums[left], nums[right]))
                left++
            } else if (curSum > toFind) {
                right--
            } else {
                left++
            }
        }
        return result
    }
}

fun main() {
    ThreeSum().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}