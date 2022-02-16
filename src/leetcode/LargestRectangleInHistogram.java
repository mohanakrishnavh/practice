package leetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int getLargestRectangleArea(int[] heights) {
        int maximumArea = 0;
        int[] nearestSmallerToRight = getNearestSmallerToRight(heights);
        int[] nearestSmallerToLeft = getNearestSmallerToLeft(heights);

        for (int i=0; i < heights.length; i++) {
            int width = nearestSmallerToRight[i] - nearestSmallerToLeft[i] - 1;
            int area = width * heights[i];
            if (area > maximumArea) {
                maximumArea = area;
            }
        }

        return maximumArea;
    }

    public int[] getNearestSmallerToRight(int[] nums) {
        int[] nearestSmallerToRight = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int pseudoIndex = nums.length;

        for (int i=nums.length-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                nearestSmallerToRight[i] = pseudoIndex;
            } else if (nums[stack.peek()] < nums[i]) {
                nearestSmallerToRight[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    stack.pop();
                }

                nearestSmallerToRight[i] = stack.isEmpty() ? pseudoIndex : stack.peek();
            }

            stack.push(i);
        }

        return nearestSmallerToRight;
    }

    public int[] getNearestSmallerToLeft(int[] nums) {
        int[] nearestSmallerToLeft = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int pseudoIndex = -1;

        for (int i=0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                nearestSmallerToLeft[i] = pseudoIndex;
            } else if (nums[stack.peek()] < nums[i]) {
                nearestSmallerToLeft[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                    stack.pop();
                }

                nearestSmallerToLeft[i] = stack.isEmpty() ? pseudoIndex : stack.peek();
            }

            stack.push(i);
        }

        return nearestSmallerToLeft;
    }
}
