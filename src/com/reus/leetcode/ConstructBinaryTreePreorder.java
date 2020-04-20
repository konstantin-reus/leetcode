package com.reus.leetcode;

/**
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 * <p>
 * Note:
 * <p>
 * 1 <= preorder.length <= 100
 * The values of preorder are distinct.
 */
public class ConstructBinaryTreePreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = addElement(root, preorder[i]);
        }
        return root;
    }

    private TreeNode addElement(TreeNode root, int i) {
        if (root == null) return new TreeNode(i);

        if (i < root.val) {
            root.left = addElement(root.left, i);
        } else {
            root.right = addElement(root.right, i);
        }
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
