package com.reus;

import com.reus.leetcode.util.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii
 */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        Set<String> result = new HashSet<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, y, x, "", trie, result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int y, int x, String curWord, Trie trie, Set<String> result, boolean[][] visited) {
        if (x < 0 || y < 0 || y > board.length - 1 || x > board[y].length - 1 || visited[y][x]) {
            return;
        }
        String appended = curWord + Character.toString(board[y][x]);
        if (!trie.startsWith(appended)) {
            return;
        }
        visited[y][x] = true;
        if (trie.search(appended)) {
            result.add(appended);
        }
        dfs(board, y - 1, x, appended, trie, result, visited);
        dfs(board, y + 1, x, appended, trie, result, visited);
        dfs(board, y, x - 1, appended, trie, result, visited);
        dfs(board, y, x + 1, appended, trie, result, visited);
        visited[y][x] = false;
    }
}
