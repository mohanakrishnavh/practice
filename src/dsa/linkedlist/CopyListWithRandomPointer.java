package dsa.linkedlist;

/**
 * CopyListWithRandomPointer
 * 
 * <p>This class provides a solution to create a deep copy of a linked list where each node
 * contains an additional random pointer that can point to any node in the list or null.
 * The implementation uses an in-place technique that interweaves the copied nodes with
 * original nodes, then separates them.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CopyListWithRandomPointer {
    /**
     * Represents a node in the linked list with a value, next pointer, and random pointer.
     */
    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Creates a deep copy of a linked list with random pointers.
     * 
     * <p>This method uses a three-step approach:
     * 1. Interweave original and copied nodes in the same list
     * 2. Assign random pointers to the copied nodes
     * 3. Separate the copied nodes from the original list
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1) excluding the space for the copied list
     * 
     * @param head the head of the original linked list
     * @return the head of the deep copied linked list
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // Step 1: Create deep copy of nodes and place it in the original list
        // The new node is inserted immediately after the original node
        Node current = head, next;
        while(current != null) {
            next = current.next;
            Node copy = new Node(current.val);
            current.next = copy;
            copy.next = next;

            current = current.next.next;
        }

        // Step2: Assign the random links for the copy nodes
        current = head;
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step3: Connect the next nodes for the copy and disconnect the
        // copy from the original list
        Node sentinel = new Node(-1);
        Node copy = sentinel;
        current = head;
        while(current != null) {
            // Next node of the original list
            next = current.next.next;

            // Add the new node in the copy list
            copy.next = current.next;
            copy = copy.next;

            // Restore the original list
            current.next = next;
            current = next;
        }

        return sentinel.next;
    }
}
