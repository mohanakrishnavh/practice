package dsa.stack;

import java.util.EmptyStackException;

/**
 * Plain-Java tests for {@link ArrayStack} (the repo has no JUnit dependency).
 *
 * <p>Run with {@code java -ea dsa.stack.ArrayStackTest}. Assertions must be enabled
 * ({@code -ea}); the runner also fails fast on any thrown error.
 */
public class ArrayStackTest {
    /** Number of tests that have run successfully. */
    private static int passed;

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testNewStackIsEmpty();

        testPushIncreasesSize();

        testPushMakesValueTheTop();

        testPeekDoesNotRemove();

        testPopReturnsValuesInLifoOrder();

        testPopDecreasesSize();

        testPopOnEmptyThrows();

        testPeekOnEmptyThrows();

        testIsEmptyAfterPushAndPop();

        testNegativeAndZeroValues();

        testReusableAfterEmptied();

        testConstructorRejectsNonPositiveCapacity();

        testGrowsBeyondInitialCapacity();

        testDefaultCapacityHoldsMoreThan100Elements();

        System.out.println("All " + passed + " tests passed");
    }

    /** A freshly created stack is empty and has size 0. */
    private static void testNewStackIsEmpty() {
        ArrayStack stack = new ArrayStack();
        check(stack.isEmpty(), "new stack should be empty");
        check(stack.size() == 0, "new stack size should be 0");
        pass("testNewStackIsEmpty");
    }

    /** Each push grows the size by one. */
    private static void testPushIncreasesSize() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        check(stack.size() == 1, "size after 1 push");
        stack.push(2);
        check(stack.size() == 2, "size after 2 pushes");
        pass("testPushIncreasesSize");
    }

    /** The most recently pushed value is the one at the top. */
    private static void testPushMakesValueTheTop() {
        ArrayStack stack = new ArrayStack();
        stack.push(10);
        check(stack.peek() == 10, "top should be 10");
        stack.push(20);
        check(stack.peek() == 20, "top should be 20");
        pass("testPushMakesValueTheTop");
    }

    /** Peek returns the top value but leaves the stack unchanged. */
    private static void testPeekDoesNotRemove() {
        ArrayStack stack = new ArrayStack();
        stack.push(7);
        check(stack.peek() == 7, "first peek");
        check(stack.peek() == 7, "second peek");
        check(stack.size() == 1, "peek must not change size");
        pass("testPeekDoesNotRemove");
    }

    /** Values come back out in last-in, first-out order. */
    private static void testPopReturnsValuesInLifoOrder() {
        ArrayStack stack = new ArrayStack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        for (int i = 5; i >= 1; i--) {
            check(stack.pop() == i, "pop should return " + i);
        }
        pass("testPopReturnsValuesInLifoOrder");
    }

    /** Each pop shrinks the size by one. */
    private static void testPopDecreasesSize() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.push(2);
        stack.pop();
        check(stack.size() == 1, "size after 1 pop");
        stack.pop();
        check(stack.size() == 0, "size after 2 pops");
        pass("testPopDecreasesSize");
    }

    /** Popping an empty stack throws EmptyStackException. */
    private static void testPopOnEmptyThrows() {
        ArrayStack stack = new ArrayStack();
        try {
            stack.pop();
            throw new AssertionError("pop on empty stack should throw");
        } catch (EmptyStackException expected) {
            pass("testPopOnEmptyThrows");
        }
    }

    /** Peeking an empty stack throws EmptyStackException. */
    private static void testPeekOnEmptyThrows() {
        ArrayStack stack = new ArrayStack();
        try {
            stack.peek();
            throw new AssertionError("peek on empty stack should throw");
        } catch (EmptyStackException expected) {
            pass("testPeekOnEmptyThrows");
        }
    }

    /** isEmpty flips to false after a push and back to true after the matching pop. */
    private static void testIsEmptyAfterPushAndPop() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        check(!stack.isEmpty(), "should not be empty after push");
        stack.pop();
        check(stack.isEmpty(), "should be empty after popping everything");
        pass("testIsEmptyAfterPushAndPop");
    }

    /** Zero and negative values are stored and returned correctly. */
    private static void testNegativeAndZeroValues() {
        ArrayStack stack = new ArrayStack();
        stack.push(0);
        stack.push(-5);
        check(stack.pop() == -5, "negative value");
        check(stack.pop() == 0, "zero value");
        pass("testNegativeAndZeroValues");
    }

    /** A stack that was emptied can be used again. */
    private static void testReusableAfterEmptied() {
        ArrayStack stack = new ArrayStack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        check(stack.peek() == 2, "top after reuse");
        check(stack.size() == 1, "size after reuse");
        pass("testReusableAfterEmptied");
    }

    /** Zero and negative capacities are rejected. */
    private static void testConstructorRejectsNonPositiveCapacity() {
        for (int capacity : new int[] {0, -1}) {
            try {
                new ArrayStack(capacity);
                throw new AssertionError("capacity " + capacity + " should throw");
            } catch (IllegalArgumentException expected) {
                // expected
            }
        }
        pass("testConstructorRejectsNonPositiveCapacity");
    }

    /** Pushing past a tiny initial capacity triggers resizing without losing data. */
    private static void testGrowsBeyondInitialCapacity() {
        ArrayStack stack = new ArrayStack(1);
        for (int i = 0; i < 50; i++) {
            stack.push(i);
        }
        check(stack.size() == 50, "size after growth");
        for (int i = 49; i >= 0; i--) {
            check(stack.pop() == i, "value after growth " + i);
        }
        pass("testGrowsBeyondInitialCapacity");
    }

    /** The default-capacity stack (100) keeps working past 100 elements. */
    private static void testDefaultCapacityHoldsMoreThan100Elements() {
        ArrayStack stack = new ArrayStack();
        for (int i = 0; i < 250; i++) {
            stack.push(i);
        }
        check(stack.size() == 250, "size after 250 pushes");
        check(stack.peek() == 249, "top after 250 pushes");
        pass("testDefaultCapacityHoldsMoreThan100Elements");
    }

    /**
     * Fails the test run if the condition is false.
     *
     * @param condition the condition that must hold
     * @param message   the failure message
     */
    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    /**
     * Records and prints a passing test.
     *
     * @param name the test name
     */
    private static void pass(String name) {
        passed++;
        System.out.println("PASS " + name);
    }
}
