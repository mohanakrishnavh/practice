package dsa.dp.knapsack;

import java.util.Arrays;

public class Knapsack {
    private int getMaxProfit(int[] weights, int[] values, int n, int W) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (weights[n - 1] <= W) {
            return Math.max(
                    values[n - 1] + getMaxProfit(weights, values, n - 1, W - weights[n - 1]),
                    getMaxProfit(weights, values, n - 1, W));
        }

        return getMaxProfit(weights, values, n - 1, W);
    }

    private int getMaxProfitMemoized(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMaxProfitMemoizedUtil(weights, values, n, W, dp);
    }

  /*private int getMaxProfitTopDown(int[] weights, int[] values, int n, int W) {
      int[][] t = new int[n + 1][W + 1];
      // Step 1 : Initialization (No need to do this in Java - Default value is 0)
      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= W; j++) {
              if (i == 0 || j == 0) {
                  t[i][j] = 0;
              }
          }
      }

      // Step 2 : Recursion --> Iterative
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= W; j++) {
              if (weights[i - 1] <= j) {
                  t[i][j] = Math.max(values[i - 1] + t[i - 1][j - weights[i - 1]], t[i - 1][j]);
              } else {
                  t[i][j] = t[i - 1][j];
              }
          }
      }

      return t[n][W];
  }*/

    private int getMaxProfitMemoizedUtil(int[] weights, int[] values, int n, int W, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (weights[n - 1] <= W) {
            dp[n][W] =
                    Math.max(
                            values[n - 1]
                                    + getMaxProfitMemoizedUtil(weights, values, n - 1, W - weights[n - 1], dp),
                            getMaxProfitMemoizedUtil(weights, values, n - 1, W, dp));
        } else {
            dp[n][W] = getMaxProfitMemoizedUtil(weights, values, n - 1, W, dp);
        }

        return dp[n][W];
    }

    private int getMaxProfitTopDown(int[] weights, int[] values, int n, int W) {
        // Step 1 : Initialization (No need to do this in Java - Default value is 0)
        int[][] dp = new int[n + 1][W + 1];

        // Step 2 : Recursion --> Iterative
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        System.out.println(
                "Max Profit (Recursive) : "
                        + knapsack.getMaxProfit(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 4, 7));
        System.out.println(
                "Max Profit (Recursive - Memoized) : "
                        + knapsack.getMaxProfitMemoized(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 4, 7));
        System.out.println(
                "Max Profit (Top-down) : "
                        + knapsack.getMaxProfitTopDown(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 4, 7));
    }
}
