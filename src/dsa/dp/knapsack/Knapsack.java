package dsa.dp.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Knapsack
 * 
 * <p>This class implements solutions to the classic 0/1 Knapsack problem where we need to
 * maximize the total value of items placed in a knapsack without exceeding its weight capacity.
 * Each item can only be used once (0 or 1 times). Provides multiple implementations:
 * recursive, memoized (top-down DP), and tabulation (bottom-up DP).
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Knapsack {
    /**
     * Finds the maximum profit using naive recursion.
     * 
     * <p>Time Complexity: O(2^n) - explores all possible combinations
     * <p>Space Complexity: O(n) for recursion stack
     * 
     * @param weights array of item weights
     * @param values array of item values
     * @param n number of items
     * @param W knapsack capacity
     * @return maximum profit achievable
     */
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

    /**
     * Finds the maximum profit and returns the indices of selected items.
     * 
     * <p>Time Complexity: O(n * W) with memoization
     * <p>Space Complexity: O(n * W) for the DP table
     * 
     * @param weights array of item weights
     * @param values array of item values
     * @param n number of items
     * @param W knapsack capacity
     * @return list of indices of selected items
     */
    private List<Integer> getMaxProfitMemoized2(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        List<Integer> result = new ArrayList<>();
        getMaxProfitMemoizedUtil2(weights, values, n, W, dp, result);
        return result;
    }

    /**
     * Helper method for memoized solution that tracks selected items.
     */
    private int getMaxProfitMemoizedUtil2(int[] weights, int[] values, int n, int W, int[][] dp, List<Integer> result) {
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (weights[n - 1] <= W) {
            int left = values[n - 1] + getMaxProfitMemoizedUtil2(weights, values, n - 1, W - weights[n - 1], dp, result);
            int right = getMaxProfitMemoizedUtil(weights, values, n - 1, W, dp);

            if (left > right) {
                result.add(n-1);
            }

            dp[n][W] = Math.max(left, right);
        } else {
            dp[n][W] = getMaxProfitMemoizedUtil(weights, values, n - 1, W, dp);
        }

        return dp[n][W];
    }

    /**
     * Finds the maximum profit using memoization (top-down DP).
     * 
     * <p>Time Complexity: O(n * W)
     * <p>Space Complexity: O(n * W) for DP table and recursion stack
     * 
     * @param weights array of item weights
     * @param values array of item values
     * @param n number of items
     * @param W knapsack capacity
     * @return maximum profit achievable
     */
    private int getMaxProfitMemoized(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMaxProfitMemoizedUtil(weights, values, n, W, dp);
    }

    /**
     * Helper method for memoized solution.
     */
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

    /**
     * Finds the maximum profit using tabulation (bottom-up DP).
     * 
     * <p>Builds a DP table iteratively where dp[i][j] represents the maximum profit
     * achievable using the first i items with capacity j.
     * 
     * <p>Time Complexity: O(n * W)
     * <p>Space Complexity: O(n * W) for the DP table
     * 
     * @param weights array of item weights
     * @param values array of item values
     * @param n number of items
     * @param W knapsack capacity
     * @return maximum profit achievable
     */
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
                "Max Profit (Recursive - Memoized) : "
                        + knapsack.getMaxProfitMemoized2(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 4, 7));
        System.out.println(
                "Max Profit (Top-down) : "
                        + knapsack.getMaxProfitTopDown(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 4, 7));
    }
}
