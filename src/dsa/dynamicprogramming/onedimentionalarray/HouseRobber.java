package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

public class HouseRobber {
    // Top-Down Approach - Memoization
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public int rob(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];

        rob(arr.length-1, arr, dp);

        return dp[arr.length-1];
    }

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

    // Bottom-Up Approach
    // Time Complexity : O(N)
    // Space Complexity : O(N)
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
