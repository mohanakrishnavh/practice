package dsa.dynamicprogramming.onedimentionalarray;

/**
 * House Robber II Problem.
 * 
 * <p>Extension of House Robber where all houses are arranged in a circle.
 * This means the first and last houses are adjacent, so you cannot rob both.
 * 
 * <p>Solution approach:
 * - Case 1: Rob houses from index 0 to n-2 (exclude last house)
 * - Case 2: Rob houses from index 1 to n-1 (exclude first house)
 * - Return max of both cases
 * 
 * <p>Time Complexity: O(n) - Two passes through array
 * <p>Space Complexity: O(1) - Only constant space
 * 
 * <p>Example: For [2, 3, 2], cannot rob first and last together, so max = 3
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class HouseRobberII {
    /**
     * Finds maximum rob amount in circular arrangement.
     * 
     * <p>Solves by considering two scenarios: exclude first or exclude last house.
     * 
     * <p>Time Complexity: O(n) - Two linear passes
     * <p>Space Complexity: O(1) - Only constant space
     * 
     * @param nums array of money in each house
     * @return maximum amount that can be robbed
     */
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] excludingFirst = excludeIndex(nums, 0);
        int[] excludingLast = excludeIndex(nums, nums.length - 1);

        return Math.max(robHelper(excludingFirst), robHelper(excludingLast));
    }

    /**
     * Helper method to exclude an index from the array.
     * 
     * @param arr original array
     * @param excludeIndex index to exclude
     * @return new array without the excluded index
     */
    private static int[] excludeIndex(int[] arr, int excludeIndex) {
        int[] excludedArr = new int[arr.length - 1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != excludeIndex) {
                excludedArr[idx++] = arr[i];
            }
        }

        return excludedArr;
    }

    /**
     * Helper method to calculate max rob amount for a linear array.
     * 
     * <p>Uses space-optimized approach with two variables.
     * 
     * @param arr array of money in each house
     * @return maximum amount that can be robbed
     */
    private static int robHelper(int[] arr) {
        int n = arr.length;

        int prev = arr[0], prev2 = 0;
        for (int i = 1; i < n; i++) {
            int take = i > 1 ? arr[i] + prev2 : arr[i];
            int notTake = prev;

            int result = Math.max(take, notTake);

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
