package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int longest = 0;
        String longestStr = "";
        Map<String, Boolean> arePalindromes = new HashMap<>();
        for (int start = 0; start < s.length(); start++) {
            int longestPossible = s.length() - start;
            for (int end = start; end < s.length(); end++) {
                if (longestPossible <= longest) {
                    return longestStr;
                }

                if (isPalindrome(s.substring(start, end + 1), arePalindromes)) {
                    if (longest < end - start + 1) {
                        longest = end - start + 1;
                        longestStr = s.substring(start, end + 1);
                    }
                    if (longest == s.length()) {
                        return longestStr;
                    }
                }
            }
        }
        return longestStr;
    }

    private boolean isPalindrome(String s, Map<String, Boolean> arePalindromes) {
        if (s.length() == 1) {
            return true;
        } else if (arePalindromes.containsKey(s)) {
            return arePalindromes.get(s);
        } else if (s.length() == 2) {
            boolean result = s.charAt(0) == s.charAt(1);
            arePalindromes.put(s, result);
            return result;
        }
        if (arePalindromes.containsKey(s)) {
            return arePalindromes.get(s);
        }
        if (s.charAt(0) != (s.charAt(s.length() - 1))) {
            arePalindromes.put(s, false);
            return false;
        } else {
            int start = 1;
            int end = s.length() - 2;
            if (start >= end) {
                arePalindromes.put(s, true);
                return true;
            }
            boolean result = isPalindrome(s.substring(start, end + 1), arePalindromes);
            arePalindromes.put(s, result);
            return result;
        }
    }
}
