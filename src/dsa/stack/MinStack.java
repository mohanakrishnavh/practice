package dsa.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minimumTracker;

    public MinStack() {
        stack = new Stack<>();
        minimumTracker = new Stack<>();
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

    public void push(int x) {
        stack.push(x);

        if (minimumTracker.isEmpty() || x <= minimumTracker.peek()) {
            minimumTracker.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stack.peek().equals(minimumTracker.peek())) {
            minimumTracker.pop();
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return minimumTracker.peek();
    }
}
