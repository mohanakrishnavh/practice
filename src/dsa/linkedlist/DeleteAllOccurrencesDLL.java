package dsa.linkedlist;

import java.util.Arrays;

/**
 * DeleteAllOccurrencesDLL
 *
 * <p>Given the head of a doubly linked list and a value {@code x}, delete every node whose value is
 * {@code x} and return the head of the resulting list. The list does not have to be sorted, and the
 * order of the remaining nodes is kept.
 *
 * <p><b>Idea:</b> walk the list once. Keep {@code prev}, the last node that is being kept. When the
 * current node holds {@code x}, unlink it by pointing {@code prev.next} past it and pointing the
 * next node's {@code prev} back at {@code prev}. Otherwise the current node is kept and becomes
 * the new {@code prev}. A sentinel node placed before the head means a deleted head is handled
 * like any other node, and the new head is simply {@code sentinel.next}.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 2 &lt;-&gt; 2 &lt;-&gt; 10 &lt;-&gt; 8 &lt;-&gt; 4 &lt;-&gt; 2 &lt;-&gt; 5 &lt;-&gt; 2 with
 * x = 2 becomes 10 &lt;-&gt; 8 &lt;-&gt; 4 &lt;-&gt; 5.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see DoublyLinkedListNode
 */
public class DeleteAllOccurrencesDLL {

    /**
     * Deletes every node with value {@code x} from the doubly linked list.
     *
     * <p>Steps:
     * <ol>
     *   <li>Put a sentinel before {@code head}; {@code prev} starts on the sentinel.</li>
     *   <li>For each node, save {@code next} first.</li>
     *   <li>If the node holds {@code x}, set {@code prev.next = next} and, if {@code next} exists,
     *       {@code next.prev = prev}. {@code prev} stays where it is, so a run of {@code x} values
     *       is removed one node at a time.</li>
     *   <li>Otherwise the node is kept: move {@code prev} to it.</li>
     *   <li>Return {@code sentinel.next}, which is {@code null} if every node was deleted.</li>
     * </ol>
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the doubly linked list; may be {@code null}
     * @param x    the value to delete
     * @return the head of the list after deleting every {@code x}, or {@code null} if none remain
     */
    public DoublyLinkedListNode deleteAllOccurOfX(DoublyLinkedListNode head, int x) {
        DoublyLinkedListNode sentinel = new DoublyLinkedListNode(-1);
        sentinel.next = head;

        DoublyLinkedListNode prev = sentinel, current = head, next;
        while (current != null) {
            next = current.next;

            if (current.val == x) {
                prev.next = next;

                if (next != null) {
                    next.prev = prev;
                }
            } else {
                prev = current;
            }

            current = current.next;
        }

        return sentinel.next;
    }

    /**
     * Test driver covering the given examples and edge cases. Each input array is turned into a
     * doubly linked list, run through {@link #deleteAllOccurOfX(DoublyLinkedListNode, int)} and read
     * back into an array. A result passes when the values match and every {@code prev} link is
     * consistent: the head's {@code prev} is {@code null} and {@code node.next.prev == node} for
     * every node.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {2, 2, 10, 8, 4, 2, 5, 2},  // Example 1: x at the head, middle and tail
                {9, 1, 3, 4, 5, 1, 8, 4},   // Example 2: only the head is x
                {1, 2, 3, 4},               // x only at the tail
                {1, 3, 3, 3, 5},            // a run of x in the middle
                {1, 2, 3},                  // x not in the list: unchanged
                {7, 7, 7},                  // every node is x: list becomes empty
                {5},                        // single node, not x
                {5},                        // single node, is x
                {},                         // empty list
        };
        int[] xs = {2, 9, 4, 3, 9, 7, 1, 5, 1};
        int[][] expected = {
                {10, 8, 4, 5},
                {1, 3, 4, 5, 1, 8, 4},
                {1, 2, 3},
                {1, 5},
                {1, 2, 3},
                {},
                {5},
                {},
                {},
        };

        DeleteAllOccurrencesDLL solver = new DeleteAllOccurrencesDLL();
        for (int t = 0; t < inputs.length; t++) {
            // build the doubly linked list from the input array
            DoublyLinkedListNode head = null, tail = null;
            for (int val : inputs[t]) {
                DoublyLinkedListNode node = new DoublyLinkedListNode(val);
                if (head == null) {
                    head = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                }
                tail = node;
            }

            DoublyLinkedListNode result = solver.deleteAllOccurOfX(head, xs[t]);

            // read the result forward into an array, checking the prev links on the way
            boolean prevLinksOk = result == null || result.prev == null;
            int size = 0;
            for (DoublyLinkedListNode node = result; node != null; node = node.next) {
                size++;
                if (node.next != null && node.next.prev != node) {
                    prevLinksOk = false;
                }
            }
            int[] got = new int[size];
            int i = 0;
            for (DoublyLinkedListNode node = result; node != null; node = node.next) {
                got[i++] = node.val;
            }

            boolean ok = Arrays.equals(got, expected[t]) && prevLinksOk;
            System.out.println((ok ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t]) + ", x = " + xs[t]
                    + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got)
                    + (prevLinksOk ? "" : ", prev links broken") + ")");
        }
    }
}
