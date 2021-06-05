package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode cur, int target, int curSum, List<List<Integer>> result, List<Integer> curPath) {
        if (cur == null) {
            return;
        }
        curPath.add(cur.val);
        int newSum = curSum + cur.val;
        if (cur.left == null && cur.right == null) {
            if (newSum == target) {
                result.add(curPath);
            } else {
                return;
            }
        }
        dfs(cur.left, target, newSum, result, new ArrayList<>(curPath));
        dfs(cur.right, target, newSum, result, new ArrayList<>(curPath));
    }
}
