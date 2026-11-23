package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * MaximumAreaRectangleInBinaryMatrix
 * 
 * Finds the area of the largest rectangle containing only 1s in a binary matrix (LeetCode 85).
 *
 * <p>Each row is treated as the base of a histogram whose bar heights are the number of consecutive
 * 1s above (and including) that row. The largest rectangle in each row's histogram is computed with
 * monotonic stacks (as in {@link MaximumAreaHistogram}) and the overall maximum is returned.
 *
 * <p>Time complexity: O(rows * cols). Space complexity: O(cols).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MaximumAreaRectangleInBinaryMatrix {
    /**
     * Returns the area of the largest all-1s rectangle.
     *
     * @param matrix binary matrix of 0s and 1s
     * @return the maximum rectangle area
     */
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

    /**
     * Computes the largest rectangular area in a histogram.
     *
     * @param nums bar heights
     * @return the maximum rectangle area
     */
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

    /**
     * Finds, for every bar, the index of the nearest bar to its right that is strictly shorter.
     *
     * @param nums bar heights
     * @return array of indices; {@code nums.length} if no shorter bar exists to the right
     */
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

    /**
     * Finds, for every bar, the index of the nearest bar to its left that is strictly shorter.
     *
     * @param nums bar heights
     * @return array of indices; -1 if no shorter bar exists to the left
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        System.out.println(getMaximumAreaRectangleInBinaryMatrix(matrix));
    }
}