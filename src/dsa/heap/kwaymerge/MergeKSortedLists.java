package dsa.heap.kwaymerge;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

/**
 * MergeKSortedLists
 * 
 * Merges k sorted linked lists into one sorted linked list using a min heap.
 *
 * <p>Problem: Given an array of k linked lists, each sorted in ascending order,
 * merge them into a single sorted linked list and return its head.
 *
 * <p>Example:
 * <pre>
 * Input:  [1 -> 4 -> 5, 1 -> 3 -> 4, 2 -> 6]
 * Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
 * </pre>
 *
 * <p>Approach (K-way merge): Push the head of every non-empty list into a min heap ordered by
 * node value. Repeatedly poll the smallest node, append it to the result, and push that node's
 * successor. A sentinel node simplifies building the result list.
 *
 * <p>Time Complexity: O(N log k) where N is the total number of nodes
 * <p>Space Complexity: O(k) for the heap
 *
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MergeKSortedLists {
    /**
     * Merges the given sorted linked lists into one sorted list.
     *
     * @param lists array of sorted list heads; null entries are skipped
     * @return the head of the merged sorted list, or null if there are no nodes
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode sentinel = new ListNode();
        ListNode current = sentinel;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int k = lists.length;
        // Append the first elements from all the lists
        for (int i=0; i < k; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            // Append to the result
            current.next = node;
            current = current.next;

            // Update the min node list
            node = node.next;
            if (node != null) {
                pq.offer(node);
            }
        }

        return sentinel.next;
    }
}
