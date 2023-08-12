package com.mahesh.linked.list;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int i = 0;
        ListNode nth = head;
        ListNode curr = head;
        while (curr != null && i < n) {
            curr = curr.next;
            i++;
        }
        //nth=curr;
        ListNode prev = nth;
        while (curr != null) {
            prev = nth;
            nth = nth.next;
            curr = curr.next;

        }
        if (prev.next == null) return null;
        if (nth == head) {
            head = nth.next;
            return head;
        }
        if (i == n)
            prev.next = nth.next;
        return head;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int[] values1 = {1};
        int[] values2 = {1, 2};

        // LinkedListGenerator.printLinkedList( removeNthFromEnd(LinkedListGenerator.createLinkedList(values),2));
        //  LinkedListGenerator.printLinkedList(removeNthFromEnd(LinkedListGenerator.createLinkedList(values1), 1));
        LinkedListGenerator.printLinkedList(removeNthFromEnd(LinkedListGenerator.createLinkedList(values2), 2));
    }

}
