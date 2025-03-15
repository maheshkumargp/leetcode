package com.mahesh.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.mahesh.tree.TreeGenerator.createTree;

public class ZigZagTreeTraversal {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> even = new Stack<>();
        Stack<TreeNode> odd = new Stack<>();
        boolean flip;
        if (root != null) even.push(root);

        List<Integer> temp = null;
        while (!even.isEmpty() || !odd.isEmpty()) {
            while (!even.isEmpty()) {
                if (temp == null) temp = new ArrayList<>();
                TreeNode curr = even.pop();
                temp.add(curr.val);
                if (curr.left != null) odd.push(curr.left);
                if (curr.right != null) odd.push(curr.right);


            }
            if (temp != null) result.add(temp);
            temp = null;
            while (!odd.empty()) {
                if (temp == null) temp = new ArrayList<>();
                TreeNode curr = odd.pop();
                temp.add(curr.val);
                if (curr.right != null) even.push(curr.right);
                if (curr.left != null) even.push(curr.left);
            }
            if (temp != null) result.add(temp);
            temp = null;
        }

        return result;


    }

    public static void main(String[] args) {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = createTree(values);
        System.out.println(zigzagLevelOrder(root));
    }

}
