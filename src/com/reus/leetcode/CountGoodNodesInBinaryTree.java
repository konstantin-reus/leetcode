package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree
 */
public class CountGoodNodesInBinaryTree {
    int result = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, Integer.MIN_VALUE);
        return result;
    }

    private void dfs(TreeNode cur, int curMax) {
        if(cur == null) {
            return;
        }
        if (cur.val >= curMax) {
            result++;
        }
        dfs(cur.left, Math.max(curMax, cur.val));
        dfs(cur.right, Math.max(curMax, cur.val));
    }
}
