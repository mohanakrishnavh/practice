package dsa.linkedlist;

/**
 * LinkedListCycleII
 * 
 * <p>This class provides solutions to detect a cycle in a linked list and find the starting
 * node of the cycle. Implements Floyd's Cycle Detection Algorithm with mathematical proof
 * to locate the exact entry point of the cycle.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LinkedListCycleII {

    /**
     * Detects the starting node of the cycle in a linked list.
     * 
     * <p>Mathematical proof:
     * Let L1 = distance from head to cycle start
     * Let L2 = distance from cycle start to meeting point
     * Let C = cycle length
     * 
     * Slow pointer travels: L1 + L2
     * Fast pointer travels: L1 + L2 + nC (where n is number of complete cycles)
     * Since fast travels twice the distance of slow: 2(L1 + L2) = L1 + L2 + nC
     * Simplifying: L1 = nC - L2
     * 
     * This means the distance from head to cycle start equals the distance from
     * meeting point to cycle start (going around the cycle).
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @return the node where the cycle begins, or null if no cycle exists
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head, entry = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Case 1 : Cycle detected
            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }

                return slow;
            }
        }

        // Case 2 : No Cycle detected
        return null;
    }

    /**
     * Alternative approach to detect the cycle starting node.
     * 
     * <p>This method first detects if a cycle exists, then calculates the cycle length,
     * and finally uses two pointers with a gap equal to the cycle length to find the
     * entry point.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @return the node where the cycle begins, or null if no cycle exists
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Check if cycle exists
            if (slow == fast) {
                // Find the length of the cycle
                length = calculateLength(slow);
                break;
            }
        }

        // When there is no cycle in the given list
        if (fast == null || fast.next == null) {
            return null;
        }

        return findLoopStart(head, length);
    }

    /**
     * Calculates the length of the cycle.
     * 
     * @param head a node within the cycle
     * @return the number of nodes in the cycle
     */
    private int calculateLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        do {
            length++;
            current = current.next;
        } while (current != head);

        return length;
    }

    /**
     * Finds the starting node of the cycle using two pointers with a fixed gap.
     * 
     * @param head the head of the linked list
     * @param length the length of the cycle
     * @return the node where the cycle begins
     */
    private ListNode findLoopStart(ListNode head, int length) {
        ListNode first = head;
        ListNode second = head;

        // Giving the first node a head start by K nodes
        // K is the length of the cycle
        while(length > 0) {
            first = first.next;
            length--;
        }

        while(first != second) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assert detectCycle(node1).val == 2;
    }
}
