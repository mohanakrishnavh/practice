package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] waitTimes = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=T.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                waitTimes[i] = 0;
            } else if (T[stack.peek()] > T[i]) {
                waitTimes[i] = 1;
            } else {
                while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                    stack.pop();
                }

                waitTimes[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            }

            stack.push(i);
        }


        return waitTimes;
    }
}
