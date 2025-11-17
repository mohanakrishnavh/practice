package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 237: Delete Node in a Linked List
 * Difficulty: Medium
 * 
 * <p>Delete a node from a linked list given only access to that node.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
