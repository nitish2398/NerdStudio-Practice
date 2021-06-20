package dataStructures.linkedList;

/*
Given a singly linked list, with head node as head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

@Link - https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class GetMiddleElementInLinkedList {
    public static Node getMiddleElementInLinkedList(Node head) {

        // If head is null, then return head
        if(head == null) {
            return head;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null) {

            /*
            if the next of fastPointer is null,
            that means slowPointer has reached in the middle of odd elements LinkedList
             */
            if(fastPointer.next == null) {
                return slowPointer;
            }

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        /*
        return the slowPointer as middle for even elements LinkedList
         */
        return slowPointer;
    }
}
