package dsa.linkedlist;

import java.util.Arrays;

/**
 * RotateList (LeetCode 61)
 *
 * <p>Given the head of a singly linked list, rotate the list to the right by {@code k} places and
 * return the new head. Rotating right by one moves the last node to the front.
 *
 * <p><b>Idea:</b> rotating a list of length {@code n} by {@code n} gives back the same list, so
 * only {@code k % n} rotations matter. Rotating right by {@code k} means the last {@code k} nodes
 * move, in order, to the front. So find the tail and the length in one pass, then:
 * <ul>
 *   <li>the new tail is the node at index {@code n - k - 1};</li>
 *   <li>the new head is the node after it;</li>
 *   <li>link the old tail to the old head, and cut the list after the new tail.</li>
 * </ul>
 * Only three pointers change; no nodes are created.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: [1, 2, 3, 4, 5] with k = 2: the last two nodes (4, 5) move to the front, giving
 * [4, 5, 1, 2, 3]. [0, 1, 2] with k = 4: 4 % 3 = 1, so it rotates once, giving [2, 0, 1].
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see ListNode
 * @see leetcode.LC0061_RotateList
 */
public class RotateList {

    /**
     * Rotates the list to the right by {@code k} places.
     *
     * <p>Steps:
     * <ol>
     *   <li>An empty list, a single node or {@code k < 1} leaves the list unchanged.</li>
     *   <li>Walk to the tail, counting the length.</li>
     *   <li>Reduce {@code k} to {@code k % length}; if it becomes 0, the list is unchanged.</li>
     *   <li>Step {@code length - k - 1} times from the head to reach the new tail.</li>
     *   <li>The node after it is the new head. Cut the list after the new tail, and link the old
     *       tail to the old head.</li>
     * </ol>
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the linked list; may be {@code null}
     * @param k    the number of places to rotate right; may be larger than the length
     * @return the head of the rotated list
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k < 1) {
            return head;
        }

        // find the tail and the length
        int length = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            length++;
        }

        // rotating by a multiple of the length changes nothing
        k = k % length;
        if (k == 0) {
            return head;
        }

        // walk to the new tail, which is length - k - 1 steps from the head
        ListNode current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }

        // the node after the new tail becomes the head; join old tail to old head
        ListNode temp = current.next;
        current.next = null;
        tail.next = head;
        head = temp;

        return head;
    }

    /**
     * Test driver covering the LeetCode examples and edge cases. Each input array is turned into a
     * list, run through {@link #rotateRight(ListNode, int)} and read back into an array for
     * comparison.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4, 5},  // Example 1
                {0, 1, 2},        // Example 2: k is larger than the length
                {1, 2, 3, 4, 5},  // k = 0: unchanged
                {1, 2, 3, 4, 5},  // k = length: unchanged
                {1, 2, 3, 4, 5},  // k = length - 1: the head becomes the tail
                {1, 2, 3, 4, 5},  // k = 1: the tail moves to the front
                {1, 2},           // two nodes, very large k (odd, so it swaps)
                {1},              // single node
                {},               // empty list
        };
        int[] ks = {2, 4, 0, 5, 4, 1, 2_000_000_001, 3, 7};
        int[][] expected = {
                {4, 5, 1, 2, 3},
                {2, 0, 1},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 1},
                {5, 1, 2, 3, 4},
                {2, 1},
                {1},
                {},
        };

        RotateList solver = new RotateList();
        for (int t = 0; t < inputs.length; t++) {
            // build the list from the input array
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int val : inputs[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            ListNode result = solver.rotateRight(dummy.next, ks[t]);

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
                    + ", k = " + ks[t] + " (expected " + Arrays.toString(expected[t]) + ", got " + Arrays.toString(got) + ")");
        }
    }
}
