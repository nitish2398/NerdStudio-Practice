package dataStructures.linkedList;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

@Link - https://leetcode.com/problems/sort-list/
 */

public class MergeSortOnLinkedList {
    public ListNode mergeSortOnLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddleElementInLinkedList(head);

        ListNode leftHalf = head;
        ListNode rightHalf = mid.next;
        mid.next = null;

        return mergeTwoSortedList(mergeSortOnLinkedList(leftHalf),
                mergeSortOnLinkedList(rightHalf));
    }

    public static ListNode getMiddleElementInLinkedList(ListNode head) {

        // If head is null, then return head
        if (head == null) {
            return head;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;

            if (fastPointer == null) {
                return slowPointer;
            }

            slowPointer = slowPointer.next;
        }

        /*
        return the slowPointer as middle for even elements LinkedList
         */
        return slowPointer;
    }

    public static ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode sortedList;
        if (head1.val < head2.val) {
            sortedList = head1;
            sortedList.next = mergeTwoSortedList(head1.next, head2);
        } else {
            sortedList = head2;
            sortedList.next = mergeTwoSortedList(head1, head2.next);
        }

        return sortedList;
    }
}
