package leetcode;

import java.util.Stack;

public class LC0020_ValidParentheses {
    private boolean isPair(char open, char close) {
        return open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']';
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isPair(stack.peek(), ch)) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
