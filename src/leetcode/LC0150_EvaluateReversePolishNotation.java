package leetcode;

import java.util.Stack;

public class LC0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
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

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int evaluate(String operator, int firstOperand, int secondOperand) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }
}
