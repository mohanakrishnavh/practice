package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NearestSmallerToLeft
 * 
 * Finds, for every element, the nearest smaller element to its left, using a monotonic stack.
 *
 * <p>Scanning left to right, greater or equal values are popped from the stack; whatever remains on
 * top is the nearest smaller element to the left.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NearestSmallerToLeft {

    /**
     * Computes the nearest smaller element to the left of each element.
     *
     * @param nums the input array
     * @return array where entry i is the nearest smaller value left of index i, or -1 if none exists
     */
    private static int[] getNearestSmallerToLeft(int[] nums) {
        int[] nsl = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return nsl;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(getNearestSmallerToLeft(arr)));
    }
}
