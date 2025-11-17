package leetcode;

import java.util.Stack;

/**
 * LeetCode Problem 155: Min Stack
 * Difficulty: Medium
 * 
 * <p>Design a stack that supports push, pop, top, and retrieving the minimum element.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0155_MinStack {
    Stack<Integer> stack;
    Stack<Integer> minimumTracker;

    public LC0155_MinStack() {
        stack = new Stack<>();
        minimumTracker = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minimumTracker.isEmpty() || val <= minimumTracker.peek()) {
            minimumTracker.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        if (stack.peek().equals(minimumTracker.peek())) {
            minimumTracker.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minimumTracker.isEmpty()) {
            return -1;
        }

        return minimumTracker.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

