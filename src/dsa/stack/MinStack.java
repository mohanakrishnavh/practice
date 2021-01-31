package dsa.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> s;
    private Stack<Integer> ss;

    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }

    public void push(int x) {
        s.push(x);

        if (ss.isEmpty() || x <= ss.peek()) {
            ss.push(x);
        }
    }

    public void pop() {
        if (s.isEmpty()) {
            throw new EmptyStackException();
        }

        if (s.peek().equals(ss.peek())) {
            ss.pop();
        }

        s.pop();
    }

    public int top() {
        if (s.isEmpty()) {
            throw new EmptyStackException();
        }

        return s.peek();
    }

    public int getMin() {
        if (s.isEmpty()) {
            throw new EmptyStackException();
        }

        return ss.peek();
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(2);
        m.push(0);
        m.push(3);
        m.push(0);

        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }
}
