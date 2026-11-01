package dsa.stack;

import java.util.EmptyStackException;

/**
 * Plain-Java tests for {@link LinkedListStack} (the repo has no JUnit dependency).
 *
 * <p>Run with {@code java -ea dsa.stack.LinkedListStackTest}. Assertions must be enabled
 * ({@code -ea}); the runner also fails fast on any thrown error.
 */
public class LinkedListStackTest {
    /** Number of tests that have run successfully. */
    private static int passed;

    /**
     * Runs every test and prints a summary.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        testNewStackIsEmpty();

        testPushMakesValueTheTop();

        testPeekDoesNotRemove();

        testPopReturnsValuesInLifoOrder();

        testPopOnEmptyThrows();

        testPeekOnEmptyThrows();

        testIsEmptyAfterPushAndPop();

        testNegativeAndZeroValues();

        testReusableAfterEmptied();

        testLargeNumberOfElements();

        System.out.println("All " + passed + " tests passed");
    }

    /** A freshly created stack is empty. */
    private static void testNewStackIsEmpty() {
        LinkedListStack stack = new LinkedListStack();
        check(stack.isEmpty(), "new stack should be empty");
        pass("testNewStackIsEmpty");
    }

    /** The most recently pushed value is the one at the top. */
    private static void testPushMakesValueTheTop() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        check(stack.peek() == 10, "top should be 10");
        stack.push(20);
        check(stack.peek() == 20, "top should be 20");
        pass("testPushMakesValueTheTop");
    }

    /** Peek returns the top value but leaves it on the stack. */
    private static void testPeekDoesNotRemove() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(7);
        check(stack.peek() == 7, "first peek");
        check(stack.peek() == 7, "second peek");
        check(!stack.isEmpty(), "peek must not remove the element");
        pass("testPeekDoesNotRemove");
    }

    /** Values come back out in last-in, first-out order. */
    private static void testPopReturnsValuesInLifoOrder() {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        for (int i = 5; i >= 1; i--) {
            check(stack.pop() == i, "pop should return " + i);
        }
        pass("testPopReturnsValuesInLifoOrder");
    }

    /** Popping an empty stack throws EmptyStackException. */
    private static void testPopOnEmptyThrows() {
        LinkedListStack stack = new LinkedListStack();
        try {
            stack.pop();
            throw new AssertionError("pop on empty stack should throw");
        } catch (EmptyStackException expected) {
            pass("testPopOnEmptyThrows");
        }
    }

    /** Peeking an empty stack throws EmptyStackException. */
    private static void testPeekOnEmptyThrows() {
        LinkedListStack stack = new LinkedListStack();
        try {
            stack.peek();
            throw new AssertionError("peek on empty stack should throw");
        } catch (EmptyStackException expected) {
            pass("testPeekOnEmptyThrows");
        }
    }

    /** isEmpty flips to false after a push and back to true after the matching pop. */
    private static void testIsEmptyAfterPushAndPop() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        check(!stack.isEmpty(), "should not be empty after push");
        stack.pop();
        check(stack.isEmpty(), "should be empty after popping everything");
        pass("testIsEmptyAfterPushAndPop");
    }

    /** Zero and negative values are stored and returned correctly. */
    private static void testNegativeAndZeroValues() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(0);
        stack.push(-5);
        check(stack.pop() == -5, "negative value");
        check(stack.pop() == 0, "zero value");
        pass("testNegativeAndZeroValues");
    }

    /** A stack that was emptied can be used again. */
    private static void testReusableAfterEmptied() {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.pop();
        stack.push(2);
        check(stack.peek() == 2, "top after reuse");
        pass("testReusableAfterEmptied");
    }

    /** A large number of elements can be pushed and popped in order. */
    private static void testLargeNumberOfElements() {
        LinkedListStack stack = new LinkedListStack();
        for (int i = 0; i < 10000; i++) {
            stack.push(i);
        }
        for (int i = 9999; i >= 0; i--) {
            check(stack.pop() == i, "value " + i);
        }
        check(stack.isEmpty(), "empty after popping all");
        pass("testLargeNumberOfElements");
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
