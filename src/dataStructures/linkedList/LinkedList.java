package dataStructures.linkedList;

public class LinkedList {
    public static ListNode getLinkedList(int[] arr) {
        ListNode start = null;
        ListNode prevNode = null;

        for (int data : arr) {
            ListNode newNode = new ListNode(data);

            if (start == null) {
                start = newNode;
                prevNode = newNode;
            } else {
                prevNode.next = newNode;
                prevNode = newNode;
            }
        }

        return start;
    }

    public static void printList(ListNode start) {
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
        System.out.println();
    }
}
