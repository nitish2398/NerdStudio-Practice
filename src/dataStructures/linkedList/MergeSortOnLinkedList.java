package dataStructures.linkedList;

/*
Given the head of a linked list, return the list after sorting it in ascending order.

@Link - https://leetcode.com/problems/sort-list/
*/

public class MergeSortOnLinkedList {
    public ListNode mergeSortOnLinkedList(ListNode head) {
        /*
        If head is null or there is only one node in list
        return head
         */
        if (head == null || head.next == null) {
            return head;
        }

        /*
        find the middle element of the linkedList
         */
        ListNode mid = getMiddleElementInLinkedList(head);

        /*
        split the linked list into two parts using middle node
         */
        ListNode leftHalf = head;
        ListNode rightHalf = mid.next;
        mid.next = null;

        /*
        further split both of the halves using recursion and merge the sorted lists
         */
        return mergeTwoSortedList(mergeSortOnLinkedList(leftHalf),
                mergeSortOnLinkedList(rightHalf));
    }

    /*
    Function Which merge two sorted list

    @Param - heads of two sorted linked list
    @Return - final sorted linked list created by merging
     */
    public static ListNode mergeTwoSortedList(ListNode head1, ListNode head2) {
        /*
        If head1 is null return head2
         */
        if (head1 == null) {
            return head2;
        }

        /*
        If head2 is null return head1
         */
        if (head2 == null) {
            return head1;
        }

        /*
        create a sorted list by picking up the smaller node out for head1 and head2
         */
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

    /*
    Function Which returns the middle element of linked list

    @Param - head of linked list
    @Return - middle elemnt
     */
    public static ListNode getMiddleElementInLinkedList(ListNode head) {
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

        return slowPointer;
    }
}
