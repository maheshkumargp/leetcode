package com.mahesh.tree;

import static com.mahesh.tree.TreeGenerator.createTree;

public class KthSmallestElementInBST {
    static int result = 0;
    static int count = 0;

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return result;
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        kthSmallest(root.right, k);

        return result;
    }


    private static int inOrder(TreeNode root, int k) {
        //if (count == k) return root.val;
        if (root == null) return result;
        inOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            // return root.val;
        }
        inOrder(root.right, k);
//return 0;
        return result;
    }

    public static void main(String[] args) {
        Integer[] values = {5,3,6,2,4,null,null,1};

        TreeNode root = createTree(values);
        System.out.println(kthSmallest(root, 3));
    }
}
