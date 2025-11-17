package dsa.stack;

import java.util.Stack;

/**
 * Min Stack (Design)
 * 
 * <p>Design a stack that supports push, pop, top, and retrieving the minimum element
 * in constant time.
 * 
 * <p>Implement the MinStack class:
 * <ul>
 *   <li>MinStack() initializes the stack object</li>
 *   <li>void push(int val) pushes the element val onto the stack</li>
 *   <li>void pop() removes the element on the top of the stack</li>
 *   <li>int top() gets the top element of the stack</li>
 *   <li>int getMin() retrieves the minimum element in the stack</li>
 * </ul>
 * 
 * <p>All operations must run in O(1) time complexity.
 * 
 * <p>Solution Approach:
 * Store pairs of (value, currentMin) where currentMin is the minimum value
 * in the stack up to and including the current element. This way, each element
 * knows what the minimum was at the time it was added.
 * 
 * <p>Example:
 * <pre>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * </pre>
 * 
 * <p>Time Complexity: O(1) for all operations
 * <p>Space Complexity: O(n) where n is the number of elements
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MinStack {

    /**
     * Stack storing pairs of [value, minimum value at this point].
     */
    Stack<int[]> stack;

    /**
     * Initializes the MinStack data structure.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes a value onto the stack while maintaining minimum tracking.
     * 
     * <p>Stores [value, currentMin] where currentMin is min(val, previous minimum).
     * 
     * @param val the value to push onto the stack
     */
    public void push(int val) {
        int min = stack.isEmpty() ? val : stack.peek()[1];
        if (val < min) {
            min = val;
        }

        stack.push(new int[]{val, min});
    }

    /**
     * Removes the element on the top of the stack.
     */
    public void pop() {
        stack.pop();
    }

    /**
     * Gets the top element of the stack.
     * 
     * @return the top element, or -1 if stack is empty
     */
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek()[0];
    }

    /**
     * Retrieves the minimum element in the stack in O(1) time.
     * 
     * @return the minimum element in the stack, or -1 if stack is empty
     */
    public int getMin() {
        return stack.isEmpty() ? -1 : stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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
