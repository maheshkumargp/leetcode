package com.mahesh.linked.list;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        int i = 0;
        ListNode odd = head;
        ListNode even = null;
        if (head != null) {
            head = head.next;
            even = head;
        }
        ListNode oddPointer = odd;
        ListNode evenPointer = even;
        if (head != null) head = head.next;
        while (head != null) {
            if (i % 2 == 0) {
                oddPointer.next = head;
                oddPointer = oddPointer.next;
            } else {
                evenPointer.next = head;
                evenPointer = evenPointer.next;
            }

            i++;
            head = head.next;
        }
        if (evenPointer != null)
            evenPointer.next = null;
        oddPointer.next = even;

        return odd;

    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int[] values1 = {2, 1, 3, 5, 6, 4, 7};
        int[] values2 = {2, 6};
        int[] values3 = {};

        ListNode l1 = LinkedListGenerator.createLinkedList(values);
        ListNode l2 = LinkedListGenerator.createLinkedList(values1);
        LinkedListGenerator.printLinkedList(oddEvenList(l1));
        LinkedListGenerator.printLinkedList(oddEvenList(l2));
    }
}
