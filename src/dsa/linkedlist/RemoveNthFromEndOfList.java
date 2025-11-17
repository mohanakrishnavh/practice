package dsa.linkedlist;

/**
 * RemoveNthFromEndOfList
 * 
 * <p>This class provides a solution to remove the nth node from the end of a linked list.
 * Uses a two-pointer technique with a fixed gap to identify the node to remove in a
 * single pass through the list.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RemoveNthFromEndOfList {
    /**
     * Removes the nth node from the end of the linked list.
     * 
     * <p>Algorithm:
     * 1. Use a sentinel node to handle edge cases (removing the head)
     * 2. Advance the forward pointer n steps ahead
     * 3. Move both pointers simultaneously until forward reaches the end
     * 4. The current pointer will be at the node before the one to remove
     * 5. Update pointers to skip the target node
     * 
     * <p>Time Complexity: O(L) where L is the length of the list (single pass)
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @param n the position from the end (1-indexed)
     * @return the head of the modified linked list
     * 
     * @example
     * Input: 1->2->3->4->5, n = 2
     * Output: 1->2->3->5
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
