package com.mahesh.tree;

import java.util.ArrayList;
import java.util.List;

import static com.mahesh.tree.TreeGenerator.createTree;

public class InOrderTreeTraversal__2 {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result=new ArrayList<>();
        if(root!=null)inOrderTravrsal(root,result);
        return result;

    }

    private void inOrderTravrsal(TreeNode root, List<Integer> result) {

        if(root==null) return;
        inOrderTravrsal(root.left,result);
        result.add(root.val);
        inOrderTravrsal(root.right,result);

    }

    public static void main(String[] args) {
        Integer[] values = {1,2,3,4,5,null,8,null,null,6,7,9};
        TreeNode root = createTree(values);
        InOrderTreeTraversal inOrderTreeTraversal = new InOrderTreeTraversal();
        System.out.println(inOrderTreeTraversal.inorderTraversal(root));
    }

}
