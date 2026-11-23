package dsa.stack;

import java.util.Stack;

/**
 * CheckForBalancedParentheses
 * 
 * Checks whether the brackets ( ), { } and [ ] in a string are balanced and correctly nested.
 *
 * <p>Opening brackets are pushed on a stack; each closing bracket must match the bracket on top of
 * the stack. The string is balanced if no mismatch occurs and the stack is empty at the end.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CheckForBalancedParentheses {
    /**
     * Checks whether two brackets form a matching pair.
     *
     * @param open  the opening bracket
     * @param close the closing bracket
     * @return true if {@code open} and {@code close} match, e.g. '(' and ')'
     */
    private static boolean isPair(char open, char close) {
        return open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']';
    }

    /**
     * Checks whether the brackets in the string are balanced. Non-bracket characters are ignored.
     *
     * @param s the string to check
     * @return true if every bracket is matched and properly nested
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(isValid("(A+B)"));
        System.out.println(isValid("{(A+B)+(C+D)}"));
        System.out.println(isValid("{(x+y)*(z)"));
        System.out.println(isValid("[2+3]+(A)]"));
        System.out.println(isValid("{a+z)"));
    }
}
