package dsa.linkedlist;

public class LinkedList {

    ListNode head;
    int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public ListNode getHead() {
        return this.head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     *
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     *
     * */
    public int get(int index) {
        if (head == null || index < 0 || index >= length) {
            return -1;
        }

        ListNode current  = head;
        for (int i=0; i<index; i++) {
            current = current.next;
        }

        return current.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newListNode = new ListNode(val);
        newListNode.next = head;
        head = newListNode;
        length += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        ListNode current = head;
        for (int i=0; i<length-1; i++) {
           current = current.next;
        }

        current.next = new ListNode(val);
        length += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
        }
        else if (index == length) {
            addAtTail(val);
        } else {
            ListNode current = head;
            ListNode previous = null;
            for (int i=0; i<index; i++) {
                previous = current;
                current = current.next;
            }

            ListNode newListNode = new ListNode(val);
            previous.next = newListNode;
            newListNode.next = current;
            length += 1;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (head == null || index < 0 || index >= length) {
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head.next;
            ListNode previous = head;
            for (int i=1; i<index; i++) {
                previous = current;
                current = current.next;
            }

            previous.next = current.next;
        }

        length -= 1;
    }
}
