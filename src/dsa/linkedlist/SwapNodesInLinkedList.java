package dsa.linkedlist;

/**
 * SwapNodesInLinkedList
 * 
 * <p>This class provides a solution to swap the values of the kth node from the beginning
 * and the kth node from the end in a linked list. Uses a two-pointer approach to locate
 * both nodes in a single pass.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SwapNodesInLinkedList {
    /**
     * Swaps the values of the kth node from the beginning and kth node from the end.
     * 
     * <p>Algorithm:
     * 1. Move fast pointer k-1 steps to reach the kth node from the beginning
     * 2. Save this as firstNode
     * 3. Continue moving fast to the end while moving slow from the head
     * 4. When fast reaches the end, slow will be at the kth node from the end
     * 5. Swap the values of firstNode and secondNode
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @param k the position from the beginning/end (1-indexed)
     * @return the head of the modified linked list
     * 
     * @example
     * Input: 1->2->3->4->5, k = 2
     * Output: 1->4->3->2->5 (swapped nodes with values 2 and 4)
     */
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head, firstNode, secondNode;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        firstNode = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        secondNode = slow;

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
