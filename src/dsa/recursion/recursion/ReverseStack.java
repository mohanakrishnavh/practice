package dsa.recursion.recursion;

import java.util.Stack;

public class ReverseStack {
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.size() <= 1) {
            return stack;
        }

        int element = stack.peek();
        stack.pop();
        reverse(stack);
        insert(stack, element);

        return stack;
    }

    private static void insert(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        insert(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
