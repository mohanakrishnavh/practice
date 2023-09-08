package dsa.stack;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> input;
    Stack<Integer> output;

    public ImplementQueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        if (empty()) {
            return -1;
        }

        if (output.isEmpty()) {
            move();
        }

        return output.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }

        if (output.isEmpty()) {
            move();
        }

        return output.peek();
    }

    private void move() {
        while(!input.isEmpty()) {
            output.push(input.pop());
        }
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args){
        ImplementQueueUsingStack q = new ImplementQueueUsingStack();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }

}
