package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * <p>
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to
 * right, level by level from leaf to root).
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[15,7],[9,20],[3]]
 * <p>
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 */
public class BinaryTreeLevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                result.add(0, level);
                level = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                level.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return result;
    }
}
