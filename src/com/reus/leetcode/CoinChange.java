package com.reus.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int curMin = dp[i];
            for (int coin : coins) {
                if (i - coin >= 0) {
                    curMin = Math.min(curMin, dp[i - coin]);
                }
            }
            if (curMin != Integer.MAX_VALUE) {
                dp[i] = curMin + 1;
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE
                ? -1
                : dp[dp.length - 1];
    }
}
