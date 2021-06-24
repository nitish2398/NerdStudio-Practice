package dataStructures.linkedList;

/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

@Link - https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lengthA = lengthOfLinkedList(headA);
        int lengthB = lengthOfLinkedList(headB);

        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lengthB - lengthA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    /*
    Function to calculate the length of LinkedList

    @Param - Head of linked list
    @Return - length of linked list
     */
    public int lengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode clone = head;

        while (clone != null) {
            length++;
            clone = clone.next;
        }

        return length;
    }
}
