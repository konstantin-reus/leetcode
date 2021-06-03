package com.reus.leetcode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] prices = new int[cost.length + 1];
        int a = cost[0];
        //prices[0] = cost[0];
        int b = cost[1];
        //prices[1] = cost[1];
        int c = -1;
        for (int i = 2; i < prices.length; i++) {
            c = Math.min(a, b);
            if (i < cost.length) {
                c += cost[i];
            }
            int tmp = b;
            b = c;
            a = tmp;
        }
        return c == -1
                ? b
                : c;
    }
}
