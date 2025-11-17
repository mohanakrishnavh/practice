package dsa.design;

import java.util.Stack;

/**
 * MinStack
 * 
 * <p>This class implements a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time O(1). Stores pairs of [value, current_minimum] so that each element
 * knows the minimum value in the stack up to that point. This approach trades space for time
 * efficiency.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MinStack {
    Stack<int[]> stack;

    /**
     * Initializes the MinStack data structure.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    /**
     * Pushes a value onto the stack.
     * 
     * <p>Stores both the value and the current minimum as a pair [value, min].
     * 
     * <p>Time Complexity: O(1)
     * 
     * @param val the value to push
     */
    public void push(int val) {
        int min = stack.isEmpty() ? val : stack.peek()[1];
        if (val < min) {
            min = val;
        }

        stack.push(new int[]{val, min});
    }

    /**
     * Removes the top element from the stack.
     * 
     * <p>Time Complexity: O(1)
     */
    public void pop() {
        stack.pop();
    }

    /**
     * Retrieves the top element of the stack without removing it.
     * 
     * <p>Time Complexity: O(1)
     * 
     * @return the top element, or -1 if the stack is empty
     */
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek()[0];
    }

    /**
     * Retrieves the minimum element in the stack.
     * 
     * <p>Time Complexity: O(1)
     * 
     * @return the minimum element, or -1 if the stack is empty
     */
    public int getMin() {
        return stack.isEmpty() ? -1 : stack.peek()[1];
    }

    public static void main(String[] args) {
        dsa.stack.MinStack minStack = new dsa.stack.MinStack();
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
