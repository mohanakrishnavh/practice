package dsa.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStackWithoutExtraSpace {

    private final Stack<Integer> stack;
    private int minimumElement;

    public MinStackWithoutExtraSpace() {
        stack = new Stack<>();
        minimumElement = -1;
    }

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

    public void pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stack.peek() < minimumElement) {
            minimumElement = 2 * minimumElement - stack.peek();
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        if (stack.peek() >= minimumElement) {
            return stack.peek();
        }

        return minimumElement;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }

        return minimumElement;
    }

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
