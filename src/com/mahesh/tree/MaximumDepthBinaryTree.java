package com.mahesh.tree;

public class MaximumDepthBinaryTree {

    public static int maxDepth(TreeNode root) {
        int leftCount = 1;
        int rightCount = 1;
        if (root.left != null) {
            leftCount = 1 + findDepth(root.left, 1);
        }
        if (root.right != null) {
            rightCount = 1 + findDepth(root.right, 1);
        }
        return Integer.max(leftCount, rightCount);

    }

    public static int findDepth(TreeNode node, int count) {
        int leftCount = 1;
        int rightCount = 1;
        if (node.left != null) {
            leftCount = 1 + findDepth(node.left, count);

        }
        if (node.right != null) {
            rightCount = 1 + findDepth(node.right, count);
        }

        return Integer.max(leftCount, rightCount);

    }

    public static void main(String[] args) {
        Integer[] root = {3, 9, 20, null, null, 15, 7};
        Integer[] root1 = {1,null,2};
        System.out.println(maxDepth(TreeGenerator.createTree(root1)));
    }

}
