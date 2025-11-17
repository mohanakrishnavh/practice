package dsa.linkedlist;

import java.util.PriorityQueue;

/**
 * MergeKSortedLists
 * 
 * <p>This class provides a solution to merge K sorted linked lists into one sorted linked list.
 * Uses a min-heap (priority queue) to efficiently select the smallest node among all list heads
 * at each step, achieving optimal time complexity.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MergeKSortedLists {
    /**
     * Merges K sorted linked lists into a single sorted linked list.
     * 
     * <p>Algorithm:
     * 1. Add all non-null list heads to a min-heap
     * 2. Repeatedly extract the minimum node from the heap
     * 3. Add the extracted node to the result list
     * 4. If the extracted node has a next node, add it to the heap
     * 
     * <p>Time Complexity: O(N log K) where N is total number of nodes and K is number of lists
     * <p>Space Complexity: O(K) for the priority queue
     * 
     * @param lists an array of heads of K sorted linked lists
     * @return the head of the merged sorted linked list
     */
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
