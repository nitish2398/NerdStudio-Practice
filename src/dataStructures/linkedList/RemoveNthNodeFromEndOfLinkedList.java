package dataStructures.linkedList;

/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

@Link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfLinkedList {

    public static ListNode removeNthNodeFromEndOfLinkedList(ListNode head, int n) {
        /*
        If the Head of LinkedList is null or n is <= zero
        then return null as Nth Node from end of list can not exist.
         */
        if (head == null || n <= 0) {
            return head;
        }

        /*
        Add a dummy node to the list.
        This node will help to cover the edge case when n = length of list
        Hence in that case we have to remove 1st node.
         */
        ListNode dummy = new ListNode();
        dummy.next = head;

        /*
        set k = n+1, to get the previous node of nth node
         */
        int k = n + 1;

        ListNode kthNode = findKthNodeFromEndOfLinkedList(dummy, k);

        /*
        if the Kth node is null or next of kth node is null,
        that means the value of n is greater than length of list
         */
        if (kthNode != null && kthNode.next != null) {
            kthNode.next = kthNode.next.next;
        }

        /*
        return the next of dummy node
        as it is original head
         */
        return dummy.next;
    }

    public static ListNode findKthNodeFromEndOfLinkedList(ListNode head, int k) {

        ListNode aheadPointer = head;
        ListNode behindPointer = head;

        /*
        Move aheadPointer by N steps
         */
        while (k > 0) {
            /*
            If aheadPointer is null,
            that means length of linkedList is smaller that Number 'k'
            and the node does not exist
            */
            if (aheadPointer == null) {
                return null;
            }

            aheadPointer = aheadPointer.next;
            k--;
        }

        /*
        Iterate both pointers through LinkedList until aheadPointer reach null
        At end of loop behindPointer will point to Last Nth node of LinkedList
         */
        while (aheadPointer != null) {
            aheadPointer = aheadPointer.next;
            behindPointer = behindPointer.next;
        }

        return behindPointer;
    }
}
