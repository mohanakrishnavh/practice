package dsa.stack;

import java.util.Stack;

public class EvaluatePrefixExpression {
    public static int evaluatePolishNotation(String[] tokens) {
        int result;
        Stack<Integer> stack = new Stack<>();

        for (int i = tokens.length-1; i>=0; i--) {
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

    private static  boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static int evaluate(String operator, int firstOperand, int secondOperand) {
        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(evaluatePolishNotation(new String[]{"-","+","*","2","3", "*","5","4", "9"}));
    }
}
