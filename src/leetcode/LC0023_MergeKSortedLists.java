package leetcode;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * LeetCode Problem 23: Merge K Sorted Lists
 * Difficulty: Hard
 * 
 * <p>Merge k sorted linked lists into one sorted list.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node: lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;
        ListNode next;
        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            next = node.next;

            current.next = node;
            node.next = null;
            current = current.next;

            if (next != null) {
                minHeap.add(next);
            }
        }

        return sentinel.next;
    }
}
