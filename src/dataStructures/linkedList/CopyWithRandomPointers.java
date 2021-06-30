package dataStructures.linkedList;

/*
A linked list of length n is given such that each node contains an additional random pointer,
which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
where each new node has its value set to the value of its corresponding original node.

Both the next and random pointer of the new nodes should point to new nodes in the copied
list such that the pointers in the original list and copied list represent the same list state.
None of the pointers in the new list should point to nodes in the original list.

@Link - https://leetcode.com/problems/copy-list-with-random-pointer/
 */

public class CopyWithRandomPointers {
    public Node copyListWithRandomPointer(Node head) {
        if (head == null) {
            return null;
        }

        Node listIterator = head;
        while (listIterator != null) {
            Node newNode = new Node(listIterator.val);

            newNode.next = listIterator.next;
            listIterator.next = newNode;

            listIterator = listIterator.next.next;
        }

        listIterator = head;
        while (listIterator != null) {
            if (listIterator.random == null) {
                listIterator.next.random = null;
            } else {
                listIterator.next.random = listIterator.random.next;
            }

            listIterator = listIterator.next.next;
        }

        Node clonedListHead = null;
        Node clonedListIterator = null;

        listIterator = head;
        while (listIterator != null) {
            if (clonedListHead == null) {
                clonedListHead = listIterator.next;
                clonedListIterator = listIterator.next;
            } else {
                clonedListIterator.next = listIterator.next;
                clonedListIterator = clonedListIterator.next;
            }

            listIterator.next = listIterator.next.next;
            listIterator = listIterator.next;
        }

        clonedListIterator.next = null;

        return clonedListHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
