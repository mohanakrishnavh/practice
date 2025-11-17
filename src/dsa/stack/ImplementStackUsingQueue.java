package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ImplementStackUsingQueue
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public ImplementStackUsingQueue() {
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
