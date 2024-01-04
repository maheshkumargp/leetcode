package com.mahesh.linked.list;

import java.util.HashMap;

public class LinkedListGenerator {
    public static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static Node createRandomLinkedList(Integer[][] values) {
        HashMap<Integer, Node> map = new HashMap<>(); // <key, value>
        if (values == null || values.length == 0) {
            return null;
        }
        Node dummy = new Node(0);
        Node current = dummy;
        int i = 0;
        for (Integer[] val : values) {
            current.next = new Node(val[0]);
            map.put(i++, current.next);
            current = current.next;
        }
        current = dummy.next;
        for (Integer[] val : values) {
            current.random = map.get(val[1]);
            current = current.next;
        }
        return dummy.next;
    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + ", "+current+", "+current.random + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
//        int[] values = {1, 2, 3, 4, 5};
//        ListNode head = createLinkedList(values);
//        printLinkedList(head);
//[7,null],[13,0],[11,4],[10,2],[1,0]
        Node head1 = createRandomLinkedList(new Integer[][]{{7,null}, {11,4}, {10,2}, {13,0}, {1,0}});
        printLinkedList(head1);
    }
}
