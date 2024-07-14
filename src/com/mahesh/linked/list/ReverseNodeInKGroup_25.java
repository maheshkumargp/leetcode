package com.mahesh.linked.list;

public class ReverseNodeInKGroup_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode newHead = null;
        ListNode curr = head;
        ListNode endNode = null;
        ListNode first = head;
        int i = 0;

        while (curr != null) {
            while (i < k && curr != null) {
                endNode = curr;
                curr = curr.next;
                i++;
            }
            i = 0;
            ListNode node = reverse(first, endNode);
            if (newHead == null) newHead = node;
          else {  // first = curr;
                first.next = node;
                first = node.next;
            }
        }
        return newHead;

    }


    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};


        LinkedListGenerator.printLinkedList(reverseKGroup(LinkedListGenerator.createLinkedList(values), 2));
    }

    private static ListNode reverse(ListNode head, ListNode endNode) {
        //if (head == null) return head;
        ListNode first = head;
        if (head.next == null) return head;
        ListNode second = first.next;
        if (second.next == null) {
            second.next = first;
            first.next = null;
            return second;
        }
        ListNode third = second.next;
        while (first != null && third != null && first != endNode) {
            second.next = first;
            first = first.next;
            second = third;
            third = third.next;
        }
        head.next = second;
        return first;
    }
}
