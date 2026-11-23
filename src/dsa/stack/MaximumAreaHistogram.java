package dsa.stack;

import java.util.Stack;

/**
 * MaximumAreaHistogram
 * 
 * Finds the largest rectangle that fits in a histogram (LeetCode 84).
 *
 * <p>For each bar, the nearest smaller bar on the left and on the right (found with monotonic
 * stacks) bound the widest rectangle using that bar's height: width = nsr - nsl - 1. The answer is the
 * maximum height x width over all bars.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MaximumAreaHistogram {
    /**
     * Computes the largest rectangular area in the histogram.
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
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(getMaximumArea(nums));
    }
}
