package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode cur, int targetSum, int curSum) {
        if (cur == null) {
            return false;
        }
        curSum += cur.val;
        if (curSum == targetSum && cur.left == null && cur.right == null) {
            return true;
        }
        boolean left = dfs(cur.left, targetSum, curSum);
        boolean right = dfs(cur.right, targetSum, curSum);
        return left || right;
    }
}
