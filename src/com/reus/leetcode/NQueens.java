package com.reus.leetcode;

public class NQueens {
    private static int[][] solveNqueens(int n) {
        int[][] board = new int[n][n];
        solveNqueensUtil(board, n, 0);
        return board;
    }

    private static boolean solveNqueensUtil(int[][] board, int n, int column) {
        if (column >= n) {
            return true;
        }
        for (int y = 0; y < board.length; y++) {
            if (isSafe(board, y, column)) {
                board[y][column] = 1;
                if (solveNqueensUtil(board, n, column + 1)) {
                    return true;
                }
                board[y][column] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int column) {
        for (int x = 0; x < board[row].length; x++) {
            int i = board[row][x];
            if (i == 1 && x != column) return false;
        }
        for (int y = 0; y < board.length; y++) {
            int i = board[y][column];
            if (i == 1 && y != row) return false;
        }
        return isDiagonalSafe(board, row, column);
    }

    private static boolean isDiagonalSafe(int[][] board, int row, int column) {
        int x = Math.max(0, column - 1);
        for (int y = row - 1; y >= 0; y--) {
            if (x < 0) continue;
            if (board[y][x--] == 1) return false;
        }
        x = Math.max(0, column - 1);
        for (int y = row + 1; y >= 0 && y < board.length; y++) {
            if (x < 0) continue;
            if (board[y][x--] == 1) return false;
        }
        x = column + 1;
        for (int y = row - 1; y < board.length && y >= 0; y--) {
            if (x > board[y].length - 1) continue;
            if (board[y][x++] == 1) return false;
        }
        x = column + 1;
        for (int y = row + 1; y < board.length && y >= 0; y++) {
            if (x > board[y].length - 1) continue;
            if (board[y][x++] == 1) return false;
        }
        return true;
    }
}
