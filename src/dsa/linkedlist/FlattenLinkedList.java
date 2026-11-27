package dsa.linkedlist;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * FlattenLinkedList
 *
 * <p>Given a linked list where every node has two pointers, flatten it into a single sorted list.
 * <ul>
 *   <li>{@code next} links the heads of the sub-lists, left to right.</li>
 *   <li>{@code bottom} links the nodes inside one sub-list. Each sub-list is sorted.</li>
 * </ul>
 * The result is one sorted list joined only through {@code bottom} pointers, with every
 * {@code next} pointer set to {@code null}.
 *
 * <p><b>Idea:</b> each vertical sub-list is already sorted, so this is merging M sorted lists.
 * Two approaches are provided, where N is the total number of nodes and M the number of
 * sub-lists:
 * <ul>
 *   <li>{@link #flatten(ListNode)}: merge the sub-lists into the result one at a time, using the
 *       "merge two sorted lists" step along {@code bottom}. O(N * M) time, O(1) space.</li>
 *   <li>{@link #flattenOptimized(ListNode)}: keep the current front node of every sub-list in a
 *       min-heap, and repeatedly take the smallest one, appending it to the result and pushing
 *       the node below it. O(N log M) time, O(M) space.</li>
 * </ul>
 * Both relink the existing nodes; none are copied.
 *
 * <p>Example: sub-lists 5 -&gt; 7 -&gt; 8, 10 -&gt; 20, 19 -&gt; 22 and 28 -&gt; 40 -&gt; 45 flatten to
 * 5 -&gt; 7 -&gt; 8 -&gt; 10 -&gt; 19 -&gt; 20 -&gt; 22 -&gt; 28 -&gt; 40 -&gt; 45.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FlattenLinkedList {

    /**
     * A node with two links: {@code next} to the head of the next sub-list and {@code bottom} to
     * the next node in its own sub-list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode bottom;

        /**
         * Creates a node with the given value and no links.
         *
         * @param val the value to store
         */
        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Flattens the multi-level list into one sorted list linked through {@code bottom}.
     *
     * <p>A {@code null} head or a single sub-list is already flat and is returned as is.
     * Otherwise {@code head1} holds the merged result so far and {@code head2} the next sub-list.
     * On each step:
     * <ol>
     *   <li>Save {@code head2.next}, the sub-list after this one.</li>
     *   <li>Clear {@code head1.next} and merge {@code head2} into {@code head1}.</li>
     *   <li>Clear {@code head2.next}, then move {@code head2} on to the saved sub-list.</li>
     * </ol>
     * Clearing the {@code next} pointers makes sure the result is linked only through
     * {@code bottom}.
     *
     * <p>Time Complexity: O(N * M), where N is the total number of nodes and M the number of
     * sub-lists. There are M - 1 merges, and each can walk up to N nodes.
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the first sub-list; may be {@code null}
     * @return the head of the flattened, sorted list
     */
    public ListNode flatten(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode head1 = head, head2 = head.next;
        while(head1 != null && head2 != null) {
            ListNode temp = head2.next;

            head1.next = null;
            head1 = merge(head1, head2);

            head2.next = null;
            head2 = temp;
        }

        return head1;
    }

    /**
     * Merges two sorted lists, linked through {@code bottom}, into one sorted list.
     *
     * <p>A sentinel node avoids a special case for the first node. Each step attaches the smaller
     * of the two current nodes. When one list runs out, the rest of the other is already sorted
     * and is attached in one go. If the values are equal, the node from {@code head2} goes first.
     *
     * <p>Time Complexity: O(a + b), where a and b are the lengths of the two lists
     * <p>Space Complexity: O(1)
     *
     * @param head1 the head of the first sorted list
     * @param head2 the head of the second sorted list
     * @return the head of the merged list
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;

        while(head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.bottom = head1;
                head1 = head1.bottom;
            } else {
                current.bottom = head2;
                head2 = head2.bottom;
            }

            current = current.bottom;
        }

        if (head1 != null) {
            current.bottom = head1;
        }

        if (head2 != null) {
            current.bottom = head2;
        }

        return sentinel.bottom;
    }

    /**
     * Flattens the multi-level list using a min-heap of sub-list fronts (a k-way merge).
     *
     * <p>A {@code null} head or a single sub-list is already flat and is returned as is.
     * Otherwise:
     * <ol>
     *   <li>Walk the heads along {@code next}, clear each {@code next} pointer, and add the head
     *       to the heap. The heap now holds the smallest unused node of every sub-list.</li>
     *   <li>Repeatedly poll the smallest node and append it to the result through
     *       {@code bottom}. If it has a node below it, push that node. It is the next candidate
     *       from the same sub-list.</li>
     *   <li>When the heap is empty, every node has been appended. The last node polled was the
     *       end of its sub-list, so its {@code bottom} is already {@code null}.</li>
     * </ol>
     * The heap never holds more than one node per sub-list, so it has at most M entries.
     *
     * <p>Time Complexity: O(N log M), where N is the total number of nodes and M the number of
     * sub-lists. Every node is pushed and polled once, and each heap operation costs O(log M).
     * <p>Space Complexity: O(M) for the heap
     *
     * @param head the head of the first sub-list; may be {@code null}
     * @return the head of the flattened, sorted list
     */
    public ListNode flattenOptimized(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode current = head;
        while(current != null) {
            ListNode temp = current.next;

            current.next = null;
            pq.offer(current);

            current = temp;
        }

        ListNode sentinel = new ListNode(-1);
        current = sentinel;
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            current.bottom = node;
            current = node;

            if (node.bottom != null) {
                pq.offer(node.bottom);
            }
        }

        return sentinel.bottom;
    }

    /**
     * Test driver for both approaches. Each case lists the sub-lists from left to right, each one
     * top to bottom. The heads are linked with {@code next} and each sub-list with {@code bottom}.
     * Both methods relink the nodes they are given, so a fresh list is built for each method. A
     * result passes when reading it along {@code bottom} gives the expected values and every
     * {@code next} is {@code null}.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][][] inputs = {
                // Example 1: 5 -> 7 -> 8, 10 -> 20, 19 -> 22, 28 -> 40 -> 45
                {{5, 7, 8}, {10, 20}, {19, 22}, {28, 40, 45}},
                // Example 2: 5 -> 7 -> 8 -> 30, 10, 19 -> 22 -> 50, 28
                {{5, 7, 8, 30}, {10}, {19, 22, 50}, {28}},
                // a single sub-list is already flat
                {{1, 2, 3}},
                // sub-lists of one node each, in reverse order
                {{3}, {2}, {1}},
                // equal values across sub-lists
                {{1, 4}, {1, 4}, {2}},
                // a single node
                {{9}},
                // empty list
                {},
        };
        int[][] expected = {
                {5, 7, 8, 10, 19, 20, 22, 28, 40, 45},
                {5, 7, 8, 10, 19, 22, 28, 30, 50},
                {1, 2, 3},
                {1, 2, 3},
                {1, 1, 2, 4, 4},
                {9},
                {},
        };

        FlattenLinkedList solver = new FlattenLinkedList();
        String[] methods = {"flatten", "flattenOptimized"};
        for (String method : methods) {
            System.out.println("--- " + method + " ---");
            for (int t = 0; t < inputs.length; t++) {
                // build a fresh list: heads linked with next, each sub-list with bottom
                ListNode head = null, prevTop = null;
                int total = 0;
                for (int[] column : inputs[t]) {
                    ListNode top = solver.new ListNode(column[0]);
                    ListNode below = top;
                    for (int r = 1; r < column.length; r++) {
                        below.bottom = solver.new ListNode(column[r]);
                        below = below.bottom;
                    }
                    total += column.length;

                    if (prevTop == null) {
                        head = top;
                    } else {
                        prevTop.next = top;
                    }
                    prevTop = top;
                }

                ListNode result = method.equals("flatten") ? solver.flatten(head) : solver.flattenOptimized(head);

                // read the result along bottom; stop after total + 1 nodes so a cycle shows up as
                // a FAIL, and check that every next pointer was cleared
                int size = 0;
                boolean nextCleared = true;
                for (ListNode node = result; node != null && size <= total; node = node.bottom) {
                    size++;
                    nextCleared &= node.next == null;
                }
                int[] got = new int[size];
                int i = 0;
                for (ListNode node = result; node != null && i < size; node = node.bottom) {
                    got[i++] = node.val;
                }

                boolean ok = Arrays.equals(got, expected[t]) && nextCleared;
                System.out.println((ok ? "PASS" : "FAIL") + " - " + Arrays.deepToString(inputs[t])
                        + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got)
                        + (nextCleared ? "" : ", next pointers not cleared") + ")");
            }
        }
    }
}
