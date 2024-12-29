package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/minimum-window-substring
 */
class MinimumWindowsSubstring {
    fun minWindow(s: String, t: String): String {
        if (t.length > s.length) {
            return ""
        }
        var leftIdx = 0
        var rightIdx = 0
        var result = ""
        val toMatch = t.toCharToCount()
        var curWindow = mutableMapOf<Char, Int>()

        while (leftIdx <= rightIdx && rightIdx < s.length) {
            var leftChar = s[leftIdx]
            val rightChar = s[rightIdx]
            curWindow[rightChar] = (curWindow[rightChar] ?: 0) + 1
            var isValidWindow = curWindow.includesAll(toMatch)
            while (isValidWindow) {
                if (result == "" || result.length > rightIdx - leftIdx + 1) {
                    result = s.substring(leftIdx, rightIdx + 1)
                }
                curWindow[leftChar] = curWindow[leftChar]!! - 1
                leftIdx = Math.min(leftIdx + 1, s.length - 1)
                leftChar = s[leftIdx]
                isValidWindow = curWindow.includesAll(toMatch)
            }
            rightIdx++
        }
        return result

    }

    private fun String.toCharToCount(): Map<Char, Int> = this.toCharArray()
        .groupBy { it }.mapValues { (_, charOccurrence) -> charOccurrence.size }

    private fun Map<Char, Int>.includesAll(other: Map<Char, Int>): Boolean {
        return this.keys.containsAll(other.keys) &&
                other.entries.all { (char, count) -> this[char]?.let { it >= count } ?: false }
    }
}

fun main() {
    println(MinimumWindowsSubstring().minWindow("ADOBECODEBANC", "ABC"))
}