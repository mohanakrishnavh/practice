package dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ImplementStackUsingQueue
 * 
 * Implements a LIFO stack using two queues (LeetCode 225).
 *
 * <p>Pushes are O(1) onto {@code q1}. To pop or read the top, all but the last element of {@code q1}
 * are moved to {@code q2}, exposing the most recently pushed element; for a pop the queues then swap roles.
 *
 * <p>Complexity: push O(1); pop and top O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ImplementStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Creates an empty stack.
     */
    public ImplementStackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param x the element to push
     */
    public void push(int x) {
        q1.add(x);
    }

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element
     */
    public int pop() {
        move();
        int val = q1.remove();

        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;

        return val;
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     */
    public int top() {
        move();
        return q1.peek();
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if there are no elements
     */
    public boolean empty() {
        return q1.isEmpty();
    }

    /**
     * Moves all but the last element of {@code q1} into {@code q2}, leaving the most recently pushed element in {@code q1}.
     */
    private void move() {
        while (q1.size() != 1) {
            q2.add(q1.remove());
        }
    }

}
