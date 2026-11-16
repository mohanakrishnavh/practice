package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain-Java tests for {@link PalindromeLinkedList} (the repo has no JUnit dependency).
 *
 * <p>Run with {@code java dsa.linkedlist.PalindromeLinkedListTest}. Every test runs even if
 * an earlier one fails; the process exits with status 1 if any test failed.
 */
public class PalindromeLinkedListTest {
    private static int passed;
    private static final List<String> failures = new ArrayList<>();
    private static final PalindromeLinkedList solver = new PalindromeLinkedList();

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        checkPalindrome("emptyListIsPalindrome", null, true);
        checkPalindrome("singleNodeIsPalindrome", new int[]{7}, true);
        checkPalindrome("evenLengthPalindrome", new int[]{1, 2, 2, 1}, true);
        checkPalindrome("oddLengthPalindrome", new int[]{1, 2, 3, 2, 1}, true);
        checkPalindrome("twoEqualNodes", new int[]{4, 4}, true);
        checkPalindrome("twoDifferentNodes", new int[]{1, 2}, false);
        checkPalindrome("notPalindromeEvenLength", new int[]{1, 2, 3, 4}, false);
        checkPalindrome("notPalindromeOddLength", new int[]{1, 2, 3}, false);
        checkPalindrome("differsOnlyInMiddleOfHalves", new int[]{1, 2, 3, 4, 2, 1}, false);
        checkPalindrome("allSameValues", new int[]{5, 5, 5, 5, 5}, true);
        checkPalindrome("negativeValues", new int[]{-1, 0, -1}, true);

        checkReverse("reverseNullIsNull", null, new int[]{});
        checkReverse("reverseSingleNode", new int[]{1}, new int[]{1});
        checkReverse("reverseManyNodes", new int[]{1, 2, 3, 4}, new int[]{4, 3, 2, 1});

        System.out.println(passed + " passed, " + failures.size() + " failed");
        for (String failure : failures) {
            System.out.println("FAIL: " + failure);
        }

        if (!failures.isEmpty()) {
            System.exit(1);
        }
    }

    /**
     * Builds a list and checks the result of {@code isPalindrome}.
     *
     * @param name     the test name used in the report
     * @param values   the node values in order, or {@code null} for an empty list
     * @param expected the expected result
     */
    private static void checkPalindrome(String name, int[] values, boolean expected) {
        boolean actual = solver.isPalindrome(build(values));
        if (actual == expected) {
            passed++;
        } else {
            failures.add(name + ": expected " + expected + " but got " + actual);
        }
    }

    /**
     * Builds a list, reverses it and compares the values with the expected order.
     *
     * @param name     the test name used in the report
     * @param values   the node values in order, or {@code null} for an empty list
     * @param expected the expected values after reversing
     */
    private static void checkReverse(String name, int[] values, int[] expected) {
        List<Integer> actual = toList(solver.reverse(build(values)));
        List<Integer> want = toList(build(expected));
        if (actual.equals(want)) {
            passed++;
        } else {
            failures.add(name + ": expected " + want + " but got " + actual);
        }
    }

    /**
     * Builds a linked list from values.
     *
     * @param values the node values in order, or {@code null} for an empty list
     * @return the head of the new list, or {@code null} if {@code values} is null or empty
     */
    private static ListNode build(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    /**
     * Copies a linked list's values into a {@link List} for easy comparison.
     *
     * @param head the head of the list, possibly {@code null}
     * @return the node values in order (empty for a null list)
     */
    private static List<Integer> toList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            values.add(node.val);
        }

        return values;
    }
}
