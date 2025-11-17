package dsa.linkedlist;

/**
 * RemoveNthNodeFromEndOfList
 * 
 * <p>This class provides a solution to remove the nth node from the end of a linked list
 * using the two-pointer technique. Maintains a fixed distance of n nodes between two pointers
 * to locate and remove the target node in one pass.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * Removes the nth node from the end of the linked list.
     * 
     * <p>Algorithm:
     * 1. Use a sentinel node to simplify edge case handling
     * 2. Move fast pointer n steps ahead to create a gap
     * 3. Move both slow and fast pointers together until fast reaches the end
     * 4. The slow pointer will be at the node before the one to remove
     * 5. Skip the target node by updating the next pointer
     * 
     * <p>Time Complexity: O(L) where L is the length of the list
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
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode slow = sentinel;
        ListNode fast = head;

        // Moving the fast pointer by N steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Maintaining the distance N between the slow and fast pointer
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return sentinel.next;
    }
}
