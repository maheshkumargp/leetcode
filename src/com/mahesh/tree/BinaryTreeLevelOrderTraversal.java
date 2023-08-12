package com.mahesh.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> oddQueue = new LinkedList<>();
        Queue<TreeNode> evenQueue = new LinkedList<>();
        if (root != null) {
            result.add(Arrays.asList(root.val));
            if (root.left != null) oddQueue.offer(root.left);
            if (root.right != null) oddQueue.offer(root.right);
        }

        while (!oddQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!oddQueue.isEmpty()) {
                TreeNode node = oddQueue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) evenQueue.offer(node.left);
                    if (node.right != null) evenQueue.offer(node.right);
                }
            }
            if (!level.isEmpty())
                result.add(level);
            level = new ArrayList<>();
            while (!evenQueue.isEmpty()) {
                TreeNode node = evenQueue.poll();
                if (node != null) {
                    level.add(node.val);
                    if (node.left != null) oddQueue.offer(node.left);
                    if (node.right != null) oddQueue.offer(node.right);
                }
            }
            if (!level.isEmpty())
                result.add(level);

        }
        return result;

    }


    public static void main(String[] args) {
        //Integer[] root = {3, 9, 20, null, null, 15, 7};
        Integer[] root = {1, 2};
        List<List<Integer>> lists = levelOrder(TreeGenerator.createTree(root));
        System.out.println(lists);
    }
}
