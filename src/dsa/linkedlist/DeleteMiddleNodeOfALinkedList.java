package dsa.linkedlist;

import java.util.Arrays;

/**
 * DeleteMiddleNodeOfALinkedList
 *
 * <p>Given the head of a singly linked list, delete its middle node and return the head. The
 * middle node of a list of {@code n} nodes is the one at 0-based index {@code floor(n / 2)}: for
 * odd {@code n} it is the exact centre, and for even {@code n} it is the second of the two centre
 * nodes. A single-node list becomes empty.
 *
 * <p><b>Idea:</b> to delete a node in a singly linked list, you need the node <i>before</i> it.
 * Use fast and slow pointers, but start {@code slow} one step behind the head, on a dummy node.
 * {@code fast} moves two nodes per step and {@code slow} one, so when {@code fast} runs out,
 * {@code slow} sits just before the middle. Then unlink the middle with
 * {@code slow.next = slow.next.next}. This takes one pass and no length count.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 1 -&gt; 3 -&gt; 4 -&gt; 7 -&gt; 1 -&gt; 2 -&gt; 6 has 7 nodes, so the middle is index 3
 * (value 7), giving 1 -&gt; 3 -&gt; 4 -&gt; 1 -&gt; 2 -&gt; 6. For 1 -&gt; 2 -&gt; 3 -&gt; 4, the middle is
 * index 2 (value 3), giving 1 -&gt; 2 -&gt; 4.
 *
 * @see ListNode
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DeleteMiddleNodeOfALinkedList {
    /**
     * Deletes the middle node (index {@code floor(n / 2)}) from the linked list.
     *
     * <p>An empty or single-node list has nothing left after the deletion, so it returns
     * {@code null}. Otherwise {@code slow} starts on a dummy node placed before {@code head}, and
     * {@code fast} starts at {@code head}. Each step moves {@code slow} one node and {@code fast}
     * two. After {@code k} steps {@code slow} is at index {@code k - 1}, and the loop stops after
     * {@code floor(n / 2)} steps, so {@code slow} ends just before the middle. Because the list has
     * at least two nodes, {@code slow} is never the dummy itself, so {@code head} is never removed
     * and is still the head of the result.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the linked list; may be {@code null}
     * @return the head of the list with the middle node removed, or {@code null} if the list had
     *         fewer than two nodes
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = new ListNode(), fast = head;
        slow.next = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    /**
     * Test driver covering typical and edge cases. Each input array is turned into a list, run
     * through {@link #deleteMiddle(ListNode)} and read back into an array for comparison.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 3, 4, 7, 1, 2, 6},  // n = 7: delete index 3 (value 7)
                {1, 2, 3, 4},           // n = 4: delete index 2 (value 3), the second centre node
                {1, 2, 3},              // n = 3: delete index 1 (value 2)
                {2, 1},                 // n = 2: delete index 1 (value 1)
                {1},                    // n = 1: the only node is the middle, list becomes empty
                {},                     // empty list
        };
        int[][] expected = {
                {1, 3, 4, 1, 2, 6},
                {1, 2, 4},
                {1, 3},
                {2},
                {},
                {},
        };

        DeleteMiddleNodeOfALinkedList solver = new DeleteMiddleNodeOfALinkedList();
        for (int t = 0; t < inputs.length; t++) {
            // build the list from the input array
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (int val : inputs[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }

            ListNode result = solver.deleteMiddle(dummy.next);

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
