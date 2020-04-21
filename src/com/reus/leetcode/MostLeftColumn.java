package com.reus.leetcode;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 * Example 4:
 * <p>
 * <p>
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= mat.length, mat[i].length <= 100
 * mat[i][j] is either 0 or 1.
 * mat[i] is sorted in a non-decreasing way.
 */
public class MostLeftColumn {
    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     * public int get(int x, int y) {}
     * public List<Integer> dimensions {}
     * };
     */

    public static void main(String[] args) {
        System.out.println(leftMostColumnWithOne(new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}}));
    }

    public static int leftMostColumnWithOne(int[][] binaryMatrix) {
        int height = binaryMatrix.length;
        int width = binaryMatrix[0].length;
        int leftMost = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            int oneInRow = getOnePosition(binaryMatrix, i, width - 1, 0, width - 1);
            leftMost = Math.min(oneInRow, leftMost);
            if (leftMost == 0) {
                return leftMost;
            }
        }
        return leftMost == Integer.MAX_VALUE ? -1 : leftMost;
    }

    private static int getOnePosition(int[][] matrix, int y, int maxX, int left, int right) {
        if (left > right || left < 0 || left > maxX || right < 0 || right > maxX) {
            return Integer.MAX_VALUE;
        }
        if (left == right) {
            return matrix[y][left] == 1
                    ? left
                    : Integer.MAX_VALUE;
        }
        int middle = (right + left) / 2;
        if (matrix[y][middle] == 1) {
            if (middle == 0) return middle;
            return Math.min(middle, getOnePosition(matrix, y, maxX, left, middle - 1));
        } else {
            return getOnePosition(matrix, y, maxX, middle + 1, right);
        }
    }
}
