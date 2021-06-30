package dataStructures.linkedList;

/*
Given the head of a linked list, rotate the list to the right by k places.

@Link - https://leetcode.com/problems/rotate-list/
 */

public class RotateLinkedListToRightByKNodes {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        int currentLength = 0;
        ListNode listIterator = head;

        while (listIterator != null && currentLength != k) {
            listIterator = listIterator.next;
            currentLength++;
        }

        if (listIterator == null) {
            k = k % currentLength;
            return rotateRight(head, k);
        }

        ListNode node = head;
        while (listIterator.next != null) {
            listIterator = listIterator.next;
            node = node.next;
        }

        ListNode lastKthNode = node.next;
        node.next = null;

        node = lastKthNode;
        while (node.next != null) {
            node = node.next;
        }

        node.next = head;
        head = lastKthNode;

        return head;
    }
}
