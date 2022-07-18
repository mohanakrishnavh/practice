package apple.design;

import java.util.Stack;

class MinStack {

    Stack<Integer> s;
    Stack<Integer> ss;

    public MinStack() {
        s = new Stack<>();
        ss = new Stack<>();
    }

    public void push(int val) {
        if (ss.isEmpty() || val <= ss.peek()) {
            ss.push(val);
        }

        s.push(val);
    }

    public void pop() {
        if (!ss.isEmpty() && s.peek().equals(ss.peek())) {
            ss.pop();
        }

        if (!s.isEmpty()) {
            s.pop();
        }
    }

    public int top() {
        return s.isEmpty() ? -1 : s.peek();
    }

    public int getMin() {
        return ss.isEmpty() ? -1 : ss.peek();
    }
}
