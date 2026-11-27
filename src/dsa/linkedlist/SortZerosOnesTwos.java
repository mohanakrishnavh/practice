package dsa.linkedlist;

import java.util.Arrays;

/**
 * SortZerosOnesTwos
 *
 * <p>Given the head of a singly linked list whose values are only 0, 1 and 2, rearrange the nodes
 * so that all 0s come first, then all 1s, then all 2s, and return the new head.
 *
 * <p><b>Idea:</b> there are only three possible values, so no general sort is needed. Walk the
 * list once and move each node onto one of three chains, for 0s, 1s and 2s. Each chain starts at
 * a dummy node, so appending never needs a special case for an empty chain. At the end, join the
 * chains in order: 0s, then 1s, then 2s. Nodes are relinked, not copied, and nodes with equal
 * values keep their original order.
 *
 * <p>Time complexity: O(n). Space complexity: O(1) (three dummy nodes).
 *
 * <p>Example: 1 -&gt; 2 -&gt; 2 -&gt; 1 -&gt; 2 -&gt; 0 -&gt; 2 -&gt; 2 becomes
 * 0 -&gt; 1 -&gt; 1 -&gt; 2 -&gt; 2 -&gt; 2 -&gt; 2 -&gt; 2.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see ListNode
 */
public class SortZerosOnesTwos {

    /**
     * Rearranges a list of 0s, 1s and 2s so the 0s come first, then the 1s, then the 2s.
     *
     * <p>Lists with fewer than two nodes are returned as is. Otherwise:
     * <ol>
     *   <li>Create a dummy head for each value; each chain also tracks its tail.</li>
     *   <li>Walk the list and append each node to the tail of the chain for its value. Any value
     *       other than 0 or 1 goes onto the 2s chain.</li>
     *   <li>Join the chains. The 0s tail links to the first 1, or to the first 2 if there are no
     *       1s. The 1s tail links to the first 2. If a chain is empty, its tail is still its dummy
     *       node, so these links are harmless.</li>
     *   <li>Set {@code twosTail.next = null}. That node may still point at a node from earlier in
     *       the original list, which would make a cycle.</li>
     * </ol>
     * The result starts after the 0s dummy. That is the first 1 or the first 2 if there are no 0s.
     *
     * @param head the head of a list containing only 0, 1 and 2; may be {@code null}
     * @return the head of the rearranged list
     */
    public ListNode segregate(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode zerosHead = new ListNode(-1), onesHead = new ListNode(-1), twosHead = new ListNode(-1);
        ListNode zerosTail = zerosHead, onesTail = onesHead, twosTail = twosHead;

        ListNode current = head;
        while(current != null) {
            if (current.val == 0) {
                zerosTail.next = current;
                zerosTail = current;
            } else if (current.val == 1) {
                onesTail.next = current;
                onesTail = current;
            } else {
                twosTail.next = current;
                twosTail = current;
            }

            current = current.next;
        }

        zerosTail.next = (onesHead.next != null) ? onesHead.next : twosHead.next;
        onesTail.next = twosHead.next;
        twosTail.next = null;

        return zerosHead.next;
    }

    /**
     * Test driver covering the given examples and edge cases. Each input array is turned into a
     * list, run through {@link #segregate(ListNode)} and read back into an array for comparison.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 2, 1, 2, 0, 2, 2},  // Example 1
                {2, 2, 0, 1},              // Example 2
                {0, 1, 2, 0, 1, 2},        // all three values, mixed
                {2, 1, 0},                 // reverse order
                {0, 0, 1, 1, 2, 2},        // already sorted
                {2, 0, 2, 0},              // no 1s: 0s link straight to 2s
                {1, 0, 1, 0},              // no 2s: 1s end the list
                {2, 1, 2, 1},              // no 0s: the head is the first 1
                {2, 2, 2},                 // only 2s
                {1},                       // single node
                {},                        // empty list
        };
        int[][] expected = {
                {0, 1, 1, 2, 2, 2, 2, 2},
                {0, 1, 2, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 1, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 0, 2, 2},
                {0, 0, 1, 1},
                {1, 1, 2, 2},
                {2, 2, 2},
                {1},
                {},
        };

        SortZerosOnesTwos solver = new SortZerosOnesTwos();
        for (int t = 0; t < inputs.length; t++) {
            // build the list from the input array
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int val : inputs[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            ListNode result = solver.segregate(dummy.next);

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
