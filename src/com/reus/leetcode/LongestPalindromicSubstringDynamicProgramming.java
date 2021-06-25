package com.reus.leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 */
public class LongestPalindromicSubstringDynamicProgramming {

    public String longestPalindrome(String s) {boolean[][] dp = new boolean[s.length()][s.length()];
        int left = -1;
        int right = -1;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                boolean isFirstAndLastMatch = s.charAt(i) == s.charAt(j);
                if (isFirstAndLastMatch) {
                    dp[i][j] = j - i > 2
                            ? dp[i + 1][j - 1]
                            : true;
                    if (dp[i][j]) {
                        int length = j - i + 1;
                        if (length > maxLength) {
                            left = i;
                            right = j;
                            maxLength = length;
                        }
                    }
                }
            }
        }
        return maxLength > 0
                ? s.substring(left, right + 1)
                : "";
    }
}
