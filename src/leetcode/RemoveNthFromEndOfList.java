package leetcode;

import dsa.linkedlist.ListNode;

/**
 * RemoveNthFromEndOfList
 * 
 * Removes the n-th node from the end of a linked list.
 *
 * <p>Approach: Two pointers with a sentinel node. Advance one pointer {@code n} steps ahead,
 * then move both until the lead pointer falls off the end; the trailing pointer is then at the
 * node to delete.
 *
 * <p>Time Complexity: O(n) single pass. Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RemoveNthFromEndOfList {
    /**
     * Removes the n-th node from the end and returns the updated head.
     *
     * @param head the head of the list
     * @param n the 1-based position from the end
     * @return the head of the resulting list, or null if the input list is empty
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode forward = sentinel;
        for (int i = 0; i < n; i++) {
            forward = forward.next;
        }

        ListNode current = sentinel;
        ListNode previous = null;
        while (forward != null) {
            previous = current;
            current = current.next;
            forward = forward.next;
        }

        previous.next = current.next;

        return sentinel.next;
    }
}
