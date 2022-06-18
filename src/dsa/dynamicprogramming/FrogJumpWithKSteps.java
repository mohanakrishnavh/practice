package dsa.dynamicprogramming;

public class FrogJumpWithKSteps {
    public static int frogJump(int n, int[] heights, int k) {
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j < 0) {
                    break;
                }

                int currentSteps = dp[i-j] + Math.abs(heights[i]-heights[i-j]);
                minSteps = Math.min(currentSteps, minSteps);
            }
            dp[i] = minSteps;
        }

        return dp[n-1];
    }
}
