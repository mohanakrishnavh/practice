package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfixExpression {
    static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "^" -> 3;
            default -> -1;
        };
    }

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

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean isOpeningParenthesis(String token) {
        return token.equals("(");
    }

    private static boolean isClosingParenthesis(String token) {
        return token.equals(")");
    }

    private static boolean hasHigherPrecedence(String firstOperator, String secondOperator) {
        return (precedence(firstOperator) - precedence(secondOperator)) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.asList(infixToPostfix(new String[]{"A", "+", "B", "*", "C", "-", "D", "*", "E"})));
        System.out.println(Arrays.asList(infixToPostfixWithParenthesis(new String[]{"(", "(", "A", "+", "B", ")", "*", "(", "C", "-", "D", ")", ")", "*", "E"})));
    }
}
