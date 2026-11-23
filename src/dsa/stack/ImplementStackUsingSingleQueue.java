package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ImplementStackUsingSingleQueue
 * 
 * Implements a LIFO stack using a single queue (LeetCode 225).
 *
 * <p>On each push the new element is added to the back and then all earlier elements are rotated
 * behind it, so the newest element is always at the front of the queue.
 *
 * <p>Complexity: push O(n); pop, top and empty O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ImplementStackUsingSingleQueue {

    Queue<Integer> q;

    /**
     * Creates an empty stack.
     */
    public ImplementStackUsingSingleQueue() {
        q = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack, rotating the queue so it becomes the front.
     *
     * @param x the element to push
     */
    public void push(int x) {
        int n = q.size();
        q.offer(x);
        for (int i = 0; i < n; i++) {
            q.offer(q.poll());
        }
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element, or -1 if the stack is empty
     */
    public int pop() {
        return q.isEmpty() ? -1 : q.poll();
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element, or -1 if the stack is empty
     */
    public int top() {
        return q.isEmpty() ? -1 : q.peek();
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if there are no elements
     */
    public boolean empty() {
        return q.isEmpty();
    }

}
