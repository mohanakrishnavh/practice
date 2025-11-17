package dsa.linkedlist;

/**
 * DeleteMiddleNodeOfALinkedList
 * 
 * <p>This class provides a solution to delete the middle node of a linked list.
 * The middle node is defined as the node at position floor(n/2) where n is the
 * total number of nodes. Uses the fast and slow pointer technique to find the middle.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DeleteMiddleNodeOfALinkedList {
    /**
     * Deletes the middle node from the linked list.
     * 
     * <p>Uses the two-pointer technique where the fast pointer moves twice as fast
     * as the slow pointer. When the fast pointer reaches the end, the slow pointer
     * will be at the middle node.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @return the head of the modified linked list with the middle node removed
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPointer = head, fastPointer = head;
        ListNode previous = null;

        while (fastPointer != null && fastPointer.next != null) {
            previous = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        previous.next = slowPointer.next;

        return head;
    }
}
