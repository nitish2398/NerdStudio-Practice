package dataStructures.linkedList;

/*
Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.

@Link - https://leetcode.com/problems/intersection-of-two-linked-lists/
 */

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*
        If any one the heads is null
        then no intersection point exist.

        Return null
         */
        if (headA == null || headB == null) {
            return null;
        }

        /*
        Calculate length of both linked lists.
         */
        int lengthA = lengthOfLinkedList(headA);
        int lengthB = lengthOfLinkedList(headB);

        /*
        Calculate absolute difference in length of both the lists
         */
        int lengthDiff = Math.abs(lengthA - lengthB);

        /*
        If the length of List-A is greater than List-B
        Then move head of List-A to make length equal.
         */
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthDiff; i++) {
                headA = headA.next;
            }
        } else {
            /*
            Move Head of List-B otherwise.
             */
            for (int i = 0; i < lengthDiff; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            /*
            If both of the heads are pointing to same node,
            that means this is the intersection point.
             */
            if (headA.equals(headB)) {
                return headA;
            }

            /*
            Move both pointers by one step
             */
            headA = headA.next;
            headB = headB.next;
        }

        /*
        Intersection point does not exist, return null
         */
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
