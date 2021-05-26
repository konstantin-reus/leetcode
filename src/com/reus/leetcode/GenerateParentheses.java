package com.reus.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), result);
        return result;
    }

    private void dfs(int open, int closed, int n, StringBuilder cur, List<String> result) {
        if (closed > open || open > n) {
            return;
        }
        if (open + closed == n * 2) {
            result.add(cur.toString());
            return;
        }
        StringBuilder openAppended = new StringBuilder(cur);
        openAppended.append('(');
        dfs(open + 1, closed, n, openAppended, result);

        StringBuilder closedAppended = new StringBuilder(cur);
        closedAppended.append(')');
        dfs(open, closed + 1, n, closedAppended, result);
    }
}
