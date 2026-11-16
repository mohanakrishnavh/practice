package dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain-Java tests for {@link DoublyLinkedList} (the repo has no JUnit dependency).
 *
 * <p>The list exposes no size accessor or traversal API, so structure
 * (values, {@code prev}/{@code next} links, {@code length}) is checked reflectively,
 * while {@code get(index)} (which returns -1 for an invalid index) is tested directly.
 * Index 0 is the head of the list.
 *
 * <p>Run with {@code java dsa.linkedlist.DoublyLinkedListTest}. Every test runs
 * even if an earlier one fails; the process exits with status 1 if any failed.
 */
public class DoublyLinkedListTest {
    /** A single test body. */
    private interface TestCase {
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
        run("getOnEmptyListReturnsMinusOne", DoublyLinkedListTest::getOnEmptyListReturnsMinusOne);

        run("getNegativeIndexReturnsMinusOne", DoublyLinkedListTest::getNegativeIndexReturnsMinusOne);

        run("getIndexEqualToLengthReturnsMinusOne", DoublyLinkedListTest::getIndexEqualToLengthReturnsMinusOne);

        run("getIndexBeyondLengthReturnsMinusOne", DoublyLinkedListTest::getIndexBeyondLengthReturnsMinusOne);

        run("addFirstOnEmptyList", DoublyLinkedListTest::addFirstOnEmptyList);

        run("addFirstPutsValueAtIndexZero", DoublyLinkedListTest::addFirstPutsValueAtIndexZero);

        run("addFirstMultipleTimes", DoublyLinkedListTest::addFirstMultipleTimes);

        run("addLastOnEmptyList", DoublyLinkedListTest::addLastOnEmptyList);

        run("addLastAppendsInOrder", DoublyLinkedListTest::addLastAppendsInOrder);

        run("addFirstThenAddLast", DoublyLinkedListTest::addFirstThenAddLast);

        run("addAtIndexZeroOnEmptyList", DoublyLinkedListTest::addAtIndexZeroOnEmptyList);

        run("addAtIndexZeroPrepends", DoublyLinkedListTest::addAtIndexZeroPrepends);

        run("addAtIndexMiddle", DoublyLinkedListTest::addAtIndexMiddle);

        run("addAtIndexEqualToLengthAppends", DoublyLinkedListTest::addAtIndexEqualToLengthAppends);

        run("addAtIndexNegativeIsIgnored", DoublyLinkedListTest::addAtIndexNegativeIsIgnored);

        run("addAtIndexBeyondLengthIsIgnored", DoublyLinkedListTest::addAtIndexBeyondLengthIsIgnored);

        run("deleteAtIndexOnEmptyListIsIgnored", DoublyLinkedListTest::deleteAtIndexOnEmptyListIsIgnored);

        run("deleteAtIndexNegativeIsIgnored", DoublyLinkedListTest::deleteAtIndexNegativeIsIgnored);

        run("deleteAtIndexEqualToLengthIsIgnored", DoublyLinkedListTest::deleteAtIndexEqualToLengthIsIgnored);

        run("deleteHead", DoublyLinkedListTest::deleteHead);

        run("deleteMiddle", DoublyLinkedListTest::deleteMiddle);

        run("deleteTail", DoublyLinkedListTest::deleteTail);

        run("deleteOnlyElement", DoublyLinkedListTest::deleteOnlyElement);

        run("deleteThenAddKeepsListConsistent", DoublyLinkedListTest::deleteThenAddKeepsListConsistent);

        System.out.println();
        System.out.println(passed + " passed, " + failures.size() + " failed");
        if (!failures.isEmpty()) {
            System.exit(1);
        }
    }

    // ---------------------------------------------------------------- get

    /** get on an empty list returns -1. */
    private static void getOnEmptyListReturnsMinusOne() {
        check(new DoublyLinkedList().get(0) == -1, "get(0) on empty list");
    }

    /** get with a negative index returns -1. */
    private static void getNegativeIndexReturnsMinusOne() {
        check(listOf(1, 2).get(-1) == -1, "get(-1)");
    }

    /** get(length) is one past the end and returns -1. */
    private static void getIndexEqualToLengthReturnsMinusOne() {
        check(listOf(1, 2).get(2) == -1, "get(length)");
    }

    /** get far beyond the end returns -1. */
    private static void getIndexBeyondLengthReturnsMinusOne() {
        check(listOf(1, 2).get(10) == -1, "get(10)");
    }

    // ---------------------------------------------------------------- addFirst / addLast

    /** addFirst on an empty list makes it the only element. */
    private static void addFirstOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(5);
        checkList(list, 5);
    }

    /** addFirst places the new value at index 0, ahead of existing ones. */
    private static void addFirstPutsValueAtIndexZero() {
        DoublyLinkedList list = listOf(2);
        list.addFirst(1);
        checkList(list, 1, 2);
    }

    /** Repeated addFirst produces reverse insertion order. */
    private static void addFirstMultipleTimes() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        checkList(list, 3, 2, 1);
    }

    /** addLast on an empty list makes it the only element. */
    private static void addLastOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(5);
        checkList(list, 5);
    }

    /** addLast appends in insertion order. */
    private static void addLastAppendsInOrder() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        checkList(list, 1, 2, 3);
    }

    /** addFirst and addLast can be combined. */
    private static void addFirstThenAddLast() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        checkList(list, 1, 2, 3);
    }

    // ---------------------------------------------------------------- addAtIndex

    /** Inserting at index 0 of an empty list works. */
    private static void addAtIndexZeroOnEmptyList() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addAtIndex(1, 0);
        checkList(list, 1);
    }

    /** Inserting at index 0 prepends. */
    private static void addAtIndexZeroPrepends() {
        DoublyLinkedList list = listOf(2, 3);
        list.addAtIndex(1, 0);
        checkList(list, 1, 2, 3);
    }

    /** Inserting in the middle shifts later elements right. */
    private static void addAtIndexMiddle() {
        DoublyLinkedList list = listOf(1, 3);
        list.addAtIndex(2, 1);
        checkList(list, 1, 2, 3);
    }

    /** Inserting at index == length appends exactly once. */
    private static void addAtIndexEqualToLengthAppends() {
        DoublyLinkedList list = listOf(1, 2);
        list.addAtIndex(3, 2);
        checkList(list, 1, 2, 3);
    }

    /** A negative index is ignored. */
    private static void addAtIndexNegativeIsIgnored() {
        DoublyLinkedList list = listOf(1, 2);
        list.addAtIndex(9, -1);
        checkList(list, 1, 2);
    }

    /** An index greater than length is ignored. */
    private static void addAtIndexBeyondLengthIsIgnored() {
        DoublyLinkedList list = listOf(1, 2);
        list.addAtIndex(9, 3);
        checkList(list, 1, 2);
    }

    // ---------------------------------------------------------------- deleteAtIndex

    /** Deleting from an empty list is a no-op. */
    private static void deleteAtIndexOnEmptyListIsIgnored() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.deleteAtIndex(0);
        checkList(list);
    }

    /** A negative index is ignored. */
    private static void deleteAtIndexNegativeIsIgnored() {
        DoublyLinkedList list = listOf(1, 2);
        list.deleteAtIndex(-1);
        checkList(list, 1, 2);
    }

    /** Index == length is out of range and ignored. */
    private static void deleteAtIndexEqualToLengthIsIgnored() {
        DoublyLinkedList list = listOf(1, 2);
        list.deleteAtIndex(2);
        checkList(list, 1, 2);
    }

    /** Deleting index 0 removes the head. */
    private static void deleteHead() {
        DoublyLinkedList list = listOf(1, 2, 3);
        list.deleteAtIndex(0);
        checkList(list, 2, 3);
    }

    /** Deleting a middle index relinks neighbours. */
    private static void deleteMiddle() {
        DoublyLinkedList list = listOf(1, 2, 3);
        list.deleteAtIndex(1);
        checkList(list, 1, 3);
    }

    /** Deleting the last index removes the tail. */
    private static void deleteTail() {
        DoublyLinkedList list = listOf(1, 2, 3);
        list.deleteAtIndex(2);
        checkList(list, 1, 2);
    }

    /** Deleting the only element empties the list. */
    private static void deleteOnlyElement() {
        DoublyLinkedList list = listOf(1);
        list.deleteAtIndex(0);
        checkList(list);
    }

    /** The list stays usable after a delete. */
    private static void deleteThenAddKeepsListConsistent() {
        DoublyLinkedList list = listOf(1, 2, 3);
        list.deleteAtIndex(1);
        list.addLast(4);
        list.addAtIndex(9, 1);
        checkList(list, 1, 9, 3, 4);
    }

    // ---------------------------------------------------------------- helpers

    /**
     * Builds a list with the given values using addLast.
     *
     * @param values the values in order
     * @return a new list
     */
    private static DoublyLinkedList listOf(int... values) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int v : values) {
            list.addLast(v);
        }
        return list;
    }

    /**
     * Asserts the exact structure of the list: forward values from the head match
     * {@code expected}, every {@code prev} pointer mirrors the {@code next} pointer,
     * the head has no {@code prev}, and the {@code length} field matches.
     *
     * <p>Private fields are read reflectively so that a defect in {@code get()} cannot
     * hide (or fake) a structural problem.
     *
     * @param list     the list under test
     * @param expected the expected values in order
     */
    private static void checkList(DoublyLinkedList list, int... expected) {
        try {
            java.lang.reflect.Field headField = DoublyLinkedList.class.getDeclaredField("head");
            headField.setAccessible(true);
            java.lang.reflect.Field lengthField = DoublyLinkedList.class.getDeclaredField("length");
            lengthField.setAccessible(true);

            DoublyLinkedList.DoublyLinkedListNode node =
                    (DoublyLinkedList.DoublyLinkedListNode) headField.get(list);
            check(expected.length == 0 ? node == null : node != null && node.prev == null,
                    "head should be null for an empty list, otherwise have no prev");

            DoublyLinkedList.DoublyLinkedListNode previous = null;
            int count = 0;
            while (node != null && count <= expected.length) {
                check(count < expected.length, "more elements than expected " + expected.length);
                check(node.val == expected[count],
                        "index " + count + " expected " + expected[count] + " but was " + node.val);
                check(node.prev == previous, "prev pointer broken at index " + count);
                previous = node;
                node = node.next;
                count++;
            }
            check(count == expected.length, "expected " + expected.length + " elements but found " + count);
            check(lengthField.getInt(list) == expected.length,
                    "length field expected " + expected.length + " but was " + lengthField.getInt(list));
        } catch (ReflectiveOperationException e) {
            throw new AssertionError("reflection failed: " + e);
        }
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
