package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain-Java tests for {@link LinkedListCycleII} (the repo has no JUnit dependency).
 *
 * <p>Both {@code detectCycle} (Floyd's, static) and {@code detectCycle2} (cycle length + gap, instance)
 * are run against every scenario, so they are checked against each other as well as the expected node.
 *
 * <p>Run with {@code java dsa.linkedlist.LinkedListCycleIITest}. Every test runs even if
 * an earlier one fails; the process exits with status 1 if any test failed.
 */
public class LinkedListCycleIITest {
    private static int passed;
    private static final List<String> failures = new ArrayList<>();
    private static final LinkedListCycleII solver = new LinkedListCycleII();

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        // No cycle
        check("emptyList", null, null);

        ListNode single = new ListNode(1);
        check("singleNodeNoCycle", single, null);

        ListNode[] straight = chain(1, 2, 3, 4, 5);
        check("longListNoCycle", straight[0], null);

        // Cycle
        ListNode selfLoop = new ListNode(1);
        selfLoop.next = selfLoop;
        check("singleNodeSelfLoop", selfLoop, selfLoop);

        ListNode[] twoNodes = chain(1, 2);
        twoNodes[1].next = twoNodes[0];
        check("twoNodeCycleAtHead", twoNodes[0], twoNodes[0]);

        ListNode[] leetCode = chain(3, 2, 0, -4);
        leetCode[3].next = leetCode[1];
        check("cycleStartsAtSecondNode", leetCode[0], leetCode[1]);

        ListNode[] wholeList = chain(1, 2, 3, 4);
        wholeList[3].next = wholeList[0];
        check("cycleIncludesWholeList", wholeList[0], wholeList[0]);

        ListNode[] tailLoop = chain(1, 2, 3, 4, 5, 6);
        tailLoop[5].next = tailLoop[5];
        check("tailNodePointsToItself", tailLoop[0], tailLoop[5]);

        ListNode[] longTail = chain(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        longTail[9].next = longTail[6];
        check("longTailShortCycle", longTail[0], longTail[6]);

        ListNode[] shortTail = chain(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        shortTail[9].next = shortTail[1];
        check("shortTailLongCycle", shortTail[0], shortTail[1]);

        // Duplicate values: the result must be the right NODE, not just a matching value
        ListNode[] duplicates = chain(5, 5, 5, 5);
        duplicates[3].next = duplicates[2];
        check("duplicateValuesReturnCorrectNode", duplicates[0], duplicates[2]);

        System.out.println(passed + " passed, " + failures.size() + " failed");
        for (String failure : failures) {
            System.out.println("FAIL: " + failure);
        }

        if (!failures.isEmpty()) {
            System.exit(1);
        }
    }

    /**
     * Runs both cycle-detection methods on the same list and compares each result with the expected node.
     * Nodes are compared by identity, because the problem asks for the node itself.
     *
     * @param name     the test name used in the report
     * @param head     the head of the list under test
     * @param expected the node where the cycle should begin, or {@code null} for no cycle
     */
    private static void check(String name, ListNode head, ListNode expected) {
        verify(name + " [detectCycle]", LinkedListCycleII.detectCycle(head), expected);
        verify(name + " [detectCycle2]", solver.detectCycle2(head), expected);
    }

    /**
     * Records a pass or failure for one result.
     *
     * @param label    the name shown in the report
     * @param actual   the node returned by the method under test
     * @param expected the node that should have been returned
     */
    private static void verify(String label, ListNode actual, ListNode expected) {
        if (actual == expected) {
            passed++;
        } else {
            failures.add(label + ": expected " + describe(expected) + " but got " + describe(actual));
        }
    }

    /**
     * Describes a node for failure messages.
     *
     * @param node the node, possibly {@code null}
     * @return {@code "null"} or {@code "node(val)"}
     */
    private static String describe(ListNode node) {
        return node == null ? "null" : "node(" + node.val + ")";
    }

    /**
     * Builds a singly linked chain and returns every node so tests can wire up a cycle afterwards.
     *
     * @param values the node values in order (at least one)
     * @return the nodes, where index 0 is the head
     */
    private static ListNode[] chain(int... values) {
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        return nodes;
    }
}
