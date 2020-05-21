package com.reus.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        return res;
    }


}
/**
 *  public List<String> wordBreak(String s, Set<String> wordDict) {
 *         return word_Break(s, wordDict, 0);
 *     }
 *     HashMap<Integer, List<String>> map = new HashMap<>();
 *
 *     public List<String> word_Break(String s, Set<String> wordDict, int start) {
 *         if (map.containsKey(start)) {
 *             return map.get(start);
 *         }
 *         LinkedList<String> res = new LinkedList<>();
 *         if (start == s.length()) {
 *             res.add("");
 *         }
 *         for (int end = start + 1; end <= s.length(); end++) {
 *             if (wordDict.contains(s.substring(start, end))) {
 *                 List<String> list = word_Break(s, wordDict, end);
 *                 for (String l : list) {
 *                     res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
 *                 }
 *             }
 *         }
 *         map.put(start, res);
 *         return res;
 *     }
 */
