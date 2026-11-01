package dsa.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack of {@code int} values backed by a dynamically resizing array.
 *
 * <p>The {@code top} index points at the most recently pushed element and is
 * {@code -1} when the stack is empty. When the backing array fills up, its
 * capacity is doubled.
 *
 * <p>Time complexity: {@code push} is amortized O(1) (O(n) on the occasional
 * resize); {@code pop}, {@code peek}, {@code isEmpty} and {@code size} are O(1).
 *
 * <p>Space complexity: O(n).
 *
 * @author Practice Repository
 * @version 1.0
 */
public class ArrayStack {
    /** Initial capacity used by the no-argument constructor. */
    private static final int DEFAULT_CAPACITY = 100;

    /** Backing array; elements live in indices {@code 0..top}. */
    private int[] data;

    /** Index of the top element; {@code -1} when the stack is empty. */
    private int top = -1;

    /**
     * Creates an empty stack with the default capacity of {@value #DEFAULT_CAPACITY}.
     */
    public ArrayStack() {
        data = new int[DEFAULT_CAPACITY];
    }

    /**
     * Creates an empty stack with the given initial capacity.
     *
     * @param capacity the initial size of the backing array; must be positive
     * @throws IllegalArgumentException if {@code capacity} is zero or negative
     */
    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + capacity);
        }

        data = new int[capacity];
    }

    /**
     * Pushes a value onto the top of the stack, doubling the backing array first
     * if it is full.
     *
     * @param val the value to push
     */
    public void push(int val) {
        if (top == data.length - 1) {
            data = Arrays.copyOf(data, data.length * 2);
        }

        data[++top] = val;
    }

    /**
     * Removes and returns the value at the top of the stack.
     *
     * @return the value that was at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[top--];
    }

    /**
     * Returns the value at the top of the stack without removing it.
     *
     * @return the value at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return data[top];
    }

    /**
     * Tells whether the stack contains no elements.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the element count, i.e. {@code top + 1}
     */
    public int size() {
        return top + 1;
    }
}
