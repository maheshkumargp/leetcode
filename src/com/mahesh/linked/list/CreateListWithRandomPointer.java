package com.mahesh.linked.list;

import java.util.HashMap;

public class CreateListWithRandomPointer {
    public static Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head.next;
        Node copyCurr = new Node(head.val);
        Node newHead = copyCurr;
        Node prev = copyCurr;
        map.put(head, copyCurr);
        while (curr != null) {

            copyCurr = new Node(curr.val);
            map.put(curr, copyCurr);
            prev.next = copyCurr;
            prev = copyCurr;
            curr = curr.next;

        }

        curr = head;
        copyCurr = newHead;
        while (curr != null) {
            copyCurr.random = map.get(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return newHead;

    }

    public static void main(String[] args) {
        //Node head1 = LinkedListGenerator.createRandomLinkedList(new Integer[][]{{7, null}, {11, 4}, {10, 2}, {13, 0}, {1, 0}});
       // Node head1 = LinkedListGenerator.createRandomLinkedList(new Integer[][]{{3,null}, {3,0}, {3,null}});
        Node head1 = LinkedListGenerator.createRandomLinkedList(new Integer[][]{{1,1}, {2,1}});
        copyRandomList(head1);
        LinkedListGenerator.printLinkedList(head1);
    }
}
