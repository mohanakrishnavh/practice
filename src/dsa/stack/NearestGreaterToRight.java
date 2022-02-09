package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {
    public static int[] getNearestGreaterToRight(int[] nums) {
        int[] ngr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ngr[i] = -1;
            } else if (stack.peek() > nums[i]) {
                ngr[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                    stack.pop();
                }

                ngr[i] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[i]);
        }

        return ngr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 0, 1, 2, 4};
        System.out.println(Arrays.toString(getNearestGreaterToRight(nums)));
    }
}
