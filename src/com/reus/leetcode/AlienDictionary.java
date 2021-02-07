package com.reus.leetcode;


import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary
 * <p>
 * There is a new alien language that uses the English alphabet. However, the order among letters are unknown to you.
 * <p>
 * You are given a list of strings words from the dictionary, where words are sorted lexicographically by the rules of
 * this new language.
 * <p>
 * Derive the order of letters in this language, and return it. If the given input is invalid, return "". If there are
 * multiple valid solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["wrt","wrf","er","ett","rftt"]
 * Output: "wertf"
 * Example 2:
 * <p>
 * Input: words = ["z","x"]
 * Output: "zx"
 * Example 3:
 * <p>
 * Input: words = ["z","x","z"]
 * Output: ""
 * Explanation: The order is invalid, so return "".
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Integer> charToInDegrees = new HashMap<>();
        Map<Character, List<Character>> adjList = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                charToInDegrees.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word2.length() < word1.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word2.charAt(j) != word1.charAt(j)) {
                    charToInDegrees.put(word2.charAt(j), charToInDegrees.get(word2.charAt(j)) + 1);
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        Queue<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : charToInDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        while (!q.isEmpty()) {
            char cur = q.remove();
            result.append(cur);
            for (char c : adjList.get(cur)) {
                charToInDegrees.put(c, charToInDegrees.get(c) - 1);
                if (charToInDegrees.get(c) == 0) {
                    q.add(c);
                }
            }
        }
        if (result.length() < charToInDegrees.size()) {
            return "";
        }
        return result.toString();

    }
}
