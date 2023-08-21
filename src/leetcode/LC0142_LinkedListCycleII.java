package leetcode;

import dsa.linkedlist.ListNode;

public class LC0142_LinkedListCycleII {

    /**
     Total distance travelled:
     S -> L1 + L2
     F -> L1 + L2 + nC (where C is the length of the cycle)
     F pointer has travelled twice the distance covered by S
     => 2 (L1 + L2) = L1 + L2 + nC
     => L1 + L2 = nC
     => L1 = nC - L2
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

    private static boolean hasCycle(ListNode slow, ListNode fast) {
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }


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

    private int calculateLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        do {
            length++;
            current = current.next;
        } while (current != head);

        return length;
    }

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
