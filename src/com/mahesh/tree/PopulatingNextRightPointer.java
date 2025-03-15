package com.mahesh.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointer {

    private static Node getNode(Queue<Node> q1, Node prev, Queue<Node> q2) {
        Node curr;
        curr = q1.remove();
        if (prev != null) {
            prev.next = curr;
            prev = curr;
        } else {
            prev = curr;
        }

        if (curr.left != null) q2.add(curr.left);
        if (curr.right != null) q2.add(curr.right);
        return prev;
    }

    public static Node connect(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        Node prev = null;

        if (root == null) return root;
        if (root.left != null) q1.add(root.left);
        if (root.right != null) q1.add(root.right);

        while (!q1.isEmpty() || !q2.isEmpty()) {
            while (!q1.isEmpty()) {
                prev = getNode(q1, prev, q2);

            }
            prev = null;
            while (!q2.isEmpty()) {
                prev = getNode(q2, prev, q1);
            }

        }

        return root;
    }

    public static void main(String[] args) {
        //Integer[] root = {1,2,3,4,5,6,7};
        Integer[] root= {-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13};
    Node ro= connect(TreeGenerator.createNode(root));
        System.out.println(ro);
    }
}
