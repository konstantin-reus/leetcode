package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree
 */
public class DiameterBinaryTree {
    private int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int left = dfs(cur.left);
        int right = dfs(cur.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
