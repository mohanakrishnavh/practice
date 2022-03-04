package leetcode;

import java.util.Stack;

public class LC0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=temperatures.length-1; i>=0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            answers[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return answers;
    }
}
