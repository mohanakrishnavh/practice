package dsa.recursion.recursion;

import java.util.Stack;

/**
 * SortAStack
 *
 * <p>Sorts a stack in place using recursion only, leaving the largest element on top.
 *
 * <p><b>Idea:</b> identical to {@link SortAList}, with stack operations instead of list indexing:
 * pop the top, sort the remaining stack recursively, then {@code insert} the popped value into its
 * sorted position (popping larger elements aside and pushing them back afterwards).
 *
 * <p><b>Complexity:</b> Time O(n^2), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SortAStack {
    public static void sort(Stack<Integer> stack) {
        // Base case: 0 or 1 element is already sorted
        if (stack.size() <= 1) {
            return;
        }

        // Remove the top, sort the rest, then insert the top back in order
        int temp = stack.peek();
        stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    /** Inserts {@code temp} into the sorted stack so that the top stays the largest. */
    private static void insert(Stack<Integer> stack, int temp) {
        // Base case: empty, or top <= temp -> temp becomes the new top
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        // Top is bigger than temp: set it aside, insert temp below it, then restore it
        int val = stack.peek();
        stack.pop();
        insert(stack, temp);
        stack.push(val);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);

        sort(stack);
        System.out.println(stack); // [0, 1, 2, 5] (bottom -> top)
    }
}
