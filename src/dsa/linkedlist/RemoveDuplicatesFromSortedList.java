package dsa.linkedlist;

import java.util.Arrays;

/**
 * RemoveDuplicatesFromSortedList
 *
 * <p>Given the head of a sorted singly linked list, delete all duplicates so that each value
 * appears only once, and return the (still sorted) list.
 *
 * <p><b>Idea:</b> because the list is sorted, equal values sit next to each other. Walk the list
 * with one pointer; while the next node has the same value as the current one, unlink it by
 * pointing {@code current.next} past it. Once the next value differs, move on. The head never
 * changes, since the first node is always the first copy of its value.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 1 -&gt; 1 -&gt; 2 -&gt; 3 -&gt; 3 becomes 1 -&gt; 2 -&gt; 3.
 *
 * @see ListNode
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Removes duplicate values from a sorted linked list, in place.
     *
     * <p>For each node, the inner loop unlinks every following node with the same value, so a run
     * of any length (for example 1 -&gt; 1 -&gt; 1) collapses to one node before {@code current}
     * moves forward. After the inner loop {@code current.next} is either {@code null} or holds a
     * larger value, so stepping to it is safe.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the sorted linked list; may be {@code null}
     * @return the same head, with duplicates removed, or {@code null} if the list is empty
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null) {
            while (current.next != null && current.val == current.next.val) {
                current.next = current.next.next;
            }

            current = current.next;
        }

        return head;
    }

    /**
     * Test driver covering typical and edge cases. Each input array is turned into a list, run
     * through {@link #deleteDuplicates(ListNode)} and read back into an array for comparison.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 1, 2},           // one duplicate pair
                {1, 1, 2, 3, 3},     // duplicates at the start and the end
                {1, 2, 3},           // no duplicates: list is unchanged
                {1, 1, 1, 1},        // every node has the same value
                {1, 2, 2, 2, 3},     // a run of three in the middle
                {-3, -3, 0, 0, 5},   // negative values and zero
                {4},                 // single node
                {},                  // empty list
        };
        int[][] expected = {
                {1, 2},
                {1, 2, 3},
                {1, 2, 3},
                {1},
                {1, 2, 3},
                {-3, 0, 5},
                {4},
                {},
        };

        RemoveDuplicatesFromSortedList solver = new RemoveDuplicatesFromSortedList();
        for (int t = 0; t < inputs.length; t++) {
            // build the list from the input array
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int val : inputs[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            ListNode result = solver.deleteDuplicates(dummy.next);

            // read the result back into an array
            int size = 0;
            for (ListNode node = result; node != null; node = node.next) {
                size++;
            }
            int[] got = new int[size];
            int i = 0;
            for (ListNode node = result; node != null; node = node.next) {
                got[i++] = node.val;
            }

            System.out.println((Arrays.equals(got, expected[t]) ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t])
                    + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got) + ")");
        }
    }
}
