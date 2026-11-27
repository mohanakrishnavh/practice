package dsa.linkedlist;

/**
 * DoublyLinkedListNode
 *
 * <p>A node of a doubly linked list. It holds an int value and two links: {@code next} to the
 * following node and {@code prev} to the preceding one. A {@code null} link marks an end of the
 * list: the head's {@code prev} and the tail's {@code next} are {@code null}.
 *
 * <p>Having both links lets a list be walked in either direction, and lets a node be unlinked in
 * O(1) once you hold a reference to it, since its neighbour on each side can be reached directly.
 * The cost is one extra pointer per node, and every insert or delete has to update both
 * directions.
 *
 * <p>The fields are package-private, so they can be read and changed directly by
 * {@link DoublyLinkedList} and the problem solutions in this package.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see DoublyLinkedList
 * @see ListNode
 */
public class DoublyLinkedListNode {
    /** The value stored in this node. */
    int val;
    /** The following node, or {@code null} if this is the tail. */
    DoublyLinkedListNode next;
    /** The preceding node, or {@code null} if this is the head. */
    DoublyLinkedListNode prev;

    /**
     * Creates a detached node: both {@code next} and {@code prev} start as {@code null}, so the
     * node is not part of any list until it is linked in.
     *
     * @param val the value stored in the node
     */
    public DoublyLinkedListNode(int val) {
        this.val = val;
    }
}
