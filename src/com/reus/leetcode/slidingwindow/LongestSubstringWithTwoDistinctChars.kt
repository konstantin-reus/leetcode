package com.reus.leetcode.slidingwindow

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters
 */
class LongestSubstringWithTwoDistinctChars {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        var left = 0
        var right = 1
        var result = 1
        val chars = mutableMapOf<Char, Int>()
        chars[s[left]] = 1
        while (right <= s.length - 1) {
            chars[s[right]] = (chars[s[right]] ?: 0) + 1
            if (chars.size <= 2) {
                result = Math.max(result, right - left + 1)
            } else {
                while (left < right && chars.size > 2) {
                    chars[s[left]] = chars[s[left]]!! - 1
                    if (chars[s[left]] == 0) {
                        chars.remove(s[left])
                    }
                    left++
                }
            }
            right++
        }
        return result
    }
}
