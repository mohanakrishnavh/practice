package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * InfixToPostfixExpression
 * 
 * Converts an infix expression (e.g. A + B * C) to postfix form using an operator stack.
 *
 * <p>Operands go straight to the output. For each operator, operators on the stack with equal or
 * higher precedence are popped to the output first, then the new operator is pushed. Remaining
 * operators are flushed at the end. Precedence: ^ (3) > * and / (2) > + and - (1).
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class InfixToPostfixExpression {
    /**
     * Returns the precedence of an operator.
     *
     * @param operator the operator token
     * @return 3 for ^, 2 for * and /, 1 for + and -, otherwise -1 (e.g. parentheses)
     */
    static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

    /**
     * Converts an infix expression without parentheses to postfix.
     *
     * @param infix tokens of the infix expression
     * @return tokens of the postfix expression
     */
    public static String[] infixToPostfix(String[] infix) {
        Stack<String> stack = new Stack<>();

        int index = 0;
        String[] postfix = new String[infix.length];
        for (String token : infix) {
            if (isOperator(token)) {
                while (!stack.isEmpty() && hasHigherPrecedence(stack.peek(), token)) {
                    postfix[index++] = stack.pop();
                }
                stack.push(token);
            } else {
                postfix[index++] = token;
            }
        }

        while (!stack.isEmpty()) {
            postfix[index++] = stack.pop();
        }

        return postfix;
    }

    // TODO: Fix the evaluation
    /**
     * Converts an infix expression that may contain parentheses to postfix.
     *
     * <p>Work in progress: operators remaining on the stack are not flushed to the output after the
     * last token, so results can be incomplete (see the TODO above).
     *
     * @param infix tokens of the infix expression
     * @return tokens of the postfix expression
     */
    public static String[] infixToPostfixWithParenthesis(String[] infix) {
        Stack<String> stack = new Stack<>();

        int index = 0;
        String[] postfix = new String[infix.length];
        for (String token : infix) {
            if (isOperator(token)) {
                while (!stack.isEmpty() && !isOpeningParenthesis(token) && hasHigherPrecedence(stack.peek(), token)) {
                    postfix[index++] = stack.pop();
                }
                stack.push(token);
            } else if (isOpeningParenthesis(token)) {
                stack.push(token);
            } else if (isClosingParenthesis(token)) {
                while (!stack.isEmpty() && !isOpeningParenthesis(stack.peek())) {
                    postfix[index++] = stack.pop();
                }

                stack.pop();
            } else {
                postfix[index++] = token;
            }
        }

        return postfix;
    }

    /**
     * Checks whether a token is one of the binary operators + - * /.
     *
     * @param token the token to test
     * @return true if the token is an operator
     */
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    /**
     * Checks whether a token is an opening parenthesis.
     *
     * @param token the token to test
     * @return true if the token is "("
     */
    private static boolean isOpeningParenthesis(String token) {
        return token.equals("(");
    }

    /**
     * Checks whether a token is a closing parenthesis.
     *
     * @param token the token to test
     * @return true if the token is ")"
     */
    private static boolean isClosingParenthesis(String token) {
        return token.equals(")");
    }

    /**
     * Compares two operators' precedence.
     *
     * @param firstOperator  operator (typically the one on top of the stack)
     * @param secondOperator operator being processed
     * @return true if the first operator has precedence greater than or equal to the second
     */
    private static boolean hasHigherPrecedence(String firstOperator, String secondOperator) {
        return (precedence(firstOperator) - precedence(secondOperator)) >= 0;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(Arrays.asList(infixToPostfix(new String[]{"A", "+", "B", "*", "C", "-", "D", "*", "E"})));
        System.out.println(Arrays.asList(infixToPostfixWithParenthesis(new String[]{"(", "(", "A", "+", "B", ")", "*", "(", "C", "-", "D", ")", ")", "*", "E"})));
    }
}
