package dsa.stack;

import java.util.Stack;

/**
 * EvaluatePrefixExpression
 * 
 * Evaluates a prefix (Polish Notation) expression using a stack.
 *
 * <p>Tokens are scanned right to left: operands are pushed, and each operator pops the top two
 * operands (the first popped is the left operand), applies the operation and pushes the result.
 * The final stack top is the answer.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class EvaluatePrefixExpression {
    /**
     * Evaluates a prefix expression.
     *
     * @param tokens operands and operators in prefix order
     * @return the value of the expression
     */
    public static int evaluatePolishNotation(String[] tokens) {
        int result;
        Stack<Integer> stack = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            if (isOperator(tokens[i])) {
                int firstOperand = stack.pop();
                int secondOperand = stack.pop();
                result = evaluate(tokens[i], firstOperand, secondOperand);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
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
        System.out.println(evaluatePolishNotation(new String[]{"-", "+", "*", "2", "3", "*", "5", "4", "9"}));
    }
}
