package dsa.linkedlist;

/**
 * InsertIntoASortedLinkedList
 * 
 * <p>This class provides a solution to insert a value into a sorted circular linked list
 * while maintaining the sorted order. Handles edge cases including inserting at boundaries
 * (smallest or largest values) and inserting into an empty or single-node list.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class InsertIntoASortedLinkedList {
    /**
     * Inserts a value into a sorted circular linked list.
     * 
     * <p>The method handles three main cases:
     * 1. Insert between two nodes where the value fits in sorted order
     * 2. Insert at the boundary (between the largest and smallest values)
     * 3. Insert when all values are the same
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the sorted circular linked list
     * @param insertVal the value to insert
     * @return the head of the modified circular linked list
     */
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node node = head;
        while (node.next != head) {
            if (node.val <= node.next.val) {
                if (insertVal >= node.val && insertVal <= node.next.val) {
                    break;
                }
            } else {
                if (insertVal >= node.val || insertVal <= node.next.val) {
                    break;
                }
            }
            node = node.next;
        }

        Node next = node.next;
        node.next = new Node(insertVal, next);

        return head;
    }

    /**
     * Represents a node in the circular linked list.
     */
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
