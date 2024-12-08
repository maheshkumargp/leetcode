package com.mahesh.tree;

import static com.mahesh.tree.TreeGenerator.createTree;

public class PathSum {
    static boolean found = false;

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        findPath(root, targetSum, 0);
        return found;

    }

    private static boolean findPath(TreeNode root, int targetSum, int sum) {
        int newSum = sum + root.val;
        if (root.right == null && root.left == null) {
            if (targetSum == newSum) found = true;
        }

        if (root.right != null ) findPath(root.right, targetSum, newSum);
        if (root.left != null ) findPath(root.left, targetSum, newSum);
        return false;
    }


    public static void main(String[] args) {
     //   Integer[] values = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        Integer[] values = {-2, null, -3};
        TreeNode root = createTree(values);
        System.out.println(hasPathSum(root, -5));
    }

}
