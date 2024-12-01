package com.reus.leetcode.google.screening

import java.util.TreeMap

/**
 * https://leetcode.com/problems/odd-even-jump/
 */
class OddEvenJumps {
    fun oddEvenJumps(arr: IntArray): Int {
        val reachabilityOdd = BooleanArray(arr.size) { false }
        val reachabilityEven = BooleanArray(arr.size) { false }
        reachabilityOdd[reachabilityOdd.size - 1] = true
        reachabilityEven[reachabilityEven.size - 1] = true
        val valueToIndex = TreeMap<Int, Int>()
        valueToIndex[arr[arr.size - 1]] = arr.size - 1

        for (i in arr.size - 2 downTo 0) {
            val nextOddJumpIndex = findNextOddJumpIndex(arr[i], valueToIndex)
            val nextEvenJumpIndex = findNextEvenJumpIndex(arr[i], valueToIndex)
            val isOddJumpPossible = nextOddJumpIndex != null && reachabilityEven[nextOddJumpIndex]
            val isEvenJumpPossible = nextEvenJumpIndex != null && reachabilityOdd[nextEvenJumpIndex]
            reachabilityOdd[i] = isOddJumpPossible
            reachabilityEven[i] = isEvenJumpPossible
            valueToIndex[arr[i]] = i
        }
        return reachabilityOdd.toList().filter { it }.count()
    }

    private fun findNextOddJumpIndex(cur: Int, valueToIndex: TreeMap<Int, Int>): Int? {
        return valueToIndex.ceilingEntry(cur)?.let { (_, index) -> index }
    }

    private fun findNextEvenJumpIndex(cur: Int, valueToIndex: TreeMap<Int, Int>): Int? {
        return valueToIndex.floorEntry(cur)?.let { (_, index) -> index }
    }
}
