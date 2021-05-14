package com.reus.leetcode;

/**
 * https://leetcode.com/problems/implement-strstr
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int haystackCur = i;
            int needleCur = 0;
            while (haystack.charAt(haystackCur) == needle.charAt(needleCur)) {
                needleCur++;
                haystackCur++;
                if (needleCur == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
