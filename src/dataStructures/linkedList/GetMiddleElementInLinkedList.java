package dataStructures.linkedList;

/*
Given a singly linked list, with head node as head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

@Link - https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class GetMiddleElementInLinkedList {
    public static ListNode getMiddleElementInLinkedList(ListNode head) {

        // If head is null, then return head
        if (head == null) {
            return head;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            /*
            move fast pointer by two steps
             */
            fastPointer = fastPointer.next.next;

            /*
            move slow pointer by one step
             */
            slowPointer = slowPointer.next;
        }

        /*
        return the slowPointer as middle element of LinkedList
         */
        return slowPointer;
    }
}
