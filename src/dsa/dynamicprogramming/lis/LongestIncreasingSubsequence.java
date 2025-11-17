package dsa.dynamicprogramming.lis;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence (LIS) Problem.
 * 
 * <p>Given an array of integers, find the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from the array by deleting some or no elements
 * without changing the order of the remaining elements.
 * 
 * <p>This implementation provides five approaches:
 * <ul>
 *   <li>Recursion - Explores all possibilities</li>
 *   <li>Memoization - Caches subproblem results</li>
 *   <li>Tabulation - Bottom-up DP</li>
 *   <li>Binary Search - Optimal O(n log n) solution</li>
 *   <li>Print LIS - Prints the actual longest increasing subsequence</li>
 * </ul>
 * 
 * <p>Example: For [10, 9, 2, 5, 3, 7, 101, 18], the LIS is [2, 3, 7, 101] with length 4.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LongestIncreasingSubsequence {
    /**
     * Finds LIS length using recursion.
     * 
     * <p>Time Complexity: O(2^n) - Exponential
     * <p>Space Complexity: O(n) - Recursion stack
     * 
     * @param nums input array
     * @return length of longest increasing subsequence
     */
    public static int lengthOfLIS(int[] nums) {
        return lis(nums, 0, -1);
    }

    /**
     * Helper method for recursive LIS calculation.
     * 
     * @param arr input array
     * @param index current index
     * @param previousIndex index of previous element in LIS
     * @return LIS length from current position
     */
    private static int lis(int[] arr, int index, int previousIndex) {
        if (index == arr.length) {
            return 0;
        }

        int length = lis(arr, index+1, previousIndex);
        if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
            length = Math.max(length, 1 + lis(arr, index+1, index));
        }

        return length;
    }

    /**
     * Finds LIS length using memoization (Top-Down DP).
     * 
     * <p>Time Complexity: O(n^2) - Each state computed once
     * <p>Space Complexity: O(n^2) - DP table + recursion stack
     * 
     * @param arr input array
     * @return length of longest increasing subsequence
     */
    public static int lis2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lis(arr, 0, -1, dp);
    }

    /**
     * Helper method for memoized LIS calculation.
     * 
     * @param arr input array
     * @param index current index
     * @param previousIndex index of previous element in LIS
     * @param dp memoization table
     * @return LIS length from current position
     */
    private static int lis(int[] arr, int index, int previousIndex, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][previousIndex+1] != -1) {
            return dp[index][previousIndex+1];
        }

        int length = lis(arr, index+1, previousIndex, dp);
        if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
            length = Math.max(length, 1 + lis(arr, index+1, index, dp));
        }

        dp[index][previousIndex+1] = length;
        return dp[index][previousIndex+1];
    }

    /**
     * Finds LIS length using tabulation (Bottom-Up DP).
     * 
     * <p>Time Complexity: O(n^2) - Nested loops
     * <p>Space Complexity: O(n^2) - DP table
     * 
     * @param arr input array
     * @return length of longest increasing subsequence
     */
    public static int lis3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for(int index = n-1; index >= 0; index--) {
            for(int previousIndex = index-1; previousIndex >= -1; previousIndex--) {
                int length = dp[index+1][previousIndex+1];
                if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
                    length = Math.max(length, 1 + dp[index+1][index+1]);
                }

                dp[index][previousIndex+1] = length;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(lis3(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
