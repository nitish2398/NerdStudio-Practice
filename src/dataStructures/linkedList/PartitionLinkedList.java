package dataStructures.linkedList;

/*
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

@Link - https://leetcode.com/problems/partition-list/
 */
public class PartitionLinkedList {
    public ListNode partitionLinkedList(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallerThanX = new ListNode();
        ListNode smallerThanXHead = smallerThanX;

        ListNode greaterOrEqualThanX = new ListNode();
        ListNode greaterOrEqualThanXHead = greaterOrEqualThanX;

        while (head != null) {
            if (head.val < x) {
                smallerThanX.next = head;
                smallerThanX = smallerThanX.next;
            } else {
                greaterOrEqualThanX.next = head;
                greaterOrEqualThanX = greaterOrEqualThanX.next;
            }
            head = head.next;
        }

        smallerThanX.next = greaterOrEqualThanXHead.next;
        greaterOrEqualThanX.next = null;

        return smallerThanXHead.next;
    }
}
