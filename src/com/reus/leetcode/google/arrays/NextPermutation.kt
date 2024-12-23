package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/next-permutation/
 */
class NextPermutation {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size == 1) {
            return
        }
        val pivotIndex = findPivotIndex(nums)
        val switchWithPivot = findNextMaxRightIndex(pivotIndex = pivotIndex, nums = nums)
        switchPivot(pivotIndex = pivotIndex, switchIndex = switchWithPivot, nums = nums)
    }

    fun findPivotIndex(nums: IntArray): Int {
        var right = nums.size - 1
        var left = right - 1
        while (left >= 0) {
            if (nums[left] < nums[right]) {
                return left
            } else {
                left--
                right--
            }
        }
        return -1
    }

    fun findNextMaxRightIndex(pivotIndex: Int, nums: IntArray): Int {
        if (pivotIndex == -1) {
            return -1
        }
        val pivot = nums[pivotIndex]
        var minValueIndex = 1_000
        for (i in pivotIndex + 1..nums.size - 1) {
            if (nums[i] > pivot) {
                if (minValueIndex == 1_000 || nums[i] <= nums[minValueIndex]) {
                    minValueIndex = i
                }
            }
        }
        return minValueIndex
    }

    fun switchPivot(pivotIndex: Int, switchIndex: Int, nums: IntArray): Unit {
        if (pivotIndex == -1) {
            nums.sort()
            return
        }
        val tmp = nums[pivotIndex]
        nums[pivotIndex] = nums[switchIndex]
        nums[switchIndex] = tmp
        val toTake = nums.size - pivotIndex - 1
        val tail = nums.takeLast(toTake).sorted()
        for (i in 0..tail.size - 1) {
            nums[pivotIndex + 1 + i] = tail[i]
        }
    }
}

fun main() {
    NextPermutation().nextPermutation(intArrayOf(1, 2, 4, 9, 8, 7, 6, 5, 3))
}