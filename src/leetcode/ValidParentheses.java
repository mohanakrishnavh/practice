package leetcode;

import java.util.Stack;

public class ValidParentheses {
    private boolean isPair(char open, char close) {
        if (open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']') {
            return true;
        }

        return false;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
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

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
