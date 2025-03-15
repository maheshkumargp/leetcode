package com.mahesh.linked.list;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode();
        ListNode result = l3;
        ListNode prev = null;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            l3.val = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode();
            prev = l3;
            l3 = l3.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            l3.val = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode();
            prev = l3;
            l3 = l3.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            l3.val = sum % 10;
            carry = sum / 10;
            l3.next = new ListNode();
            prev = l3;
            l3 = l3.next;
            l2 = l2.next;
        }
        if (carry > 0) l3.val = carry;
        else if (prev != null) prev.next = null;
        return result;
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 5};
        int[] values1 = {1, 3, 4};
        int[] values2 = {2, 6};
        int[] values3 = {};

        ListNode l1 = LinkedListGenerator.createLinkedList(values);
        ListNode l2 = LinkedListGenerator.createLinkedList(values1);
        LinkedListGenerator.printLinkedList(addTwoNumbers(l1, l2));
    }
}
