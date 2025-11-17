package dsa.linkedlist;

/**
 * RemoveLinkedListElements
 * 
 * <p>This class provides a solution to remove all nodes from a linked list that have
 * a specific value. Uses a sentinel node to handle edge cases such as removing head nodes.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RemoveLinkedListElements {
    /**
     * Removes all nodes with the specified value from the linked list.
     * 
     * <p>Uses a sentinel (dummy) node to simplify handling removals at the head.
     * Traverses the list and removes nodes by updating the previous node's next pointer
     * to skip nodes with the target value.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @param value the value of nodes to remove
     * @return the head of the modified linked list
     * 
     * @example
     * Input: 1->2->6->3->4->5->6, value = 6
     * Output: 1->2->3->4->5
     */
    public ListNode removeElements(ListNode head, int value) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode current = head, previous = sentinel;
        while (current != null) {
            if (current.val == value) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return sentinel.next;
    }
}
