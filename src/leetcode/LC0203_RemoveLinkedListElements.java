package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 203: Remove Linked List Elements
 * Difficulty: Easy
 * 
 * <p>Remove all nodes from a linked list with a given value.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int value) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode current = head, previous = sentinel;
        while (current != null) {
            if (current.val == value) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return sentinel.next;
    }
}
