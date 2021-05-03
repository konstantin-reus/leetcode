package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode dummy = new TreeNode(-5_000);
        q.add(root);
        q.add(dummy);
        List<List<Integer>> levels = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val == dummy.val) {
                levels.add(level);
                level = new ArrayList<>();
                if (!q.isEmpty()) {
                    q.add(dummy);
                }
            } else {
                if (level.isEmpty()) {
                    level.add(cur.val);
                }
                if (cur.right != null) q.add(cur.right);
                if (cur.left != null) q.add(cur.left);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> cur : levels) {
            result.add(cur.get(0));
        }
        return result;
    }
}
