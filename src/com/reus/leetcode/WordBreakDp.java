package com.reus.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakDp {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreakDp w = new WordBreakDp();
        w.wordBreak("leetcode", List.of("leet", "code"));
//        w.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"));
    }
}
