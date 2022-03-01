package dsa.stack;

import java.util.Stack;

public class EvaluatePostfixExpression {
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
        System.out.println(evaluateReversePolishNotation(new String[]{"2","1","+","3","*"}));
        System.out.println(evaluateReversePolishNotation(new String[]{"4","13","5","/","+"}));
        System.out.println(evaluateReversePolishNotation(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
