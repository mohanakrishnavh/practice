package dsa.linkedlist;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * CopyListWithRandomPointer
 * 
 * <p>This class provides a solution to create a deep copy of a linked list where each node
 * contains an additional random pointer that can point to any node in the list or null.
 * The implementation uses an in-place technique that interweaves the copied nodes with
 * original nodes, then separates them.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CopyListWithRandomPointer {
    /**
     * Represents a node in the linked list with a value, next pointer, and random pointer.
     */
    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Creates a deep copy of a linked list with random pointers.
     * 
     * <p>This method uses a three-step approach:
     * 1. Interweave original and copied nodes in the same list
     * 2. Assign random pointers to the copied nodes
     * 3. Separate the copied nodes from the original list
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1) excluding the space for the copied list
     * 
     * @param head the head of the original linked list
     * @return the head of the deep copied linked list
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // Step 1: Create deep copy of nodes and place it in the original list
        // The new node is inserted immediately after the original node
        Node current = head, next;
        while(current != null) {
            next = current.next;
            Node copy = new Node(current.val);
            current.next = copy;
            copy.next = next;

            current = current.next.next;
        }

        // Step2: Assign the random links for the copy nodes
        current = head;
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step3: Connect the next nodes for the copy and disconnect the
        // copy from the original list
        Node sentinel = new Node(-1);
        Node copy = sentinel;
        current = head;
        while(current != null) {
            // Next node of the original list
            next = current.next.next;

            // Add the new node in the copy list
            copy.next = current.next;
            copy = copy.next;

            // Restore the original list
            current.next = next;
            current = next;
        }

        return sentinel.next;
    }

    /**
     * Test driver using the LeetCode format: each node is {@code [val, randomIndex]}, where
     * {@code randomIndex} is the position of the node its random pointer targets, or {@code null}.
     *
     * <p>A copy passes when:
     * <ul>
     *   <li>serialising it gives back the input (same values and random indices);</li>
     *   <li>none of its nodes is an original node, so it is a real deep copy;</li>
     *   <li>the original list is unchanged afterwards (same {@code next} and {@code random}
     *       links), since step 1 temporarily rewires it.</li>
     * </ul>
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        Integer[][][] inputs = {
                {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}},  // Example 1
                {{1, 1}, {2, 1}},                                // Example 2: random pointing to itself
                {{3, null}, {3, 0}, {3, null}},                  // Example 3: equal values
                {{5, null}},                                     // single node, no random
                {{5, 0}},                                        // single node pointing to itself
                {},                                              // empty list
        };

        CopyListWithRandomPointer solver = new CopyListWithRandomPointer();
        for (Integer[][] input : inputs) {
            // build the original list: next links in order, random links by index
            int n = input.length;
            Node[] original = new Node[n];
            for (int i = 0; i < n; i++) {
                original[i] = solver.new Node(input[i][0]);
                if (i > 0) {
                    original[i - 1].next = original[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (input[i][1] != null) {
                    original[i].random = original[input[i][1]];
                }
            }
            Node head = n == 0 ? null : original[0];

            Node copyHead = solver.copyRandomList(head);

            // index every copy node by identity, so random targets can be turned back into indices
            Map<Node, Integer> copyIndex = new IdentityHashMap<>();
            int size = 0;
            for (Node node = copyHead; node != null && size <= n; node = node.next) {
                copyIndex.put(node, size++);
            }

            // serialise the copy and check it shares no nodes with the original
            Integer[][] got = new Integer[size][];
            boolean deepCopy = true;
            int i = 0;
            for (Node node = copyHead; node != null && i < size; node = node.next) {
                got[i++] = new Integer[]{node.val, node.random == null ? null : copyIndex.get(node.random)};
                for (Node orig : original) {
                    deepCopy &= node != orig && node.random != orig;
                }
            }

            // check the original list was restored
            boolean originalIntact = true;
            for (int j = 0; j < n; j++) {
                originalIntact &= original[j].next == (j + 1 < n ? original[j + 1] : null);
                originalIntact &= original[j].random == (input[j][1] == null ? null : original[input[j][1]]);
            }

            boolean ok = Arrays.deepEquals(got, input) && deepCopy && originalIntact;
            System.out.println((ok ? "PASS" : "FAIL") + " - " + Arrays.deepToString(input)
                    + " (got " + Arrays.deepToString(got)
                    + (deepCopy ? "" : ", shares nodes with the original")
                    + (originalIntact ? "" : ", original list modified") + ")");
        }
    }
}
