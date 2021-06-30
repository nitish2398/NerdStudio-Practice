package dataStructures.linkedList;

public class ReverseInGroupOfK {
    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode prevNode = null;
        ListNode nextNode = null;
        ListNode currentNode = head;

        while (currentNode != null && count < k) {
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;
        }

        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        return prevNode;
    }
}