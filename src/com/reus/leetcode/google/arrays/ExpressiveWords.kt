package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/expressive-words/
 */
class ExpressiveWords {
    fun expressiveWords(s: String, words: Array<String>): Int {
        var count = 0
        for (word in words) {
            if (compare(s, word)) {
                count++
            }
        }
        return count
    }

    fun compare(s: String, word: String): Boolean {
        if (word.length > s.length) {
            return false
        }
        var i = 0
        var j = 0
        while (i < s.length && j < word.length) {
            if (s[i] != word[j]) {
                return false
            }
            val iCount = runLength(s, i)
            val jCount = runLength(word, j)
            i += iCount
            j += jCount
            if (jCount > iCount || (iCount < 3 && iCount != jCount)) {
                return false
            }
        }
        return j >= word.length && i >= s.length
    }

    fun runLength(s: String, pos: Int): Int {
        var count = 1
        var i = pos
        while (i < s.length - 1 && s[i + 1] == s[i]) {
            count++
            i++
        }
        return count
    }
}
