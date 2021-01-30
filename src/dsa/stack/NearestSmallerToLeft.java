package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {

    public static int[] getNearestSmallerToLeft(int[] nums) {
        int[] nsl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nums.length; i++) {
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else if (stack.peek() < nums[i]) {
                nsl[i] = stack.peek();
            } else {
                while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                    stack.pop();
                }

                nsl[i] = stack.isEmpty() ?  -1 : stack.peek();
            }

            stack.push(nums[i]);
        }

        return nsl;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(NearestSmallerToLeft.getNearestSmallerToLeft(arr)));
    }
}
