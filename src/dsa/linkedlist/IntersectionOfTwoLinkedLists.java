package dsa.linkedlist;

import java.util.Arrays;

/**
 * IntersectionOfTwoLinkedLists
 *
 * <p>Given the heads of two singly linked lists, return the node at which they intersect, or
 * {@code null} if they don't. Intersecting means sharing the same node <i>object</i>, not just an
 * equal value. From that node on, the two lists are one shared tail.
 *
 * <p><b>Idea:</b> if the lists intersect, they must end at the same tail node, so comparing the
 * tails tells whether there is an intersection at all. The parts before the shared tail can have
 * different lengths, so first advance the longer list by the difference in lengths. Both
 * pointers are then the same distance from the end. Step them together, and the first node where
 * they meet is the intersection.
 *
 * <p>Time complexity: O(m + n). Space complexity: O(1).
 *
 * <p>Example: A = [4, 1, 8, 4, 5] and B = [5, 6, 1, 8, 4, 5], sharing the tail starting at 8.
 * A has length 5 and B has length 6, so B moves one node ahead (to 6). Stepping together gives
 * 4/6, 1/1, 8/8, and they meet at the node with value 8. The two nodes with value 1 are different
 * objects, so they don't count.
 *
 * @see ListNode
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Finds the intersection node of two linked lists.
     *
     * <p>Steps:
     * <ol>
     *   <li>If either list is empty, there is no intersection.</li>
     *   <li>Find each list's tail and length with {@link #getTail(ListNode, int[])}.</li>
     *   <li>If the tails are different nodes, the lists don't intersect: return {@code null}.</li>
     *   <li>Point {@code currentA} at the longer list and {@code currentB} at the shorter one, then
     *       advance {@code currentA} by the difference in lengths.</li>
     *   <li>Step both pointers together until they are the same node. Because the tails match,
     *       this always stops, at the latest at the shared tail.</li>
     * </ol>
     * Nodes are compared by reference ({@code !=}), not by value.
     *
     * <p>Time Complexity: O(m + n) where m and n are the lengths of the two lists
     * <p>Space Complexity: O(1)
     *
     * @param headA the head of the first linked list; may be {@code null}
     * @param headB the head of the second linked list; may be {@code null}
     * @return the first node shared by both lists, or {@code null} if they don't intersect
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currentA = headA, currentB = headB;
        int[] length = new int[]{1};

        ListNode tailA = getTail(currentA, length);
        int lengthA = length[0];

        length[0] = 1;
        ListNode tailB = getTail(currentB, length);
        int lengthB = length[0];

        // To confirm there is an intersection point
        if (tailA != tailB) {
            return null;
        }

        // Calculate the delta in length
        if (lengthA > lengthB) {
            currentA = headA;
            currentB = headB;
        } else {
            currentA = headB;
            currentB = headA;
        }

        int delta = Math.abs(lengthA - lengthB);
        for (int i = 0; i < delta; i++) {
            currentA = currentA.next;
        }

        while(currentA != currentB) {
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return currentA;
    }

    /**
     * Walks to the last node of a list while counting its nodes.
     *
     * <p>The count is returned through {@code length[0]}, because the method already returns the
     * tail. The caller sets {@code length[0] = 1} first to count the head, and each step forward
     * adds one.
     *
     * @param head   the head of a non-empty list
     * @param length one-element array holding 1 on entry; holds the list's length on return
     * @return the last node of the list
     */
    private ListNode getTail(ListNode head, int[] length) {
        ListNode current = head;
        while(current.next != null) {
            length[0]++;
            current = current.next;
        }

        return current;
    }

    /**
     * Test driver. Each case is a unique prefix for A, a unique prefix for B and a shared tail.
     * The shared nodes are created once and linked after both prefixes, so the lists really share
     * those node objects. The expected answer is the first shared node, or {@code null} if the
     * shared part is empty.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] prefixA = {
                {4, 1},     // Example 1: intersect at 8, skipA = 2, skipB = 3
                {1, 9, 1},  // Example 2: intersect at 2, skipA = 3, skipB = 1
                {2, 6, 4},  // Example 3: no intersection
                {},         // both lists are the same list: intersect at the head
                {1, 2},     // B is just the last node of A
                {},         // A is empty: no intersection
        };
        int[][] prefixB = {
                {5, 6, 1},
                {3},
                {1, 5},
                {},
                {},
                {1, 5},
        };
        int[][] shared = {
                {8, 4, 5},
                {2, 4},
                {},
                {1, 2, 3},
                {3},
                {},
        };

        IntersectionOfTwoLinkedLists solver = new IntersectionOfTwoLinkedLists();
        for (int t = 0; t < shared.length; t++) {
            // build the shared tail once, so both lists point at the same nodes
            ListNode sharedDummy = new ListNode();
            ListNode tail = sharedDummy;
            for (int val : shared[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            ListNode sharedHead = sharedDummy.next;

            // list A: its own prefix nodes, then the shared tail
            ListNode dummyA = new ListNode();
            tail = dummyA;
            for (int val : prefixA[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            tail.next = sharedHead;

            // list B: its own prefix nodes, then the same shared tail
            ListNode dummyB = new ListNode();
            tail = dummyB;
            for (int val : prefixB[t]) {
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            tail.next = sharedHead;

            ListNode result = solver.getIntersectionNode(dummyA.next, dummyB.next);
            String expected = sharedHead == null ? "No intersection" : "Intersected at '" + sharedHead.val + "'";
            String got = result == null ? "No intersection" : "Intersected at '" + result.val + "'";
            System.out.println((result == sharedHead ? "PASS" : "FAIL") + " - A prefix " + Arrays.toString(prefixA[t])
                    + ", B prefix " + Arrays.toString(prefixB[t]) + ", shared " + Arrays.toString(shared[t])
                    + " (expected " + expected + ", got " + got + ")");
        }
    }
}
