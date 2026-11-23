package dsa.linkedlist;

/**
 * DoublyLinkedList
 *
 * A doubly linked list of integers where each node links to both its next and previous node.
 *
 * <p>Supports index-based {@code get}, {@code addFirst}, {@code addLast}, {@code addAtIndex}
 * and {@code deleteAtIndex}. Index-based operations walk from the head, so they run in O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DoublyLinkedList {
    /**
     * A node holding an integer value and links to its neighbours.
     */
    public class DoublyLinkedListNode {
        int val;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        /**
         * Creates a detached node.
         *
         * @param val the value stored in the node
         */
        public DoublyLinkedListNode(int val) {
            this.val = val;

        }
    }

    private DoublyLinkedListNode head;
    private int length;

    /**
     * Creates an empty list.
     */
    public DoublyLinkedList() {
        head = null;
        length = 0;
    }

    /**
     * Returns the value at the given index.
     *
     * @param index the 0-based position
     * @return the value, or -1 if the index is out of range
     */
    public int get(int index) {
        if (index < 0 || index >= length || head == null) {
            return -1;
        }

        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    /**
     * Inserts a value at the front of the list.
     *
     * @param val the value to insert
     */
    public void addFirst(int val) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(val);

        if (head == null) {
            head = node;
            length += 1;
            return;
        }

        head.next = node;
        node.prev = head;
        head = node;
        length += 1;
    }

    /**
     * Appends a value at the end of the list.
     *
     * @param val the value to append
     */
    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
            return;
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(val);
        DoublyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        length += 1;
    }

    /**
     * Inserts a value before the node currently at {@code index}.
     * Does nothing if the index is negative or greater than the list length.
     *
     * @param val the value to insert
     * @param index the 0-based insertion position
     */
    public void addAtIndex(int val, int index) {
        if (index < 0 || index > length) {
            return;
        }

        if (index == 0) {
            addFirst(val);
            return;
        }

        if (index == length) {
            addLast(val);
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(val);
        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DoublyLinkedListNode previous = current.prev;
        previous.next = node;
        node.prev = previous;
        node.next = current;
        current.prev = node;
        length += 1;
    }

    /**
     * Removes the node at {@code index}.
     * Does nothing if the list is empty or the index is out of range.
     *
     * @param index the 0-based position of the node to remove
     */
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index < 0 || index > length - 1) {
            return;
        }

        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DoublyLinkedListNode previous = current.prev;
        previous.next = current.next;
        length -= 1;
    }
}
