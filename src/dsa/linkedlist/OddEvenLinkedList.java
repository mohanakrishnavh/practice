package dsa.linkedlist;

import java.util.Arrays;

/**
 * OddEvenLinkedList
 *
 * <p>Given the head of a singly linked list, group all nodes at odd positions first, followed by
 * all nodes at even positions, and return the reordered list. Positions start at 1, so the head is
 * odd and the second node is even. "Odd" and "even" refer to positions, not to the values in the
 * nodes. The relative order inside each group is kept.
 *
 * <p><b>Idea:</b> the positions alternate odd, even, odd, even, ... So walk the list once and
 * deal each node onto one of two chains: the odd chain starts at the head and the even chain at
 * the second node. At the end, cut off the even chain's tail and attach the whole even chain after
 * the last odd node. Only {@code next} pointers change; no new nodes are made.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 becomes 1 -&gt; 3 -&gt; 5 -&gt; 2 -&gt; 4 (positions 1, 3,
 * 5 then 2, 4). For 2 -&gt; 1 -&gt; 3 -&gt; 5 -&gt; 6 -&gt; 4 -&gt; 7 the result is
 * 2 -&gt; 3 -&gt; 6 -&gt; 7 -&gt; 1 -&gt; 5 -&gt; 4.
 *
 * @see ListNode
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class OddEvenLinkedList {
    /**
     * Reorders the linked list so that odd-positioned nodes come first, then even-positioned ones.
     *
     * <p>Lists with fewer than two nodes are already in order and are returned as is. Otherwise:
     * <ol>
     *   <li>Start the odd chain at {@code head} and the even chain at {@code head.next}; each
     *       chain tracks its head and tail.</li>
     *   <li>Walk the rest of the list from position 3. {@code isOdd} flips after every node, so
     *       nodes are appended to the odd and even tails in turn.</li>
     *   <li>Set {@code evenTail.next = null}. When the list has an odd length, the even tail still
     *       points at the last odd node, which would make a cycle.</li>
     *   <li>Link {@code oddTail.next = evenHead} to put the even chain after the odd chain.</li>
     * </ol>
     * The head of the list doesn't change, since position 1 is odd.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1) as we only rearrange pointers
     *
     * @param head the head of the linked list; may be {@code null}
     * @return the head of the reordered linked list (the same node as {@code head})
     */
    public static ListNode getOddEvenLinkedList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head, oddTail = head, evenHead = head.next, evenTail = head.next;
        ListNode current = head.next.next;
        boolean isOdd = true;
        while(current != null) {
            if (isOdd) {
                oddTail.next = current;
                oddTail = current;
            } else {
                evenTail.next = current;
                evenTail = current;
            }

            isOdd = !isOdd;
            current = current.next;
        }

        evenTail.next = null;
        oddTail.next = evenHead;

        return oddHead;
    }

    /**
     * Test driver covering typical and edge cases. Each input array is turned into a list, run
     * through {@link #getOddEvenLinkedList(ListNode)} and read back into an array for comparison.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4, 5},        // odd length: 1, 3, 5 then 2, 4
                {2, 1, 3, 5, 6, 4, 7},  // grouping is by position, not by value
                {1, 2, 3, 4},           // even length: 1, 3 then 2, 4
                {1, 2, 3},              // smallest list where nodes actually move
                {1, 2},                 // two nodes: already in order
                {5, 5, 5, 5, 5},        // equal values: order is still by position
                {1},                    // single node
                {},                     // empty list
        };
        int[][] expected = {
                {1, 3, 5, 2, 4},
                {2, 3, 6, 7, 1, 5, 4},
                {1, 3, 2, 4},
                {1, 3, 2},
                {1, 2},
                {5, 5, 5, 5, 5},
                {1},
                {},
        };

        for (int t = 0; t < inputs.length; t++) {
            // build the list from the input array
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int val : inputs[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            ListNode result = getOddEvenLinkedList(dummy.next);

            // read the result back into an array; stop after inputs[t].length + 1 nodes so a
            // cycle shows up as a FAIL instead of looping forever
            int size = 0;
            for (ListNode node = result; node != null && size <= inputs[t].length; node = node.next) {
                size++;
            }
            int[] got = new int[size];
            int i = 0;
            for (ListNode node = result; node != null && i < size; node = node.next) {
                got[i++] = node.val;
            }

            System.out.println((Arrays.equals(got, expected[t]) ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t])
                    + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got) + ")");
        }
    }
}
