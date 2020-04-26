package com.reus.leetcode;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[y].length; x++) {
                if (text1.charAt(y - 1) == text2.charAt(x - 1)) {
                    dp[y][x] = dp[y - 1][x - 1] + 1;
                } else {
                    dp[y][x] = Math.max(dp[y][x - 1], dp[y - 1][x]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];

    }
}
