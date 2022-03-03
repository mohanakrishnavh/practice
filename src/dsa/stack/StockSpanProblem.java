package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
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
    public static void main(String[] args) {
        int[] nums1 = new int[]{100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString((getStockSpan(nums1))));
        int[] nums2 = new int[]{31, 41, 48, 59, 79};
        System.out.println(Arrays.toString((getStockSpan(nums2))));
    }
}
