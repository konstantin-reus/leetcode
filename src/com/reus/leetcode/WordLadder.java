package com.reus.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * <p>
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 * <p>
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 * <p>
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wildcardWordToAdjacentWords = new HashMap<>();
        for (String word : wordList) {
            Set<String> wildcarded = getWildcarded(word);
            for (String wildcardWord : wildcarded) {
                Set<String> adjacent = wildcardWordToAdjacentWords.getOrDefault(wildcardWord, new HashSet<>());
                adjacent.add(word);
                wildcardWordToAdjacentWords.put(wildcardWord, adjacent);
            }
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            if (cur.word.equals(endWord)) {
                return cur.distance;
            }
            Set<String> wildcarded = getWildcarded(cur.word);
            for (String s : wildcarded) {
                Set<String> adjacentWords = wildcardWordToAdjacentWords.getOrDefault(s, new HashSet<>());
                for (String adjacentWord : adjacentWords) {
                    if (!visited.contains(adjacentWord)) {
                        q.add(new Pair(adjacentWord, cur.distance + 1));
                        visited.add(adjacentWord);
                    }
                }
            }
        }
        return 0;
    }

    private Set<String> getWildcarded(String word) {
        Set<String> result = new HashSet<>();
        char[] c = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char tmp = c[i];
            c[i] = '*';
            String wildcardWord = new String(c);
            c[i] = tmp;
            result.add(wildcardWord);
        }
        return result;
    }

    private static class Pair {
        String word;
        int distance;

        public Pair(String word, int distance) {
            this.word = word;
            this.distance = distance;
        }
    }
}
