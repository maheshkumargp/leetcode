package com.mahesh.linked.list;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList_23_2 {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode ln : lists) {
            heap.offer(ln);
        }
        ListNode head = heap.poll();
        ListNode temp =head;
        if(temp.next!=null) heap.offer(temp.next);
        while (!heap.isEmpty()) {
            ListNode curr = heap.poll();
            if (curr != null) {
                temp.next = curr;
                temp = temp.next;
                if (curr.next != null)
                    heap.offer(curr.next);
            }
        }
        return head;
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
