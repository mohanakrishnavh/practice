package dsa.recursion.recursion;

import java.util.Stack;

public class SortAStack {
    public static void sort(Stack<Integer> stack) {
        if (stack.size() <= 1) {
            return;
        }

        int temp = stack.peek();
        stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

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
        System.out.println(stack);
    }
}
