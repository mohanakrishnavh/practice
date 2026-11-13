package dsa.recursion.recursion;

import java.util.Stack;

/**
 * DeleteMiddleElementInAStack
 *
 * <p>Deletes the middle element of a stack using only stack operations (no extra array/list).
 *
 * <p><b>Idea:</b> pop elements off one by one (holding each in the call frame), remove the target when
 * {@code k == 1}, then push the held elements back while the recursion unwinds. The call stack acts as
 * the temporary storage.
 *
 * <p><b>Which element is "middle"?</b> {@code k = size/2 + 1} counts from the top. For size 5 → k = 3
 * (the true middle). For an even size, e.g. 4 → k = 3, i.e. the lower of the two middle elements
 * counting from the top.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class DeleteMiddleElementInAStack {
    public static Stack<Integer> deleteMiddleElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        // Position of the middle element, counted from the top (top = 1)
        int k = stack.size()/2 + 1;
        solve(stack, k);
        return stack;
    }

    private static void solve(Stack<Integer> stack, int k) {
        // Base case: the top of the stack is now the element to delete
        if (k == 1) {
            stack.pop();
            return;
        }

        // Hold the top element, dig deeper, then restore it after the deletion
        int val = stack.peek();
        stack.pop();
        solve(stack, k -1);
        stack.push(val);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMiddleElement(stack);
        System.out.println(stack); // [1, 2, 4, 5]
    }
}
