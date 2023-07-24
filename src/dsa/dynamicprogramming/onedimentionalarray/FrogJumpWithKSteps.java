package dsa.dynamicprogramming.onedimentionalarray;

public class FrogJumpWithKSteps {

    // Bottom-up Approach
    // Time Complexity : O(N * K)
    // Space Complexity : O(N)
    public static int minimizeCost(int n, int k, int[] height) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minCostAtIndex = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    minCostAtIndex = Math.min(minCostAtIndex, Math.abs(height[i] - height[i - j]) + dp[i - j]);
                }
            }

            dp[i] = minCostAtIndex;
        }

        return dp[n - 1];
    }
}
