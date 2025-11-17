package dsa.recursion.recursion;

import java.util.Stack;

/**
 * DeleteMiddleElementInAStack
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class DeleteMiddleElementInAStack {
    public static Stack<Integer> deleteMiddleElement(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }

        int k = stack.size()/2 + 1;
        solve(stack, k);
        return stack;
    }

    private static void solve(Stack<Integer> stack, int k) {
        if (k == 1) {
            stack.pop();
            return;
        }

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
        System.out.println(stack);
    }
}
