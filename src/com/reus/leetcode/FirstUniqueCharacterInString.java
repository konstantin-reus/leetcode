package com.reus.leetcode;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string
 */
public class FirstUniqueCharacterInString {
    private static final int ALPHABET_CHARS_NUMBER = 32;
    public int firstUniqChar(String s) {
        int[] freq = new int[ALPHABET_CHARS_NUMBER];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
