package dataStructures.linkedList;

public class IsPalindromeLinkedList {
    private ListNode leftPointer;

    public boolean isPalindrome(ListNode head) {
        leftPointer = head;
        return isPalindromeRecursion(head);
    }

    public boolean isPalindromeRecursion(ListNode rightPointer) {
        /*
        Only check if there are more than one nodes in linked list
         */
        if (rightPointer != null) {
            boolean isPalindrome = isPalindromeRecursion(rightPointer.next);
            if (!isPalindrome || rightPointer.val != leftPointer.val) {
                return false;
            }
            leftPointer = leftPointer.next;
        }

        return true;
    }
}
