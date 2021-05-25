package com.reus.leetcode;

/**
 * https://leetcode.com/problems/flood-fill
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        traverse(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private void traverse(int[][] image, int row, int column, int oldColor, int newColor) {
        if (row < 0 || column < 0 || row >= image.length || column >= image[row].length) {
            return;
        }
        if (image[row][column] != oldColor || image[row][column] == newColor)  {
            return;
        }
        image[row][column] = newColor;
        traverse(image, row - 1, column, oldColor, newColor);
        traverse(image, row, column - 1, oldColor, newColor);
        traverse(image, row, column + 1, oldColor, newColor);
        traverse(image, row + 1, column, oldColor, newColor);
    }
}
