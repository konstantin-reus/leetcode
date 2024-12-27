package com.reus.leetcode.google.arrays

/**
 * https://leetcode.com/problems/rotate-image/
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        transpose(matrix)
        mirror(matrix)
    }

    private fun mirror(matrix: Array<IntArray>) {
        for (y in 0..matrix.size - 1) {
            for (x in 0..(matrix[y].size / 2) - 1) {
                val tmp = matrix[y][x]
                matrix[y][x] = matrix[y][matrix[y].size - 1 - x]
                matrix[y][matrix[y].size - 1 - x] = tmp
            }
        }
    }

    private fun transpose(matrix: Array<IntArray>) {
        for (y in 0..matrix.size - 1) {
            for (x in y + 1..matrix[y].size - 1) {
                val tmp = matrix[x][y]
                matrix[x][y] = matrix[y][x]
                matrix[y][x] = tmp
            }
        }
    }
}

fun main() {
    RotateImage().rotate(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9),
    ))
}