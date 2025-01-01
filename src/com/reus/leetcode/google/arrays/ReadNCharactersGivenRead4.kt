package com.reus.leetcode.google.arrays

import java.util.*

/**
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times
 */
class ReadNCharactersGivenRead4 {
    /**
     * The read4 API is defined in the parent class Reader4.
     * fun read4(buf4:CharArray): Int {}
     */
    fun read4(buf: CharArray): Int {
        // provided by leetcode in the parent class
        TODO()
    }

    init {
        pointer = 0
        readChars = charArrayOf()
    }

    /**
     * @param  buf Destination buffer
     * @param  n   Number of characters to read
     * @return     The number of actual characters read
     */
    fun read(buf: CharArray, n: Int): Int {
        val pointerBefore = pointer
        if (pointer + n - 1 >= readChars.size) {
            for (i in 0..n / 4) {
                val readBuf = CharArray(4)
                val readBytes = read4(readBuf)
                if (readBytes == 0) {
                    break
                } else {
                    for (i in 0..readBytes - 1) {
                        readChars += readBuf[i]
                    }
                }
            }
        }
        for (i in 0..n - 1) {
            if (pointer < readChars.size) {
                buf[i] = readChars[pointer]
                pointer++
            } else {
                break
            }
        }
        val result = pointer - pointerBefore
        return result
    }

    private companion object {
        private var readChars = charArrayOf()
        private var pointer = 0
    }
}
