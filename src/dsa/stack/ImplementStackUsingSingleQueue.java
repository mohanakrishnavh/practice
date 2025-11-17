package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ImplementStackUsingSingleQueue
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ImplementStackUsingSingleQueue {

    Queue<Integer> q;

    public ImplementStackUsingSingleQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        int n = q.size();
        q.offer(x);
        for (int i = 0; i < n; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.isEmpty() ? -1 : q.poll();
    }

    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

}
