package leetcode;

import dsa.linkedlist.ListNode;

public class LC0024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode previous = sentinel, current = head, next;
        ListNode firstNode, secondNode;
        while (current != null && current.next != null) {
            // Keeping reference of the rest of the linked list
            next = current.next.next;

            // Nodes that need to be swapped
            firstNode = current.next;
            secondNode = current;

            // Swapping the nodes
            previous.next = firstNode;
            firstNode.next = secondNode;
            secondNode.next = next;

            // Moving previous and current for next iteration
            previous = secondNode;
            current = next;
        }

        return sentinel.next;
    }
}
