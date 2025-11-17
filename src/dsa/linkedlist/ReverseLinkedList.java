package dsa.linkedlist;

/**
 * ReverseLinkedList
 * 
 * <p>This class provides a solution to reverse a singly-linked list iteratively.
 * The reversal is done in-place by changing the direction of the next pointers
 * using three pointers: previous, current, and next.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ReverseLinkedList {
    /**
     * Reverses a linked list iteratively.
     * 
     * <p>Algorithm:
     * 1. Initialize three pointers: previous (null), current (head), and next
     * 2. For each node, save the next node
     * 3. Reverse the current node's pointer to point to previous
     * 4. Move previous and current one step forward
     * 5. Continue until current is null
     * 6. Return previous as the new head
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list to reverse
     * @return the head of the reversed linked list
     * 
     * @example
     * Input: 1->2->3->4->5
     * Output: 5->4->3->2->1
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null, next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
