package com.reus.leetcode;

/**
 * https://leetcode.com/problems/ransom-note
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazines = new int[26];
        for (char c : magazine.toCharArray()) {
            magazines[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            magazines[c - 'a']--;
            if (magazines[c - 'a'] < 0) {
                return false;
            }
        }
        return true;

    }
}
