package com.reus.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points symmetrically, in other words, answer whether or not if there exists a line that after reflecting all points over the given line the set of the original points is the same that the reflected ones.
 * <p>
 * Note that there can be repeated points.
 * <p>
 * Follow up:
 * Could you do better than O(n2) ?
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: points = [[1,1],[-1,1]]
 * Output: true
 * Explanation: We can choose the line x = 0.
 * Example 2:
 * <p>
 * <p>
 * Input: points = [[1,1],[-1,-1]]
 * Output: false
 * Explanation: We can't choose a line.
 */
public class LineReflection {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> yToX = new HashMap<>();
        for (int[] p : points) {
            yToX.putIfAbsent(p[1], new HashSet<>());
            yToX.get(p[1]).add(p[0]);
        }
        Set<Double> mids = new HashSet<>();
        for (int[] point : points) {
            Set<Integer> xs = yToX.get(point[1]);
            Set<Double> possibleMids = new HashSet<>();
            for (int x : xs) {
                double mid = getMiddleX(point, new int[]{x, point[1]});
                possibleMids.add(mid);
            }
            if (mids.isEmpty()) {
                mids.addAll(possibleMids);
            } else {
                mids.retainAll(possibleMids);
            }
            if (mids.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private double getMiddleX(int[] left, int[] right) {
        return (left[0] + right[0]) * 1.0 / 2;
    }
}
