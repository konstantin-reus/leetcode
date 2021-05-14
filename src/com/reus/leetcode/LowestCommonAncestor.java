package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestor {
    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null) {
            return false;
        }
        int left = dfs(cur.left, p, q) ? 1 : 0;
        int right = dfs(cur.right, p, q) ? 1 : 0;
        int mid = cur == p || cur == q ? 1 : 0;
        if (left + right + mid >= 2) {
            ans = cur;
        }
        return left + right + mid > 0;
    }
}