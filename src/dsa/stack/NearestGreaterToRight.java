package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * NearestGreaterToRight
 * 
 * Finds, for every element, the nearest greater element to its right, using a monotonic stack.
 *
 * <p>Scanning right to left, smaller or equal values are popped from the stack; whatever remains on
 * top is the nearest greater element to the right.
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NearestGreaterToRight {

    /**
     * Computes the nearest greater element to the right of each element.
     *
     * @param nums the input array
     * @return array where entry i is the nearest greater value right of index i, or -1 if none exists
     */
    private static int[] getNearestGreaterToRight(int[] nums) {
        int[] ngr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            ngr[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return ngr;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 0, 0, 1, 2, 4};
        System.out.println(Arrays.toString(getNearestGreaterToRight(nums)));
    }
}
