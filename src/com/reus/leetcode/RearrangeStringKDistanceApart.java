package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
 * <p>
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabbcc", k = 3
 * Output: "abcabc"
 * Explanation: The same letters are at least distance 3 from each other.
 * Example 2:
 * <p>
 * Input: s = "aaabc", k = 3
 * Output: ""
 * Explanation: It is not possible to rearrange the string.
 * Example 3:
 * <p>
 * Input: s = "aaadbbcc", k = 2
 * Output: "abacabcd"
 * Explanation: The same letters are at least distance 2 from each other.
 * <p>
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Queue<CharCount> heap = new PriorityQueue<>((c1, c2) -> c1.count == c2.count ? c1.c - c2.c : c2.count - c1.count);

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                heap.add(new CharCount((char) (i + 'a'), freq[i]));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!heap.isEmpty()) {
            Map<Character, Integer> toPut = new HashMap<>();

            for (int i = 0; i < k; i++) {
                if (heap.isEmpty() && toPut.isEmpty()) {
                    return result.toString();
                } else if (!heap.isEmpty()) {
                    CharCount charCount = heap.poll();
                    String lastKadded = result.substring(Math.max(0, result.length() - k + 1), result.length());
                    if (lastKadded.contains(new String(new char[]{charCount.c}))) {
                        return "";
                    }
                    result.append(charCount.c);
                    toPut.put(charCount.c, charCount.count - 1);
                }
            }
            toPut.entrySet().forEach(entry -> {
                if (entry.getValue() > 0)
                    heap.add(new CharCount(entry.getKey(), entry.getValue()));
            });

        }
        return result.toString();
    }

    private static class CharCount {
        final char c;
        final int count;

        public CharCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public String toString() {
            return String.format("%s = %d", c, count);
        }
    }
}
