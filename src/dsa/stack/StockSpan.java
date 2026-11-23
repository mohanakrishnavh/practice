package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * StockSpan
 * 
 * Computes the stock span for each day (LeetCode 901): the number of consecutive days up to and
 * including that day on which the price was less than or equal to that day's price.
 *
 * <p>A monotonic stack of indices holds days with strictly greater prices; the span is the distance
 * from the current day to the index on top of the stack (or the full prefix length if the stack is empty).
 *
 * <p>Time complexity: O(n). Space complexity: O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class StockSpan {
    /**
     * Computes the span for every day.
     *
     * @param nums daily prices
     * @return array where entry i is the span of day i
     */
    private static int[] getStockSpan(int[] nums) {
        int[] stockSpan = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            stockSpan[i] = stack.isEmpty() ? 1 : i - stack.peek();
            stack.push(i);
        }

        return stockSpan;
    }

    // ["StockSpanner","next","next","next","next","next"]
    //[[],[31],[41],[48],[59],[79]]
    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString((getStockSpan(nums1))));
        int[] nums2 = new int[]{31, 41, 48, 59, 79};
        System.out.println(Arrays.toString((getStockSpan(nums2))));
    }
}
