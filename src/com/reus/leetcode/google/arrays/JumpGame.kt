package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/jump-game
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val reachability = BooleanArray(nums.size) { false }
        reachability[reachability.size - 1] = true
        var curTargetIdx = reachability.size - 1
        for (i in reachability.size - 2 downTo 0) {
            if (i + nums[i] >= curTargetIdx) {
                reachability[i] = true
                curTargetIdx = i
            }
        }
        return reachability[0]
    }
}

fun main() {
    JumpGame().canJump(intArrayOf(3,2,1,0,4))
}