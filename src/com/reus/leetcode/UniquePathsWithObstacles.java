package com.reus.leetcode;

/**
 * https://leetcode.com/problems/unique-paths-ii
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] path = new int[obstacleGrid.length][obstacleGrid[0].length];
        path[0][0] = 1;
        for (int y = 0; y < path.length; y++) {
            for (int x = 0; x < path[y].length; x++) {
                if (obstacleGrid[y][x] == 1) {
                    path[y][x] = 0;
                } else {
                    if (y == 0 && x == 0) {
                        continue;
                    }
                    int left = x - 1 >= 0
                            ? path[y][x - 1]
                            : 0;
                    int top = y - 1 >= 0
                            ? path[y-1][x]
                            : 0;
                    path[y][x] = left + top;
                }
            }
        }
        return path[path.length - 1][path[0].length - 1];
    }
}
