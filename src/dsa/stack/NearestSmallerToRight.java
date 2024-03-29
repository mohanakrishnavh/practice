package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {

    private static int[] getNearestSmallerToRight(int[] nums) {
        int[] nsr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return nsr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(getNearestSmallerToRight(arr)));
    }
}
