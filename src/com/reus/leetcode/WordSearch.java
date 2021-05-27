package com.reus.leetcode;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] included = new boolean[board.length][board[0].length];
                    boolean resultFromCurCell = dfs(board, 0, word, i, j, included);
                    if (resultFromCurCell) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int curPos, String searchWord, int row, int column, boolean[][] included) {
        if (curPos == searchWord.length()) {
            return true;
        }
        if (row < 0 || column < 0 || row >= board.length || column >= board[row].length) {
            return false;
        }
        if (searchWord.charAt(curPos) != board[row][column]) {
            return false;
        }
        if (included[row][column]) {
            return false;
        }

        included[row][column] = true;
        boolean result = dfs(board, curPos + 1, searchWord, row - 1, column, included)
                || dfs(board, curPos + 1, searchWord, row - 1, column, included)
                || dfs(board, curPos + 1, searchWord, row, column - 1, included)
                || dfs(board, curPos + 1, searchWord, row, column + 1, included)
                || dfs(board, curPos + 1, searchWord, row + 1, column, included);
        if (!result) {
            included[row][column] = false;
        }
        return result;
    }

}
