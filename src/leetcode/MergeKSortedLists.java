package leetcode;

import dsa.linkedlist.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        int k = lists.length;
        ListNode head = new ListNode(-1);
        ListNode previous = head;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.node.value - b.node.value);

        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                minHeap.add(new Pair(i, lists[i]));
            }
        }

        while (minHeap.size() > 0) {
            Pair pair = minHeap.poll();
            previous.next = pair.node;
            previous = previous.next;
            lists[pair.index] = lists[pair.index].next;

            if (lists[pair.index] != null) {
                minHeap.add(new Pair(pair.index, lists[pair.index]));
            }
        }


        return head.next;
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
