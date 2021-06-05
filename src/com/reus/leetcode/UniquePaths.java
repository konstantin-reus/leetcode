package com.reus.leetcode;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        path[0][0] = 1;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < path[y].length; x++) {
                if (x == 0 && y == 0) {
                    continue;
                }
                int top = y - 1 >= 0
                        ? path[y-1][x]
                        : 0;
                int left = x - 1 >= 0
                        ? path[y][x - 1]
                        : 0;
                path[y][x] = top + left;
            }
        }
        return path[m - 1][n - 1];
    }
}
