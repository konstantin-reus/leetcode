package com.reus.leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
 * lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together
 * with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * https://leetcode.com/problems/container-with-most-water
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int curArea = Math.min(height[left], height[right]) * (right - left);
            if (curArea > area) {
                area = curArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
