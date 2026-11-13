package dsa.recursion.recursion;

import java.util.Stack;

/**
 * ReverseStack
 *
 * <p>Reverses a stack in place using only recursion (no auxiliary data structure).
 *
 * <p><b>Idea (two recursions):</b>
 * <ol>
 *   <li>{@code reverse}: pop the top element, reverse the remaining stack recursively, then</li>
 *   <li>{@code insert}: place the held element at the <i>bottom</i> of the now-reversed stack.</li>
 * </ol>
 * {@code insert} digs to the bottom by popping, pushes the element when the stack is empty, then pushes
 * the popped elements back in their original order.
 *
 * <p><b>Complexity:</b> Time O(n^2) (each of n inserts costs O(n)), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReverseStack {
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        // Base case: 0 or 1 element is already reversed
        if (stack.size() <= 1) {
            return stack;
        }

        // Hold the top, reverse everything beneath it...
        int element = stack.peek();
        stack.pop();
        reverse(stack);
        // ...then slide the held element under all of them (to the bottom)
        insert(stack, element);

        return stack;
    }

    /** Inserts {@code element} at the bottom of the stack, preserving the order of the others. */
    private static void insert(Stack<Integer> stack, int element) {
        // Base case: reached the bottom
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insert(stack, element);
        stack.push(temp); // restore on the way back
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack); // [1, 2, 3, 4, 5]
        reverse(stack);
        System.out.println(stack); // [5, 4, 3, 2, 1]
    }
}
