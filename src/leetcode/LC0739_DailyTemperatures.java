package leetcode;

import java.util.Stack;

/**
 * LeetCode Problem 739: Daily Temperatures
 * Difficulty: Medium
 * 
 * <p>Find how many days until a warmer temperature.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            answers[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return answers;
    }
}
