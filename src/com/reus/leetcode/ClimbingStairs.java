package com.reus.leetcode;

/**
 * https://leetcode.com/problems/climbing-stairs
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int b = 1;
        int c = 2;
        for (int i = 3; i < n + 1; i++) {
            int tmp = c;
            c = c + b;
            b = tmp;
        }

        return n < 2
                ? b
                : c;
    }
}
