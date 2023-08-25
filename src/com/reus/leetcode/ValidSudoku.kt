package com.reus.leetcode

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val isValidRows = validateRows(board)
        val isValidColumns = validateColumns(board)
        val isValidSquares = validateSquares(board)
        return isValidRows && isValidColumns && isValidSquares
    }

    private fun validateRows(board: Array<CharArray>): Boolean {
        for (i in 0..board.size - 1) {
            val isValidRow = isValidDigitSet(board[i])
            if (!isValidRow) {
                return false
            }
        }
        return true
    }

    private fun validateColumns(board: Array<CharArray>): Boolean {
        for (i in 0..8) {
            val column = CharArray(9)
            for (j in 0..8) {
                column[j] = board[j][i]
            }
            if (!isValidDigitSet(column)) {
                return false
            }
        }
        return true
    }

    private fun validateSquares(board: Array<CharArray>): Boolean {
        for (i in 0..8 step 3) {
            for (j in 0..8 step 3) {
                val result = CharArray(9)
                var cur = 0
                for (k in 0..2) {
                    for (l in 0..2) {
                        result[cur++] = board[i + k][j + l]
                    }
                }
                if (!isValidDigitSet(result)) {
                    return false
                }
            }
        }
        return true
    }

    private fun isValidDigitSet(chars: CharArray): Boolean {
        val existingDigits = mutableSetOf<Int>()
        chars.forEach { char ->
            if (char != '.') {
                val digit = char.digitToInt()
                if (existingDigits.contains(digit)) {
                    return false
                } else {
                    existingDigits.add(digit)
                }
            }
        }
        return true
    }
}
