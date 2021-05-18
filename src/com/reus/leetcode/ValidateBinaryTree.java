package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 */
public class ValidateBinaryTree {
    public boolean isValidBST(TreeNode root) {
        boolean isLeftBst = dfs(root.left, null, root.val);
        boolean isRightBst = dfs(root.right, root.val, null);
        return isLeftBst && isRightBst;
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        if (node.left != null && node.left.val >= node.val) {
            return false;
        }
        if (node.right != null && node.right.val <= node.val) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }
}
