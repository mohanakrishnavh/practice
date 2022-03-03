package leetcode;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

public class LC0023_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;

        int k = lists.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.node.value - b.node.value);
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minHeap.add(new Pair(i, lists[i]));
            }
        }

        while (!minHeap.isEmpty()) {
            Pair pair = minHeap.poll();
            int index = pair.index;
            current.next = pair.node;
            current = current.next;

            lists[index] = lists[index].next;

            if (lists[index] != null) {
                minHeap.add(new Pair(index, lists[index]));
            }
        }

        return sentinel.next;
    }

    class Pair {
        int index;
        ListNode node;

        public Pair(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
