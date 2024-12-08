package com.mahesh.tree;

import java.util.ArrayList;
import java.util.List;

import static com.mahesh.tree.TreeGenerator.createTree;

public class InOrderTreeTraversal {
    List<Integer> result = new ArrayList<>();
    public  List<Integer> inorderTraversal(TreeNode root) {
       if(root.left != null)  inorderTraversal(root.left);
       result.add(root.val);
       if(root.right!=null)inorderTraversal(root.right);

       return result;

    }

    public static void main(String[] args) {
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = createTree(values);
        InOrderTreeTraversal inOrderTreeTraversal = new InOrderTreeTraversal();
        System.out.println(inOrderTreeTraversal.inorderTraversal(root));
    }
}
