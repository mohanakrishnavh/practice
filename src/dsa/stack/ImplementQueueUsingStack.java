package dsa.stack;

import java.util.Stack;

/**
 * ImplementQueueUsingStack
 * 
 * Implements a FIFO queue using two stacks (LeetCode 232).
 *
 * <p>Elements are pushed onto an {@code input} stack. When an element must be removed or read and
 * the {@code output} stack is empty, all elements are moved from {@code input} to {@code output},
 * reversing their order so the oldest element is on top.
 *
 * <p>Complexity: push O(1); pop and peek amortised O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ImplementQueueUsingStack {

    Stack<Integer> input;
    Stack<Integer> output;

    /**
     * Creates an empty queue.
     */
    public ImplementQueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param x the element to add
     */
    public void push(int x) {
        input.push(x);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the front element, or -1 if the queue is empty
     */
    public int pop() {
        if (empty()) {
            return -1;
        }

        if (output.isEmpty()) {
            move();
        }

        return output.pop();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the front element, or -1 if the queue is empty
     */
    public int peek() {
        if (empty()) {
            return -1;
        }

        if (output.isEmpty()) {
            move();
        }

        return output.peek();
    }

    /**
     * Transfers all elements from the input stack to the output stack, reversing their order.
     */
    private void move() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if there are no elements
     */
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        ImplementQueueUsingStack q = new ImplementQueueUsingStack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }

}
