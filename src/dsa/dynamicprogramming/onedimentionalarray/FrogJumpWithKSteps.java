package dsa.dynamicprogramming.onedimentionalarray;

/**
 * Frog Jump with K Steps Problem.
 * 
 * <p>Extension of the basic Frog Jump problem where the frog can jump up to K steps at a time
 * (instead of just 1 or 2 steps). The frog needs to reach the last stone with minimum cost.
 * 
 * <p>Cost is calculated as the absolute difference in heights between two stones.
 * 
 * <p>This implementation provides two approaches:
 * <ul>
 *   <li>Tabulation - O(n*k) time, O(n) space</li>
 *   <li>Space Optimization - O(n*k) time, O(k) space</li>
 * </ul>
 * 
 * <p>Example: For heights [10, 30, 40, 50, 20] and k=3, the frog can jump 1, 2, or 3 steps
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class FrogJumpWithKSteps {

    // Bottom-up Approach
    // Time Complexity : O(N * K)
    // Space Complexity : O(N)
    public static int minimizeCost(int n, int k, int[] height) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    minCost = Math.min(minCost, Math.abs(height[i] - height[i - j]) + dp[i - j]);
                }
            }

            dp[i] = minCost;
        }

        return dp[n - 1];
    }
}
