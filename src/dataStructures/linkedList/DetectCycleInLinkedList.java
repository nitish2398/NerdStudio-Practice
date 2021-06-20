package dataStructures.linkedList;

/*
Given startPointer, the head of a linked list, determine if the linked list has a cycle in it.

@Link - https://leetcode.com/problems/linked-list-cycle/
*/

public class DetectCycleInLinkedList {
    public static boolean detectCycleInLinkedList(Node startPointer) {

        // If startPointer is null, then no cycle Exist
        if(startPointer == null) {
            return false;
        }

        Node slowPointer = startPointer;
        Node fastPointer = startPointer;

        while (fastPointer != null) {

            /*
            If the next of fastPointer is null, that means it is end of linked list.
            So, cycle does not exist
             */
            if(fastPointer.next == null) {
                return false;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            /*
            If fastPointer has captured the slow pointer
            then, cycle does exist
             */
            if(slowPointer.equals(fastPointer)) {
                return true;
            }
        }

        return false;
    }
}
