package com.mahesh.tree;

import java.util.ArrayList;
import java.util.List;

import static com.mahesh.tree.TreeGenerator.createTree;

public class PreOrderTraversal {

    public static List<Integer> preorderTraversal(TreeNode root) {

        return preorderTraversal(root, new ArrayList<>());


    }

    private static List<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> integers) {

        if (root != null) {
            integers.add(root.val);
            preorderTraversal(root.left, integers);
            preorderTraversal(root.right, integers);
        }
        return integers;
    }

    public static void main(String[] args) {
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = createTree(values);
       // InOrderTreeTraversal inOrderTreeTraversal = new InOrderTreeTraversal();
        System.out.println(preorderTraversal(root));
    }
}
