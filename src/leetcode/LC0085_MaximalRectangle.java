package leetcode;

import java.util.Stack;

public class LC0085_MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        int[] histogram = new int[matrix[0].length];

        for (int j = 0; j < matrix[0].length; j++) {
            histogram[j] = Character.getNumericValue(matrix[0][j]);
        }

        int maximumArea = getMaximumArea(histogram);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                histogram[j] = matrix[i][j] == '0' ? 0 : histogram[j] + Character.getNumericValue(matrix[i][j]);
            }

            maximumArea = Math.max(maximumArea, getMaximumArea(histogram));
        }

        return maximumArea;
    }

    private int getMaximumArea(int[] nums) {
        int maximumArea = 0;
        int[] nearestSmallerToRight = getNearestSmallerToRight(nums);
        int[] nearestSmallerToLeft = getNearestSmallerToLeft(nums);

        for (int i = 0; i < nums.length; i++) {
            int width = nearestSmallerToRight[i] - nearestSmallerToLeft[i] - 1;
            int area = width * nums[i];
            if (area > maximumArea) {
                maximumArea = area;
            }
        }

        return maximumArea;
    }

    private int[] getNearestSmallerToRight(int[] nums) {
        int[] nsr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? nums.length : stack.peek();
            stack.push(i);
        }

        return nsr;
    }

    private int[] getNearestSmallerToLeft(int[] nums) {
        int[] nsl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return nsl;
    }
}
