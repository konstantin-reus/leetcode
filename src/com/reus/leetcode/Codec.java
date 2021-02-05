package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {
    private static final TreeNode NULL_NODE = new TreeNode(-1001);

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        StringBuilder result = new StringBuilder("[");
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.val == NULL_NODE.val) {
                result.append("null,");
                continue;
            }
            result
                    .append(cur.val)
                    .append(',');
            if (cur.right == null) {
                stack.add(NULL_NODE);
            } else {
                stack.add(cur.right);
            }
            if (cur.left == null) {
                stack.add(NULL_NODE);
            } else {
                stack.add(cur.left);
            }
        }
        result.deleteCharAt(result.lastIndexOf(","));
        return result.append(']').toString();
    }

    public static TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.length() < 2) {
            return null;
        }
        String toDecode = new String(data);
        toDecode = toDecode.replaceFirst("\\[", "");
        toDecode = toDecode.replaceFirst("\\]", "");
        String[] elements = toDecode.split(",");
        Queue<String> queue = new ArrayDeque<>();
        for (String element : elements) {
            queue.add(element);
        }
        TreeNode root = buildTree(queue);
        return root;
    }

    private static TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        root.right = treeNode3;
        treeNode3.left = new TreeNode(4);
        treeNode3.right = new TreeNode(5);
        String serialized1 = serialize(root);
        System.out.println(serialized1);
        TreeNode rootDeserialized = deserialize(serialized1);
        System.out.println(rootDeserialized);

        TreeNode root2 = new TreeNode(1);
        TreeNode right1 = new TreeNode(2);
        root2.right = right1;
        right1.right = new TreeNode(3);

        String serialized2 = serialize(root2);
        System.out.println(serialized2);
        TreeNode root3 = deserialize(serialized2);
        System.out.println(1);
    }
}
