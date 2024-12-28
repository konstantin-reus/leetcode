package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/plus-one
 */
class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        var result = IntArray(digits.size)
        val updatedLast = digits[digits.size - 1] + 1
        result[result.size - 1] = updatedLast % 10
        var carry = updatedLast / 10
        for (i in result.size - 2 downTo 0) {
            val updatedCur = (digits[i] + carry)
            result[i] = updatedCur % 10
            carry = updatedCur / 10
        }
        if (carry > 0) {
            result = intArrayOf(carry, *result)
        }
        return result

    }
}