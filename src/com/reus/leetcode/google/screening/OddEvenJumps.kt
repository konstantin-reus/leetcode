package com.reus.leetcode.google.screening

class OddEvenJumps {
    fun oddEvenJumps(arr: IntArray): Int {
        val reachabilityOdd = BooleanArray(arr.size) { false }
        val reachabilityEven = BooleanArray(arr.size) { false }
        reachabilityOdd[reachabilityOdd.size - 1] = true
        reachabilityEven[reachabilityEven.size - 1] = true
        for (i in arr.size - 2 downTo 0) {
            val nextOddJumpIndex = findNextOddJumpIndex(arr, i)
            val nextEvenJumpIndex = findNextEvenJumpIndex(arr, i)
            val isOddJumpPossible = nextOddJumpIndex != null && reachabilityEven[nextOddJumpIndex]
            val isEvenJumpPossible = nextEvenJumpIndex != null && reachabilityOdd[nextEvenJumpIndex]
            reachabilityOdd[i] = isOddJumpPossible
            reachabilityEven[i] = isEvenJumpPossible
        }
        return reachabilityOdd.toList().filter {it}.count()
    }

    private fun findNextOddJumpIndex(arr: IntArray, startFrom: Int): Int? {
        val base = arr[startFrom]
        var result: Int? = null;
        for (i in startFrom + 1..arr.size - 1) {
            if (arr[i] >= base && (result == null || arr[i] < arr[result])) {
                result = i
            }
        }
        return result
    }

    private fun findNextEvenJumpIndex(arr: IntArray, startFrom: Int): Int? {
        val base = arr[startFrom]
        var result: Int? = null;
        for (i in startFrom + 1..arr.size - 1) {
            if (arr[i] <= base && (result == null || arr[i] > arr[result])) {
                result = i
            }
        }
        return result
    }
}

fun main() {
    val result = OddEvenJumps().oddEvenJumps(intArrayOf(81,54,96,60,58))
    println(result)
}