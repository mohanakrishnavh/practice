package dsa.stack;

import java.util.Stack;

public class MaximumAreaHistogram {
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
        int[] nums = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaximumArea(nums));
    }
}
