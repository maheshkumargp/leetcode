package com.mahesh.linked.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists_23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length > 0) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    minHeap.add(lists[i]);
                }
            }
            if (!minHeap.isEmpty()) {
                ListNode head = minHeap.remove();
                ListNode curr = head;
                ListNode temp;
                while (!minHeap.isEmpty()) {
                    if (curr.next != null) minHeap.add(curr.next);
                    temp = minHeap.remove();
                    curr.next = temp;
                    curr = temp;
                }
                return head;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 5};
        int[] values1 = {1, 3, 4};
        int[] values2 = {2, 6};
        int[] values3 = {};

        ListNode l1 = LinkedListGenerator.createLinkedList(values);
        ListNode l2 = LinkedListGenerator.createLinkedList(values1);
        ListNode l3 = LinkedListGenerator.createLinkedList(values2);

        ListNode[] lists = new ListNode[]{l1, l2, l3};


        // LinkedListGenerator.printLinkedList( removeNthFromEnd(LinkedListGenerator.createLinkedList(values),2));
        //  LinkedListGenerator.printLinkedList(removeNthFromEnd(LinkedListGenerator.createLinkedList(values1), 1));
        LinkedListGenerator.printLinkedList(mergeKLists(lists));
    }
}
