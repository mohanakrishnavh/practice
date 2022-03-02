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
        int[] nearestSmallerToRight = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int pseudoIndex = nums.length;

        for (int i = nums.length - 1; i >= 0; i--) {
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

    private static int[] getNearestSmallerToLeft(int[] nums) {
        int[] nearestSmallerToLeft = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int pseudoIndex = -1;

        for (int i = 0; i < nums.length; i++) {
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

    public static void main(String[] args) {
        int[] nums = new int[]{6, 2, 5, 4, 5, 1, 6};
        System.out.println(getMaximumArea(nums));
    }
}
