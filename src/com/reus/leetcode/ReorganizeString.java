package com.reus.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if (S == null) {
            return "";
        } else if (S.length() == 1) {
            return S;
        }
        Queue<CharToCount> heap = new PriorityQueue<>((c1, c2) -> c1.count == c2.count ? c1.c - c2.c : c2.count - c1.count);
        int[] freq = new int[26];
        for (char c : S.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > (S.length() + 1) / 2) {
                return "";
            }
            if (freq[i] != 0) {
                heap.add(new CharToCount((char) (i + 'a'), freq[i]));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!heap.isEmpty()) {
            CharToCount maxFreqChar = heap.poll();
            CharToCount nextFreqChar = heap.poll();
            result.append(maxFreqChar.c);
            if (nextFreqChar != null) {
                result.append(nextFreqChar.c);
                if (nextFreqChar.count > 1) {
                    heap.add(new CharToCount(nextFreqChar.c, nextFreqChar.count - 1));
                }
            }
            if (maxFreqChar.count > 1) {
                heap.add(new CharToCount(maxFreqChar.c, maxFreqChar.count - 1));
            }
        }
        return result.toString();
    }

    private static class CharToCount {
        final char c;
        final int count;

        public CharToCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
