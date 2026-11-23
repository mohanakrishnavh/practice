package dsa.stack;

import java.util.Stack;

/**
 * EvaluatePostfixExpression
 * 
 * Evaluates a postfix (Reverse Polish Notation) expression using a stack (LeetCode 150).
 *
 * <p>Tokens are scanned left to right: operands are pushed, and each operator pops the top two
 * operands (the second popped is the left operand), applies the operation and pushes the result.
 * The final stack top is the answer.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class EvaluatePostfixExpression {
    /**
     * Evaluates a postfix expression.
     *
     * @param tokens operands and operators in postfix order
     * @return the value of the expression
     */
    public static int evaluateReversePolishNotation(String[] tokens) {
        int result;
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                result = evaluate(token, firstOperand, secondOperand);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
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
     * Applies a binary operator to two operands.
     *
     * @param operator       one of + - * /
     * @param firstOperand   left operand
     * @param secondOperand  right operand
     * @return the result of the operation (0 for an unknown operator)
     */
    private static int evaluate(String operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            default -> 0;
        };
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(evaluateReversePolishNotation(new String[]{"2", "3", "*", "5", "4", "*", "+", "9", "-"}));
        System.out.println(evaluateReversePolishNotation(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(evaluateReversePolishNotation(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evaluateReversePolishNotation(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
