package dsa.linkedlist;

/**
 * RemoveDuplicatesFromSortedList
 * 
 * <p>This class provides a solution to remove duplicate values from a sorted linked list.
 * Each value should appear only once in the resulting list. Since the list is sorted,
 * duplicates are consecutive and can be removed in a single pass.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Removes all duplicate values from a sorted linked list.
     * 
     * <p>Traverses the list and compares each node with its next node. If values
     * are equal, skips the next node by adjusting pointers. Otherwise, moves to
     * the next node.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the sorted linked list
     * @return the head of the list with duplicates removed
     * 
     * @example
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
