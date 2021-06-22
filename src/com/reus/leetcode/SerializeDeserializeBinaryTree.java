package com.reus.leetcode;

import com.reus.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        root.right = three;
        three.left = four;
        three.right=five;

        System.out.println(s.serialize(root));
        TreeNode result = s.deserialize(s.serialize(root));
        System.out.println(1);

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var sb = traverseToSerialize(root, new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }

    private StringBuilder traverseToSerialize(TreeNode cur, StringBuilder builder) {
        if (cur == null) {
            builder.append("null,");
            return builder;
        }
        builder.append(cur.val)
                .append(",");
        traverseToSerialize(cur.left, builder);
        traverseToSerialize(cur.right, builder);
        return builder;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        List<String> l = new ArrayList<>(Arrays.asList(nodes));
        return traverseToDeserialize(l);
    }

    private TreeNode traverseToDeserialize(List<String> nodes) {
        if ("null".equals(nodes.get(0))) {
            nodes.remove(0);
            return null;
        }
        TreeNode cur = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        cur.left = traverseToDeserialize(nodes);
        cur.right = traverseToDeserialize(nodes);
        return cur;
    }
}
