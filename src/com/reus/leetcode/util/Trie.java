package com.reus.leetcode.util;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree
 */
public class Trie {
    private final Node root = new Node('#', false);

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c, false);
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    private static class Node {
        private final char val;
        private final Node[] children = new Node[26];
        private boolean isWord;

        public Node(char val, boolean isWord) {
            this.val = val;
            this.isWord = isWord;
        }
    }
}

