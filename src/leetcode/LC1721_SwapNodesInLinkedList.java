package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 1721: Swapping Nodes in a Linked List
 * Difficulty: Medium
 * 
 * <p>Swap the values of the kth node from beginning and end.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC1721_SwapNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head, firstNode, secondNode;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        firstNode = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        secondNode = slow;

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
