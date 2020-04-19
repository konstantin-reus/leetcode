package com.reus.leetcode;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == '0') {
                    continue;
                } else if (grid[y][x] == '1') {
                    result++;
                    traverseAdjacent(grid, y, x);
                }
            }
        }
        return result;
    }

    private void traverseAdjacent(char[][] grid, int y, int x) {
        if (y > grid.length - 1 || y < 0 || x < 0 || x > grid[y].length - 1 || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        traverseAdjacent(grid, y - 1, x);
        traverseAdjacent(grid, y + 1, x);
        traverseAdjacent(grid, y, x - 1);
        traverseAdjacent(grid, y, x + 1);
    }
}
