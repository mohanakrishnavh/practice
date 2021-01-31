package leetcode;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public class Queue {

        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public Queue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            if (s2.isEmpty()) {
                move();
            }

            return s2.pop();
        }

        private void move() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        public int peek() {
            if (s2.isEmpty()) {
                move();
            }

            return s2.peek();
        }

        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
