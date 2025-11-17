package dsa.linkedlist;

/**
 * DeleteNodeInALinkedList
 * 
 * <p>This class provides a solution to delete a node in a singly-linked list when
 * only access to that node is provided (not the head). The solution copies the value
 * from the next node and bypasses the next node.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DeleteNodeInALinkedList {
    /**
     * Deletes the given node from the linked list.
     * 
     * <p>Since we don't have access to the previous node, we copy the value from the
     * next node into the current node and then bypass the next node, effectively
     * deleting the current node's value.
     * 
     * <p>Time Complexity: O(1)
     * <p>Space Complexity: O(1)
     * 
     * @param node the node to be deleted (guaranteed not to be the tail)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
