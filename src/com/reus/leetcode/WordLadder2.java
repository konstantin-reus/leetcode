package com.reus.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii
 */
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wildcardToWords = new HashMap<>();
        for (String s : wordList) {
            Set<String> wildcarded = getWildcarded(s);
            for (String w : wildcarded) {
                wildcardToWords.putIfAbsent(w, new HashSet<>());
                wildcardToWords.get(w).add(s);
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(beginWord, 1, List.of(beginWord)));
        List<List<String>> result = new ArrayList<>();
        int shortestPath = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.word.equals(endWord)) {
                if (cur.path.size() <= shortestPath) {
                    result.add(cur.path);
                    shortestPath = Math.min(shortestPath, cur.path.size());
                } else {
                    return result;
                }
            }
            visited.add(cur.word);
            Set<String> adjacent = getWildcarded(cur.word);
            for (String wildcarded : adjacent) {
                if (wildcardToWords.containsKey(wildcarded)) {
                    Set<String> adjacentWords = wildcardToWords.get(wildcarded);
                    for (String s : adjacentWords) {
                        if (!visited.contains(s)) {
                            List<String> newPath = new ArrayList(cur.path);
                            newPath.add(s);
                            q.add(new Node(s, cur.distance + 1, newPath));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static class Node {
        private final String word;
        private final int distance;
        private final List<String> path;

        public Node(String word, int distance, List<String> path) {
            this.word = word;
            this.distance = distance;
            this.path = path;
        }

        @Override
        public String toString() {
            return String.format("%s : %d, path: %s", word, distance, path.toString());
        }
    }

    private Set<String> getWildcarded(String s) {
        Set<String> result = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = '*';
            result.add(new String(chars));
            chars[i] = c;
        }
        return result;
    }
}
