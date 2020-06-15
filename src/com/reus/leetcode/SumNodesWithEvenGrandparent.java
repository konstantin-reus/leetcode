package com.reus.leetcode;

public class SumNodesWithEvenGrandparent {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node1_left = new TreeNode(1, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, node9, null);
        TreeNode node7_2 = new TreeNode(7, node1_left, node4);
        TreeNode node7_1 = new TreeNode(7, node2, node7_2);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode node1_right = new TreeNode(1, null, null);
        TreeNode node8 = new TreeNode(8, node1_right, node3);
        TreeNode root1 = new TreeNode(6, node7_1, node8);

        System.out.println(sumEvenGrandparent(root1));

        TreeNode node34 = new TreeNode(34, null, null);
        TreeNode node6 = new TreeNode(6, null, node34);
        TreeNode node98 = new TreeNode(98, null, null);
        TreeNode node54 = new TreeNode(54, node98, node6);
        TreeNode root2 = new TreeNode(50, null, node54);

        System.out.println(sumEvenGrandparent(root2));
    }

    public static int sumEvenGrandparent(TreeNode root) {
        return traverse(root, 0);
    }

    private static int traverse(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        if (node.val % 2 == 0) {
            sum += getGrandChildrenSum(node, 0, 0);
        }
        sum = traverse(node.left, sum);
        sum = traverse(node.right, sum);
        return sum;
    }

    private static int getGrandChildrenSum(TreeNode node, int sum, int level) {
        if (node == null) {
            return sum;
        }
        if (level == 0) {
            sum = getGrandChildrenSum(node.left, sum, 1);
            sum = getGrandChildrenSum(node.right, sum, 1);
        } else if (level == 1) {
            sum += node.left == null ? 0 : node.left.val;
            sum += node.right == null ? 0 : node.right.val;
        }
        return sum;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
