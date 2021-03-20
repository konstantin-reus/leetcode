package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
 */
public class BinaryTreeZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Integer> level = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        boolean isLeftOrder = true;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                result.add(level);
                level = new LinkedList<>();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                isLeftOrder = !isLeftOrder;
            } else {
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (isLeftOrder) {
                    level.addLast(cur.val);
                } else {
                    level.addFirst(cur.val);
                }
            }
        }
        return result;
    }
}
