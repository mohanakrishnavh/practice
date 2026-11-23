package dsa.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * MinStackWithoutExtraSpace
 * 
 * A stack that supports push, pop, top and getMin in O(1) time using O(1) extra space (no
 * auxiliary min stack).
 *
 * <p>A single variable tracks the current minimum. When a value smaller than the minimum is pushed,
 * the encoded value {@code 2*x - min} (which is always smaller than the new minimum) is stored instead
 * and the minimum becomes {@code x}. Popping an encoded value (one smaller than the minimum) restores
 * the previous minimum as {@code 2*min - encoded}.
 *
 * <p>Complexity: all operations O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MinStackWithoutExtraSpace {

    private final Stack<Integer> stack;
    private int minimumElement;

    /**
     * Creates an empty stack.
     */
    public MinStackWithoutExtraSpace() {
        stack = new Stack<>();
        minimumElement = -1;
    }

    /**
     * Pushes a value, encoding it if it is a new minimum.
     *
     * @param x the value to push
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minimumElement = x;
            return;
        }

        if (x >= minimumElement) {
            stack.push(x);
        } else {
            stack.push(2 * x - minimumElement);
            minimumElement = x;
        }
    }

    /**
     * Removes the top element, restoring the previous minimum if the top was encoded.
     *
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public void pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stack.peek() < minimumElement) {
            minimumElement = 2 * minimumElement - stack.peek();
        }

        stack.pop();
    }

    /**
     * Returns the top element, decoding it if it was stored as an encoded value.
     *
     * @return the top value
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stack.peek() >= minimumElement) {
            return stack.peek();
        }

        return minimumElement;
    }

    /**
     * Returns the minimum element in the stack.
     *
     * @return the minimum value
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return minimumElement;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        MinStackWithoutExtraSpace minStack = new MinStackWithoutExtraSpace();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
    }

}
