package com.reus.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatedCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int curMax = 0;
        Set<Character> curChars = new HashSet<>();
        while (right < s.length() && left <= right) {
            if (!curChars.contains(s.charAt(right))) {
                curMax = Math.max(curMax, right - left + 1);
                curChars.add(s.charAt(right));
                right++;
            } else {
                curChars.remove(s.charAt(left));
                left++;
            }
        }
        return curMax;
    }
}
