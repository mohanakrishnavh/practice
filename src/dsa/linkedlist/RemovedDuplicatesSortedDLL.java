package dsa.linkedlist;

import java.util.Arrays;

/**
 * RemovedDuplicatesFromSortedDLL
 *
 * <p>Given the head of a sorted doubly linked list, delete the duplicates so that only the first
 * occurrence of each value is kept, and return the head.
 *
 * <p><b>Idea:</b> because the list is sorted, equal values sit next to each other. Walk the list
 * with one pointer; while the next node has the same value as the current one, unlink it. This is
 * the same as {@link RemoveDuplicatesFromSortedList}, except that a doubly linked list has two
 * links to fix for each removed node: {@code current.next} skips past the duplicate, and the node
 * after it (if any) gets its {@code prev} pointed back at {@code current}. The head never changes,
 * since the first node is always the first copy of its value.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 1 &lt;-&gt; 1 &lt;-&gt; 1 &lt;-&gt; 2 &lt;-&gt; 3 &lt;-&gt; 4 becomes
 * 1 &lt;-&gt; 2 &lt;-&gt; 3 &lt;-&gt; 4.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see DoublyLinkedListNode
 * @see RemoveDuplicatesFromSortedList
 */
public class RemovedDuplicatesSortedDLL {

    /**
     * Removes duplicate values from a sorted doubly linked list, in place.
     *
     * <p>For each node, the inner loop removes every following node with the same value, so a run
     * of any length (for example 1 &lt;-&gt; 1 &lt;-&gt; 1) shrinks to one node before {@code current}
     * moves forward. Each removal sets {@code current.next} to the node after the duplicate and,
     * if that node exists, sets its {@code prev} back to {@code current}, so both directions stay
     * consistent. After the inner loop {@code current.next} is either {@code null} or holds a
     * larger value, so stepping to it is safe.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the sorted doubly linked list; may be {@code null}
     * @return the same head, with duplicates removed, or {@code null} if the list is empty
     */
    public DoublyLinkedListNode removeDuplicates(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        while(current != null) {
            // unlink every following node with the same value
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;

                // fix the back link of the node after the removed one
                if (current.next != null) {
                    current.next.prev = current;
                }
            }

            current = current.next;
        }

        return head;
    }

    /**
     * Test driver covering the given examples and edge cases. Each input array is turned into a
     * doubly linked list, run through {@link #removeDuplicates(DoublyLinkedListNode)} and read back
     * into an array. A result passes when the values match and every {@code prev} link is
     * consistent: the head's {@code prev} is {@code null} and {@code node.next.prev == node} for
     * every node.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 1, 1, 2, 3, 4},     // Example 1: a run of three at the head
                {1, 2, 2, 3, 3, 4, 4},  // Example 2: several pairs, one at the tail
                {1, 2, 3, 4},           // no duplicates: list is unchanged
                {5, 5, 5, 5},           // every node has the same value
                {1, 2, 2, 2, 3},        // a run of three in the middle
                {-2, -2, 0, 0, 7},      // negative values and zero
                {4},                    // single node
                {},                     // empty list
        };
        int[][] expected = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {5},
                {1, 2, 3},
                {-2, 0, 7},
                {4},
                {},
        };

        RemovedDuplicatesSortedDLL solver = new RemovedDuplicatesSortedDLL();
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

            DoublyLinkedListNode result = solver.removeDuplicates(head);

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
            System.out.println((ok ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t])
                    + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got)
                    + (prevLinksOk ? "" : ", prev links broken") + ")");
        }
    }
}
