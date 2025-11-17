package dsa.linkedlist;

/**
 * LinkedListCycle
 * 
 * <p>This class provides a solution to detect if a linked list has a cycle using
 * Floyd's Cycle Detection Algorithm (also known as the tortoise and hare algorithm).
 * A cycle exists if a node can be reached again by continuously following the next pointer.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LinkedListCycle {
    /**
     * Determines if the linked list has a cycle.
     * 
     * <p>Uses Floyd's Cycle Detection Algorithm with two pointers:
     * - Slow pointer moves one step at a time
     * - Fast pointer moves two steps at a time
     * If there's a cycle, the fast pointer will eventually meet the slow pointer.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @return true if the list has a cycle, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        // Linked List with a cycle
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assert hasCycle(node1);

        // Linked List without a cycle
        node4.next = null;
        assert  !hasCycle(node1);
    }
}
