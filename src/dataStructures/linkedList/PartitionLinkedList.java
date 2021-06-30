package dataStructures.linkedList;

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

@Link - https://leetcode.com/problems/partition-list/
 */

public class PartitionLinkedList {
    public ListNode partitionLinkedList(ListNode head, int x) {
        /*
        If head is null or there is only one node then return head
         */
        if (head == null || head.next == null) {
            return head;
        }

        /*
        create a dummy node smallerThanX
        This node will be the head of list containing all the nodes smaller than X
         */
        ListNode smallerThanX = new ListNode();
        ListNode smallerThanXHead = smallerThanX;

        /*
        create a dummy node greaterOrEqualThanX
        This node will be the head of list containing all the nodes greater or equal to X
         */
        ListNode greaterOrEqualThanX = new ListNode();
        ListNode greaterOrEqualThanXHead = greaterOrEqualThanX;

        while (head != null) {
            /*
            If the current node is having value smaller than X
            then append current node in list smallerThanX
             */
            if (head.val < x) {
                smallerThanX.next = head;
                smallerThanX = smallerThanX.next;
            } else {
                /*
                otherwise add node to list greaterOrEqualThanX
                 */
                greaterOrEqualThanX.next = head;
                greaterOrEqualThanX = greaterOrEqualThanX.next;
            }
            /*
            Move pointer by one step
             */
            head = head.next;
        }

        /*
        concat both of the linked lists
         */
        smallerThanX.next = greaterOrEqualThanXHead.next;
        /*
        Mark end of final linked list as null
         */
        greaterOrEqualThanX.next = null;

        return smallerThanXHead.next;
    }
}
