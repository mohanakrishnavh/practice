package dsa.heap.kwaymerge;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
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
