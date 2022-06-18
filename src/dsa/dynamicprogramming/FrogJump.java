package dsa.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {
    public static int frogjump(int[] heights, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        frogjump(heights, n - 1, dp);

        return dp[n-1];
    }

    private static int frogjump(int[] heights, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1)  {
            return dp[n];
        }

        int left = frogjump(heights, n - 1, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = n > 1 ? frogjump(heights, n -2, dp) + Math.abs(heights[n] - heights[n-2]) : Integer.MAX_VALUE;

        dp[n] = Math.min(left, right);
        return dp[n];
    }

    // Bottom-up Approach
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

    // Space Optimized
    public static int frogJump3(int n, int[] heights) {
        int prev1 = 0;
        int prev2 = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            int left = prev1 + Math.abs(heights[i]-heights[i-1]);
            int right = i > 1 ? prev2 + Math.abs(heights[i]-heights[i-2]) : Integer.MAX_VALUE;

            result = Math.min(left, right);
            prev2 = prev1;
            prev1 = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(frogjump(new int[]{30, 10, 60, 10, 60, 50}, 6));
        System.out.println(frogJump2(6, new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(frogJump3(6, new int[]{30, 10, 60, 10, 60, 50}));
    }
}
