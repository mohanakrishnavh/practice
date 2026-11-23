package dsa.linkedlist;

/**
 * ListNode
 * 
 * A node of a singly linked list, holding an int value and a reference to the next node.
 * Used by {@link LinkedList} and by linked list problem solutions.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;

    /**
     * Creates a node with the given value and no successor.
     *
     * @param val the value to store
     */
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    /**
     * Creates an empty node (value 0, no successor).
     */
    public ListNode() {}
}
