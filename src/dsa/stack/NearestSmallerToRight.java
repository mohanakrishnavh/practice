package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NearestSmallerToRight
 * 
 * Finds, for every element, the nearest smaller element to its right, using a monotonic stack.
 *
 * <p>Scanning right to left, greater or equal values are popped from the stack; whatever remains on
 * top is the nearest smaller element to the right.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NearestSmallerToRight {

    /**
     * Computes the nearest smaller element to the right of each element.
     *
     * @param nums the input array
     * @return array where entry i is the nearest smaller value right of index i, or -1 if none exists
     */
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

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(getNearestSmallerToRight(arr)));
    }
}
