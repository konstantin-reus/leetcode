package com.reus.leetcode;

/**
 *
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom
 * right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] aux = new int[grid.length][grid[0].length];
        for (int y = 0; y < aux.length; y++) {
            for (int x = 0; x < aux[y].length; x++) {
                aux[y][x] = Integer.MAX_VALUE;
            }
        }
        aux[0][0] = grid[0][0];
        for (int y = 0; y < aux.length; y++) {
            for (int x = 0; x < aux[y].length; x++) {
                if (x + 1 < aux[y].length) {
                    int newSum = aux[y][x] + grid[y][x+1];
                    if (aux[y][x+1] > newSum) {
                        aux[y][x+1] = newSum;
                    }
                }
                if (y + 1 < aux.length) {
                    int newSum = aux[y][x] + grid[y+1][x];
                    if (aux[y+1][x] > newSum) {
                        aux[y+1][x] = newSum;
                    }
                }
            }
        }
        return aux[aux.length -1][aux[aux.length -1].length -1];
    }
}
