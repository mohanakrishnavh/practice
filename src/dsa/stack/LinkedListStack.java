package dsa.stack;

import dsa.linkedlist.ListNode;
import java.util.EmptyStackException;

/**
 * Stack of {@code int} values backed by a singly linked list of {@link ListNode}s.
 *
 * <p>The head of the list is the top of the stack, so every operation only
 * touches the head and no resizing is ever needed.
 *
 * <p>Time complexity: {@code push}, {@code pop}, {@code peek} and {@code isEmpty}
 * are all O(1). There is no size limit; the stack grows until memory runs out.
 *
 * <p>Space complexity: O(n), one node per element.
 *
 * @author Practice Repository
 * @version 1.0
 */
public class LinkedListStack {
    /** Head of the list, which is the top of the stack; {@code null} when empty. */
    private ListNode head;

    /**
     * Pushes a value onto the top of the stack by inserting a new node at the head.
     *
     * @param val the value to push
     */
    public void push(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    /**
     * Removes and returns the value at the top of the stack.
     *
     * @return the value that was at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        int val = head.val;
        head = head.next;
        return val;
    }

    /**
     * Returns the value at the top of the stack without removing it.
     *
     * @return the value at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return head.val;
    }

    /**
     * Tells whether the stack contains no elements.
     *
     * @return {@code true} if the stack is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
}
