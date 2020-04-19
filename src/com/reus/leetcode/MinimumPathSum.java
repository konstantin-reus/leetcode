package com.reus.leetcode;

/**
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
        int[][] sums = new int[grid.length][grid[0].length];
        sums[sums.length - 1][sums[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];

        for (int y = sums.length - 1; y >= 0; y--) {
            for (int x = sums[y].length - 1; x >= 0; x--) {
                if (y == sums.length - 1 && x == sums[y].length - 1) {
                    continue;
                } else if (y == sums.length - 1) {
                    sums[y][x] = sums[y][x + 1] + grid[y][x];
                } else if (x == sums[y].length - 1) {
                    sums[y][x] = sums[y + 1][x] + grid[y][x];
                } else {
                    sums[y][x] = grid[y][x] + Math.min(sums[y + 1][x], sums[y][x + 1]);
                }
            }
        }
        return sums[0][0];
    }
}
