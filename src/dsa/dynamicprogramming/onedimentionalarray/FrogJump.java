package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * Frog Jump Problem.
 * 
 * <p>A frog is crossing a river by jumping on stones. The frog can jump either 1 or 2 steps.
 * Each stone has an associated cost (height difference). Find the minimum cost for the frog
 * to reach the last stone from the first stone.
 * 
 * <p>Cost is calculated as the absolute difference in heights between two stones.
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion with Memoization - O(n) time, O(n) space</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For heights [10, 30, 40, 20], minimum cost is 30 (10→30→20)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class FrogJump {
    /**
     * Finds minimum cost using recursion with memoization.
     * 
     * <p>Time Complexity: O(n) - Each stone computed once
     * <p>Space Complexity: O(n) - DP array + recursion stack
     * 
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        frogJump(heights, n - 1, dp);

        return dp[n-1];
    }

    /**
     * Helper method for recursive calculation with memoization.
     * 
     * @param heights array of stone heights
     * @param n current stone index
     * @param dp memoization array
     * @return minimum cost from current stone to end
     */
    private static int frogJump(int[] heights, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1)  {
            return dp[n];
        }

        int left = frogJump(heights, n - 1, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = n > 1 ? frogJump(heights, n -2, dp) + Math.abs(heights[n] - heights[n-2]) : Integer.MAX_VALUE;

        dp[n] = Math.min(left, right);
        return dp[n];
    }

    /**
     * Finds minimum cost using tabulation (Bottom-Up DP).
     * 
     * <p>Time Complexity: O(n) - Single pass through array
     * <p>Space Complexity: O(n) - DP array
     * 
     * @param n number of stones
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump2(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int right = i > 1 ? dp[i - 2] + Math.abs(heights[i]-heights[i-2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(left, right);
        }

        return dp[n-1];
    }

    /**
     * Finds minimum cost using space-optimized approach.
     * 
     * <p>Only stores the last two computed values instead of entire DP array.
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Only two variables
     * 
     * @param n number of stones
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump3(int n, int[] heights) {
        int first = 0, second = 0;
        for (int i = 1; i < n; i++) {
            int left = second + Math.abs(heights[i]-heights[i-1]);
            int right = i > 1 ? first + Math.abs(heights[i]-heights[i-2]) : Integer.MAX_VALUE;

            int result = Math.min(left, right);
            first = second;
            second = result;
        }

        return second;
    }

    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(frogJump2(6, new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(frogJump3(6, new int[]{30, 10, 60, 10, 60, 50}));
    }
}
