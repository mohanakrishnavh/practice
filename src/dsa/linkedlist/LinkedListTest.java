package dsa.linkedlist;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Plain-Java tests for {@link LinkedList} (the repo has no JUnit dependency).
 *
 * <p>Run with {@code java dsa.linkedlist.LinkedListTest}. Every test runs even if
 * an earlier one fails; the process exits with status 1 if any test failed.
 */
public class LinkedListTest {
    /** A single test body. */
    private interface TestCase {
        void run() throws Exception;
    }

    /** A call that is expected to throw. */
    private interface Call {
        void run() throws Exception;
    }

    private static int passed;
    private static final List<String> failures = new ArrayList<>();

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        run("newListIsEmpty", LinkedListTest::newListIsEmpty);

        run("getReturnsValueAtEachIndex", LinkedListTest::getReturnsValueAtEachIndex);

        run("getOnEmptyListThrows", LinkedListTest::getOnEmptyListThrows);

        run("getIndexEqualToLengthThrows", LinkedListTest::getIndexEqualToLengthThrows);

        run("getIndexBeyondLengthThrows", LinkedListTest::getIndexBeyondLengthThrows);

        run("getNegativeIndexThrows", LinkedListTest::getNegativeIndexThrows);

        run("addFirstOnEmptyList", LinkedListTest::addFirstOnEmptyList);

        run("addFirstOnNonEmptyList", LinkedListTest::addFirstOnNonEmptyList);

        run("addLastOnEmptyList", LinkedListTest::addLastOnEmptyList);

        run("addLastOnNonEmptyList", LinkedListTest::addLastOnNonEmptyList);

        run("addAtIndexZero", LinkedListTest::addAtIndexZero);

        run("addAtIndexMiddle", LinkedListTest::addAtIndexMiddle);

        run("addAtIndexEqualToLengthAppends", LinkedListTest::addAtIndexEqualToLengthAppends);

        run("addAtIndexZeroOnEmptyList", LinkedListTest::addAtIndexZeroOnEmptyList);

        run("addAtIndexNegativeThrows", LinkedListTest::addAtIndexNegativeThrows);

        run("addAtIndexBeyondLengthThrows", LinkedListTest::addAtIndexBeyondLengthThrows);

        run("removeHead", LinkedListTest::removeHead);

        run("removeMiddle", LinkedListTest::removeMiddle);

        run("removeTail", LinkedListTest::removeTail);

        run("removeOnlyElement", LinkedListTest::removeOnlyElement);

        run("removeNegativeIndexThrows", LinkedListTest::removeNegativeIndexThrows);

        run("removeIndexEqualToLengthThrows", LinkedListTest::removeIndexEqualToLengthThrows);

        run("removeIndexBeyondLengthThrows", LinkedListTest::removeIndexBeyondLengthThrows);

        run("removeFromEmptyListThrows", LinkedListTest::removeFromEmptyListThrows);

        run("removeAllElementsOneByOne", LinkedListTest::removeAllElementsOneByOne);

        run("instanceReverseEmptyList", LinkedListTest::instanceReverseEmptyList);

        run("instanceReverseSingleElement", LinkedListTest::instanceReverseSingleElement);

        run("instanceReverseMultipleElements", LinkedListTest::instanceReverseMultipleElements);

        run("instanceReverseTwiceRestoresOrder", LinkedListTest::instanceReverseTwiceRestoresOrder);

        run("staticReverseNull", LinkedListTest::staticReverseNull);

        run("staticReverseSingleNode", LinkedListTest::staticReverseSingleNode);

        run("staticReverseMultipleNodes", LinkedListTest::staticReverseMultipleNodes);

        run("addAllWithEmptyArray", LinkedListTest::addAllWithEmptyArray);

        run("addAllPreservesOrder", LinkedListTest::addAllPreservesOrder);

        run("addAllPrependsToExistingElements", LinkedListTest::addAllPrependsToExistingElements);

        run("getHeadReturnsFirstNode", LinkedListTest::getHeadReturnsFirstNode);

        run("printInstanceMethod", LinkedListTest::printInstanceMethod);

        run("printInstanceMethodOnEmptyList", LinkedListTest::printInstanceMethodOnEmptyList);

        run("printStaticForward", LinkedListTest::printStaticForward);

        run("printStaticReverse", LinkedListTest::printStaticReverse);

        run("printStaticNull", LinkedListTest::printStaticNull);

        run("mixedOperationsKeepLengthConsistent", LinkedListTest::mixedOperationsKeepLengthConsistent);

        System.out.println();
        System.out.println(passed + " passed, " + failures.size() + " failed");
        if (!failures.isEmpty()) {
            System.exit(1);
        }
    }

    // ---------------------------------------------------------------- get

    /** The list is empty right after construction. */
    private static void newListIsEmpty() {
        LinkedList list = new LinkedList();
        check(list.getHead() == null, "head should be null");
        check(list.length == 0, "length should be 0");
    }

    /** get returns the value at every valid index. */
    private static void getReturnsValueAtEachIndex() {
        LinkedList list = listOf(10, 20, 30);
        check(list.get(0) == 10, "get(0)");
        check(list.get(1) == 20, "get(1)");
        check(list.get(2) == 30, "get(2)");
    }

    /** get on an empty list throws. */
    private static void getOnEmptyListThrows() {
        expectThrows(IndexOutOfBoundsException.class, () -> new LinkedList().get(0));
    }

    /** get(length) is one past the end and must throw. */
    private static void getIndexEqualToLengthThrows() {
        LinkedList list = listOf(1, 2, 3);
        expectThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    /** get far beyond the end must throw. */
    private static void getIndexBeyondLengthThrows() {
        LinkedList list = listOf(1, 2, 3);
        expectThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }

    /** get with a negative index must throw. */
    private static void getNegativeIndexThrows() {
        LinkedList list = listOf(1, 2, 3);
        expectThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    // ---------------------------------------------------------------- addFirst / addLast

    /** addFirst on an empty list makes that value the only element. */
    private static void addFirstOnEmptyList() {
        LinkedList list = new LinkedList();
        list.addFirst(5);
        checkList(list, 5);
    }

    /** addFirst puts the new value in front of existing ones. */
    private static void addFirstOnNonEmptyList() {
        LinkedList list = listOf(2, 3);
        list.addFirst(1);
        checkList(list, 1, 2, 3);
    }

    /** addLast on an empty list behaves like addFirst. */
    private static void addLastOnEmptyList() {
        LinkedList list = new LinkedList();
        list.addLast(5);
        checkList(list, 5);
    }

    /** addLast appends after existing values. */
    private static void addLastOnNonEmptyList() {
        LinkedList list = listOf(1, 2);
        list.addLast(3);
        checkList(list, 1, 2, 3);
    }

    // ---------------------------------------------------------------- addAtIndex

    /** Inserting at index 0 prepends. */
    private static void addAtIndexZero() {
        LinkedList list = listOf(2, 3);
        list.addAtIndex(1, 0);
        checkList(list, 1, 2, 3);
    }

    /** Inserting in the middle shifts later elements right. */
    private static void addAtIndexMiddle() {
        LinkedList list = listOf(1, 3);
        list.addAtIndex(2, 1);
        checkList(list, 1, 2, 3);
    }

    /** Inserting at index == length appends. */
    private static void addAtIndexEqualToLengthAppends() {
        LinkedList list = listOf(1, 2);
        list.addAtIndex(3, 2);
        checkList(list, 1, 2, 3);
    }

    /** Inserting at index 0 of an empty list works. */
    private static void addAtIndexZeroOnEmptyList() {
        LinkedList list = new LinkedList();
        list.addAtIndex(1, 0);
        checkList(list, 1);
    }

    /** Negative index is rejected and the list is unchanged. */
    private static void addAtIndexNegativeThrows() {
        LinkedList list = listOf(1, 2);
        expectThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(9, -1));
        checkList(list, 1, 2);
    }

    /** Index greater than length is rejected and the list is unchanged. */
    private static void addAtIndexBeyondLengthThrows() {
        LinkedList list = listOf(1, 2);
        expectThrows(IndexOutOfBoundsException.class, () -> list.addAtIndex(9, 3));
        checkList(list, 1, 2);
    }

    // ---------------------------------------------------------------- remove

    /** Removing index 0 drops the head. */
    private static void removeHead() {
        LinkedList list = listOf(1, 2, 3);
        list.remove(0);
        checkList(list, 2, 3);
    }

    /** Removing a middle index relinks neighbours. */
    private static void removeMiddle() {
        LinkedList list = listOf(1, 2, 3);
        list.remove(1);
        checkList(list, 1, 3);
    }

    /** Removing the last index drops the tail. */
    private static void removeTail() {
        LinkedList list = listOf(1, 2, 3);
        list.remove(2);
        checkList(list, 1, 2);
    }

    /** Removing the only element leaves an empty list. */
    private static void removeOnlyElement() {
        LinkedList list = listOf(1);
        list.remove(0);
        checkList(list);
        check(list.getHead() == null, "head should be null");
    }

    /** Negative index is rejected and the list is unchanged. */
    private static void removeNegativeIndexThrows() {
        LinkedList list = listOf(1, 2);
        expectThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        checkList(list, 1, 2);
    }

    /** remove(length) is one past the end and must throw. */
    private static void removeIndexEqualToLengthThrows() {
        LinkedList list = listOf(1, 2);
        expectThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
        checkList(list, 1, 2);
    }

    /** remove far beyond the end must throw. */
    private static void removeIndexBeyondLengthThrows() {
        LinkedList list = listOf(1, 2);
        expectThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
        checkList(list, 1, 2);
    }

    /** remove on an empty list must throw. */
    private static void removeFromEmptyListThrows() {
        LinkedList list = new LinkedList();
        expectThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        check(list.length == 0, "length must stay 0");
    }

    /** Repeatedly removing the head empties the list. */
    private static void removeAllElementsOneByOne() {
        LinkedList list = listOf(1, 2, 3);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        checkList(list);
    }

    // ---------------------------------------------------------------- reverse

    /** Reversing an empty list is a no-op. */
    private static void instanceReverseEmptyList() {
        LinkedList list = new LinkedList();
        list.reverse();
        checkList(list);
    }

    /** Reversing a single element is a no-op. */
    private static void instanceReverseSingleElement() {
        LinkedList list = listOf(1);
        list.reverse();
        checkList(list, 1);
    }

    /** Reversing flips the order. */
    private static void instanceReverseMultipleElements() {
        LinkedList list = listOf(1, 2, 3, 4);
        list.reverse();
        checkList(list, 4, 3, 2, 1);
    }

    /** Reversing twice restores the original order. */
    private static void instanceReverseTwiceRestoresOrder() {
        LinkedList list = listOf(1, 2, 3);
        list.reverse();
        list.reverse();
        checkList(list, 1, 2, 3);
    }

    /** Static reverse of null returns null. */
    private static void staticReverseNull() {
        check(LinkedList.reverse(null) == null, "reverse(null) should be null");
    }

    /** Static reverse of one node returns that node. */
    private static void staticReverseSingleNode() {
        ListNode node = new ListNode(1);
        ListNode result = LinkedList.reverse(node);
        check(result == node, "same node expected");
        check(result.next == null, "next should be null");
    }

    /** Static reverse flips a multi-node chain and returns the new head. */
    private static void staticReverseMultipleNodes() {
        LinkedList list = listOf(1, 2, 3);
        ListNode result = LinkedList.reverse(list.getHead());
        check(java.util.Arrays.equals(toArray(result), new int[] {3, 2, 1}), "expected 3 2 1");
    }

    // ---------------------------------------------------------------- addAll

    /** addAll with an empty array changes nothing. */
    private static void addAllWithEmptyArray() {
        LinkedList list = new LinkedList();
        list.addAll(new int[] {});
        checkList(list);
    }

    /** addAll keeps the array's order. */
    private static void addAllPreservesOrder() {
        LinkedList list = new LinkedList();
        list.addAll(new int[] {1, 2, 3});
        checkList(list, 1, 2, 3);
    }

    /** addAll places the new values in front of existing ones. */
    private static void addAllPrependsToExistingElements() {
        LinkedList list = listOf(4, 5);
        list.addAll(new int[] {1, 2, 3});
        checkList(list, 1, 2, 3, 4, 5);
    }

    /** getHead returns the first node. */
    private static void getHeadReturnsFirstNode() {
        LinkedList list = listOf(7, 8);
        check(list.getHead() != null && list.getHead().val == 7, "head should be 7");
    }

    // ---------------------------------------------------------------- print

    /** print() writes values space separated then a newline. */
    private static void printInstanceMethod() {
        LinkedList list = listOf(1, 2, 3);
        check(capture(list::print).equals("1 2 3 \n"), "output mismatch");
    }

    /** print() on an empty list writes only a newline. */
    private static void printInstanceMethodOnEmptyList() {
        check(capture(() -> new LinkedList().print()).equals("\n"), "output mismatch");
    }

    /** print(node) writes values forward. */
    private static void printStaticForward() {
        LinkedList list = listOf(1, 2, 3);
        check(capture(() -> LinkedList.print(list.getHead())).equals("1 2 3 \n"), "output mismatch");
    }

    /** print(node, true) writes values backward (note: the newline is emitted first). */
    private static void printStaticReverse() {
        LinkedList list = listOf(1, 2, 3);
        // The recursion bottoms out (printing the newline) before any value is printed.
        check(capture(() -> LinkedList.print(list.getHead(), true)).equals("\n3 2 1 "), "output mismatch");
    }

    /** print(null) writes only a newline. */
    private static void printStaticNull() {
        check(capture(() -> LinkedList.print(null)).equals("\n"), "output mismatch");
    }

    // ---------------------------------------------------------------- integration

    /** length tracks every add and remove. */
    private static void mixedOperationsKeepLengthConsistent() {
        LinkedList list = new LinkedList();
        list.addFirst(2);
        list.addLast(3);
        list.addAtIndex(1, 0);
        list.addAll(new int[] {0});
        check(list.length == 4, "length after adds");
        list.remove(0);
        list.remove(2);
        check(list.length == 2, "length after removes");
        checkList(list, 1, 2);
    }

    // ---------------------------------------------------------------- helpers

    /**
     * Builds a list containing the given values in order.
     *
     * @param values the values
     * @return a new list
     */
    private static LinkedList listOf(int... values) {
        LinkedList list = new LinkedList();
        for (int v : values) {
            list.addLast(v);
        }
        return list;
    }

    /**
     * Copies a node chain into an array.
     *
     * @param head first node
     * @return the values in order
     */
    private static int[] toArray(ListNode head) {
        List<Integer> out = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            out.add(n.val);
        }
        int[] arr = new int[out.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = out.get(i);
        }
        return arr;
    }

    /**
     * Asserts the list holds exactly the expected values and its length matches.
     *
     * @param list     the list under test
     * @param expected the expected values in order
     */
    private static void checkList(LinkedList list, int... expected) {
        int[] actual = toArray(list.getHead());
        check(java.util.Arrays.equals(actual, expected),
                "expected " + java.util.Arrays.toString(expected) + " but was " + java.util.Arrays.toString(actual));
        check(list.length == expected.length,
                "length expected " + expected.length + " but was " + list.length);
    }

    /**
     * Captures what an action prints to System.out, normalising line endings.
     *
     * @param action the action
     * @return captured output
     */
    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString().replace("\r\n", "\n");
    }

    /**
     * Asserts that a call throws the given exception type.
     *
     * @param type the expected exception type
     * @param call the call
     */
    private static void expectThrows(Class<? extends Throwable> type, Call call) {
        try {
            call.run();
        } catch (Throwable t) {
            if (type.isInstance(t)) {
                return;
            }
            throw new AssertionError("expected " + type.getSimpleName() + " but got " + t);
        }
        throw new AssertionError("expected " + type.getSimpleName() + " but nothing was thrown");
    }

    /**
     * Fails the current test if the condition is false.
     *
     * @param condition must be true
     * @param message   failure message
     */
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Runs one test, recording and printing PASS or FAIL.
     *
     * @param name the test name
     * @param test the test body
     */
    private static void run(String name, TestCase test) {
        try {
            test.run();
            passed++;
            System.out.println("PASS " + name);
        } catch (Throwable t) {
            failures.add(name);
            System.out.println("FAIL " + name + " -> " + t);
        }
    }
}
