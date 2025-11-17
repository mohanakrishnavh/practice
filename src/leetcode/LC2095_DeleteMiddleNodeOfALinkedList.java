package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 2095: Delete the Middle Node of a Linked List
 * Difficulty: Medium
 * 
 * <p>Delete the middle node of a linked list.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC2095_DeleteMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPointer = head, fastPointer = head;
        ListNode previous = null;

        while (fastPointer != null && fastPointer.next != null) {
            previous = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        previous.next = slowPointer.next;

        return head;
    }
}
