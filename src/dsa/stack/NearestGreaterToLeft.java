package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {

    private static int[] getNearestGreaterToLeft(int[] nums) {
        int[] ngl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            ngl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return ngl;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 4};
        System.out.println(Arrays.toString(getNearestGreaterToLeft(arr)));
    }
}
