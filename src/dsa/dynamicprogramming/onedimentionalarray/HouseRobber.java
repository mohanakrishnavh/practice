package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * House Robber Problem.
 * 
 * <p>You are a robber planning to rob houses along a street. Each house has a certain amount of money.
 * Adjacent houses have security systems connected, so you cannot rob two adjacent houses.
 * Find the maximum amount of money you can rob without alerting the police.
 * 
 * <p>This is a classic DP problem where:
 * - rob(i) = max(rob(i-1), nums[i] + rob(i-2))
 * - At each house, decide whether to rob it or skip it
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion with Memoization - O(n) time, O(n) space</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For [1, 2, 3, 1], maximum rob = 4 (rob houses 0 and 2)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class HouseRobber {
    /**
     * Finds maximum rob amount using recursion with memoization.
     * 
     * <p>Time Complexity: O(n) - Each house computed once
     * <p>Space Complexity: O(n) - DP array + recursion stack
     * 
     * @param arr array of money in each house
     * @return maximum amount that can be robbed
     */
    public int rob(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];

        rob(arr.length-1, arr, dp);

        return dp[arr.length-1];
    }

    /**
     * Helper method for recursive calculation with memoization.
     * 
     * @param n current house index
     * @param arr array of money in each house
     * @param dp memoization array
     * @return maximum amount from current house to end
     */
    private int rob(int n, int[] arr, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return arr[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int pick = arr[n] + rob(n - 2, arr, dp);
        int notPick = rob(n - 1, arr, dp);

        dp[n] = Math.max(pick, notPick);
        return dp[n];
    }

    /**
     * Finds maximum rob amount using tabulation (Bottom-Up DP).
     * 
     * <p>Time Complexity: O(n) - Single pass through array
     * <p>Space Complexity: O(n) - DP array
     * 
     * @param arr array of money in each house
     * @return maximum amount that can be robbed
     */
    public int rob2(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            int notPick = dp[i - 1];
            if (i > 1) {
                pick = arr[i] + dp[i - 2];
            }

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }


    // Space Optimized
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public int rob3(int[] arr) {
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
