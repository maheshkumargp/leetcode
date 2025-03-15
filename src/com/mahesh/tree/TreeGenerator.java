package com.mahesh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeGenerator {
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        int index = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (index < values.length) {
            TreeNode current = queue.poll();

            if (values[index] != null) {
                current.left = new TreeNode(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new TreeNode(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static Node createNode(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        Node root = new Node(values[0]);
        int index = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (index < values.length) {
            Node current = queue.poll();

            if (values[index] != null) {
                current.left = new Node(values[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < values.length && values[index] != null) {
                current.right = new Node(values[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] values = {3, 9, 20, null, null, 15, 7};
        TreeNode root = createTree(values);
        // You can use the 'root' TreeNode to solve your LeetCode problem
    }
}