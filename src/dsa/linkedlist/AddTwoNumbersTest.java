package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain-Java tests for {@link AddTwoNumbers} (the repo has no JUnit dependency).
 *
 * <p>Run with {@code java dsa.linkedlist.AddTwoNumbersTest}. Every test runs even if
 * an earlier one fails; the process exits with status 1 if any test failed.
 */
public class AddTwoNumbersTest {
    private static int passed;
    private static final List<String> failures = new ArrayList<>();
    private static final AddTwoNumbers solver = new AddTwoNumbers();

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        check("sameLengthNoCarryOverflow", new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8});
        check("singleDigitsNoCarry", new int[]{1}, new int[]{2}, new int[]{3});
        check("zeroPlusZero", new int[]{0}, new int[]{0}, new int[]{0});
        check("carryCreatesExtraDigit", new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        check("firstListLonger", new int[]{1, 2, 3, 4}, new int[]{9, 9}, new int[]{0, 2, 4, 4});
        check("secondListLonger", new int[]{9, 9}, new int[]{1, 2, 3, 4}, new int[]{0, 2, 4, 4});
        check("carryPropagatesThroughLongerTail", new int[]{1}, new int[]{9, 9, 9}, new int[]{0, 0, 0, 1});
        check("singleDigitsProduceCarry", new int[]{5}, new int[]{5}, new int[]{0, 1});
        check("nullFirstReturnsSecond", null, new int[]{1, 2}, new int[]{1, 2});
        check("nullSecondReturnsFirst", new int[]{1, 2}, null, new int[]{1, 2});
        check("bothNullReturnsNull", null, null, null);

        System.out.println(passed + " passed, " + failures.size() + " failed");
        for (String failure : failures) {
            System.out.println("FAIL: " + failure);
        }

        if (!failures.isEmpty()) {
            System.exit(1);
        }
    }

    /**
     * Builds both lists, adds them and compares the result with the expected digits.
     *
     * @param name     the test name used in the report
     * @param a        digits of the first number, least significant first ({@code null} for an empty list)
     * @param b        digits of the second number, least significant first ({@code null} for an empty list)
     * @param expected expected digits of the sum, least significant first ({@code null} for an empty list)
     */
    private static void check(String name, int[] a, int[] b, int[] expected) {
        List<Integer> actual = toList(solver.addTwoNumbers(build(a), build(b)));
        List<Integer> want = toList(build(expected));
        if (actual.equals(want)) {
            passed++;
        } else {
            failures.add(name + ": expected " + want + " but got " + actual);
        }
    }

    /**
     * Builds a linked list from digits.
     *
     * @param digits the node values in order, or {@code null} for an empty list
     * @return the head of the new list, or {@code null} if {@code digits} is null or empty
     */
    private static ListNode build(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }

        ListNode head = new ListNode(digits[0]);
        ListNode current = head;
        for (int i = 1; i < digits.length; i++) {
            current.next = new ListNode(digits[i]);
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
