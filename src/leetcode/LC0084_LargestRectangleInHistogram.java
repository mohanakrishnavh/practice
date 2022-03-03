package leetcode;

import java.util.Stack;

public class LC0084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maximumArea = 0;
        int[] nearestSmallerToRight = getNearestSmallerToRight(heights);
        int[] nearestSmallerToLeft = getNearestSmallerToLeft(heights);

        for (int i = 0; i < heights.length; i++) {
            int width = nearestSmallerToRight[i] - nearestSmallerToLeft[i] - 1;
            int area = width * heights[i];
            if (area > maximumArea) {
                maximumArea = area;
            }
        }

        return maximumArea;
    }

    private int[] getNearestSmallerToRight(int[] heights) {
        int[] nsr = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }

        return nsr;
    }

    private int[] getNearestSmallerToLeft(int[] heights) {
        int[] nsl = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return nsl;
    }
}
