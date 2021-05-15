package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || t.length() > s.length()) {
            return "";
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> requiredCharsInT = countChars(t);
        int requiredFormedChars = requiredCharsInT.size();

        int[] window = {-1, 0, 0}; //length, left, right
        Map<Character, Integer> curWindow = new HashMap<>();

        int formedChars = 0;

        while (right < s.length()) {
            char curChar = s.charAt(right);
            int curCharOccurences = curWindow.getOrDefault(curChar, 0) + 1;
            curWindow.put(curChar, curCharOccurences);
            Integer requiredCharOccurences = requiredCharsInT.get(curChar);
            if (requiredCharOccurences != null && requiredCharOccurences.equals(curCharOccurences)) {
                formedChars++;
            }

            while (left <= right && formedChars == requiredFormedChars) {
                if (window[0] == -1 || right - left < window[2] - window[1]) {
                    window[0] = right - left + 1;
                    window[1] = left;
                    window[2] = right;
                }
                curWindow.put(s.charAt(left), curWindow.get(s.charAt(left)) - 1);
                if (requiredCharsInT.get(s.charAt(left)) != null
                        && requiredCharsInT.get(s.charAt(left)) > curWindow.get(s.charAt(left))) {
                    formedChars--;
                }
                left++;
            }
            right++;
        }
        return window[0] != -1
                ? s.substring(window[1], window[2] + 1)
                : "";
    }

    private Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : s.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
