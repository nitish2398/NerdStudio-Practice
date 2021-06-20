package dataStructures.linkedList;

public class LinkedList {
    public static Node getLinkedList(int [] arr) {
        Node start = null;
        Node prevNode = null;

        for(int data: arr) {
            Node newNode = new Node(data);

            if(start == null) {
                start = newNode;
                prevNode = newNode;
            } else {
                prevNode.next = newNode;
                prevNode = newNode;
            }
        }

        return start;
    }

    public static void printList(Node start) {
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
        System.out.println();
    }
}
