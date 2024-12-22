package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        val maxLeft = IntArray(height.size)
        maxLeft[0] = 0
        for (i in 1..height.size - 1) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i])
        }
        val maxRight = IntArray(height.size)
        maxRight[maxRight.size - 1] = 0
        for (i in maxRight.size - 2 downTo 0) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i])
        }

        var left = 0
        var right = maxRight.size - 1
        var curMax = 0
        while (left < right) {
            val curWater = (right - left) * (Math.min(maxLeft[left], maxRight[right]))
            curMax = Math.max(curMax, curWater)
            if (maxLeft[left] > maxRight[right]) {
                right--
            } else {
                left++
            }
        }
        return curMax
    }
}
