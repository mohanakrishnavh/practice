package dsa.stack;

import java.util.Stack;

/**
 * CheckForBalancedParentheses
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CheckForBalancedParentheses {
    private static boolean isPair(char open, char close) {
        return open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']';
    }

    private static boolean isValid(String s) {
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

    public static void main(String[] args) {
        System.out.println(isValid("(A+B)"));
        System.out.println(isValid("{(A+B)+(C+D)}"));
        System.out.println(isValid("{(x+y)*(z)"));
        System.out.println(isValid("[2+3]+(A)]"));
        System.out.println(isValid("{a+z)"));
    }
}
