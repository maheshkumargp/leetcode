package com.mahesh.tree;

public class ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        return isValidBst(root.left, null, root.val)
                && isValidBst(root.right, root.val, null);

    }

    private static boolean isValidBst(TreeNode root, Integer ll, Integer ul) {
        if (root == null) return true;
        if (ll != null && root.val < ll) return false;
        if (ul != null && root.val > ul) return false;

        return isValidBst(root.left, ll, root.val) && isValidBst(root.right, root.val, ul);
    }

    public static void main(String[] args) {
        Integer[] root = {3, 9, 20, null, null, 15, 7};
        Integer[] root1 = {2, 2, 2};
        Integer[] root3 = {1, 1};
        Integer[] root4 = {1, null, 1};
        Integer[] root5 = {0, -1};
        Integer[] root2 = {5, 4, 6, null, null, 3, 7};
        System.out.println(isValidBST(TreeGenerator.createTree(root3)));
        System.out.println(isValidBST(TreeGenerator.createTree(root1)));
        System.out.println(isValidBST(TreeGenerator.createTree(root5)));
        System.out.println(isValidBST(TreeGenerator.createTree(root2)));
    }
}
