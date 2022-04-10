package leetcode;

import dsa.linkedlist.ListNode;

public class LC0142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
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
}
