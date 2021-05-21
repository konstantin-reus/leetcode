package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return Integer.MIN_VALUE;
        }
        int curMax = cur.val;
        int leftGain = dfs(cur.left);
        int rightGain = dfs(cur.right);
        if (leftGain != Integer.MIN_VALUE) {
            curMax = Math.max(curMax, curMax + leftGain);
        }
        if (rightGain != Integer.MIN_VALUE) {
            curMax = Math.max(curMax, curMax + rightGain);
        }
        maxSum = Math.max(maxSum, curMax);
        return curMax;
    }
}
