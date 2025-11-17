package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * MaximumAreaRectangleInBinaryMatrix
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MaximumAreaRectangleInBinaryMatrix {
    public static int getMaximumAreaRectangleInBinaryMatrix(int[][] matrix) {
        int[] histogram = Arrays.copyOf(matrix[0], matrix[0].length);
        int maximumArea = getMaximumArea(histogram);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                histogram[j] = matrix[i][j] == 0 ? 0 : histogram[j] + matrix[i][j];
            }

            maximumArea = Math.max(maximumArea, getMaximumArea(histogram));
        }

        return maximumArea;
    }

    private static int getMaximumArea(int[] nums) {
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

    private static int[] getNearestSmallerToRight(int[] nums) {
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

    private static int[] getNearestSmallerToLeft(int[] nums) {
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

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println(getMaximumAreaRectangleInBinaryMatrix(matrix));
    }
}