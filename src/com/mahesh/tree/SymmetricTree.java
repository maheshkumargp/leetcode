package com.mahesh.tree;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null) return false;
        if (rightTree == null) return false;
        boolean left = isSymmetric(leftTree.left, rightTree.right);
        boolean right = isSymmetric(leftTree.right, rightTree.left);
        if (left && right)
            return leftTree.val == rightTree.val;
        return false;

    }


    public static void main(String[] args) {

        Integer[] root = {1, 2, 2, 3, 4, 4, 3};
        Integer[] root1 = {1, 2, 2, null, 3, null, 3};
        System.out.println(isSymmetric(TreeGenerator.createTree(root)));
        System.out.println(isSymmetric(TreeGenerator.createTree(root1)));

    }
}
