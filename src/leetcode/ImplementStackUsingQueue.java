package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    class Stack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public Stack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            move();
            int val = q1.remove();

            Queue<Integer> t = q1;
            q1 = q2;
            q2 = t;

            return val;
        }

        public int top() {
            move();
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }

        private void move() {
            while (q1.size() != 1) {
                q2.add(q1.remove());
            }
        }
    }
}
