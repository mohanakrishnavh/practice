package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * 0/1 Knapsack Problem.
 * 
 * <p>Given weights and values of n items and a knapsack capacity W,
 * find the maximum value that can be obtained by selecting items such that
 * the total weight does not exceed W. Each item can be selected at most once.
 * 
 * <p>This is a classic DP problem with decision at each item: take it or leave it.
 * 
 * <p>This implementation provides five approaches:
 * <ul>
 *   <li>Recursion - Explores all possibilities, O(2^n)</li>
 *   <li>Memoization (Top-Down DP) - O(n*W) time, O(n*W) space</li>
 *   <li>Tabulation (Bottom-Up DP) - O(n*W) time, O(n*W) space</li>
 *   <li>Space Optimization (Two Arrays) - O(n*W) time, O(W) space</li>
 *   <li>Space Optimization (Single Array) - O(n*W) time, O(W) space</li>
 * </ul>
 * 
 * <p>Example: wt=[3,4,5], val=[30,50,60], W=8 → max value = 90 (items 0 and 2)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Knapsack {
    // Approach 1 : Recursion
    public static int getMaxProfit(int[] wt, int[] val, int W) {
        return getMaxProfit(wt, val, wt.length-1, W);
    }

    private static int getMaxProfit(int[] wt, int[] val, int index, int W) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index];
            }

            return 0;
        }

        int take = Integer.MIN_VALUE;
        int notTake = getMaxProfit(wt, val, index - 1, W);
        if (wt[index] <= W) {
            take = val[index] + getMaxProfit(wt, val, index-1, W - wt[index]);
        }

        return Math.max(take, notTake);
    }

    // Approach 2 : Top Down + Memoization
    public static int getMaxProfit2(int[] wt, int[] val, int W) {
        int[][] dp = new int[wt.length][W+1];
        for (int i = 0; i < wt.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return getMaxProfit2(wt, val, wt.length-1, W, dp);
    }

    private static int getMaxProfit2(int[] wt, int[] val, int index, int W, int[][] dp) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index];
            }

            return 0;
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int take = Integer.MIN_VALUE;
        int notTake = getMaxProfit(wt, val, index - 1, W);
        if (wt[index] <= W) {
            take = val[index] + getMaxProfit(wt, val, index-1, W - wt[index]);
        }

        dp[index][W] = Math.max(take, notTake);
        return dp[index][W];
    }

    // Approach 3 : Bottom - Up
    public static int getMaxProfit3(int[] wt, int[] val, int W) {
        int[][] dp = new int[wt.length][W+1];
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            for (int w = 0; w <= W; w++) {
                int take = Integer.MIN_VALUE;
                int notTake = dp[i - 1][w];
                if (wt[i] <= w) {
                    take = val[i] + dp[i-1][w - wt[i]];
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[wt.length-1][W];
    }

    // Approach 4 : Bottom - Up + Space Optimization
     public static int getMaxProfit4(int[] wt, int[] val, int W) {
        int[] previous = new int[W+1];
        for (int i = wt[0]; i <= W; i++) {
            previous[i] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            int[] current = new int[W+1];

            for (int w = 1; w <= W; w++) {
                int take = Integer.MIN_VALUE;
                int notTake = previous[w];
                if (wt[i] <= w) {
                    take = val[i] + previous[w - wt[i]];
                }

                current[w] = Math.max(take, notTake);
            }

            previous = current;
        }

        return previous[W];
    }

    // Approach 5 : Bottom - Up + Space Optimization (single array)
    public static int getMaxProfit5(int[] wt, int[] val, int W) {
        int[] previous = new int[W+1];
        for (int i = wt[0]; i <= W; i++) {
            previous[i] = val[0];
        }

        for (int i = 1; i < wt.length; i++) {
            for (int w = W; w >= 0; w--) {
                int take = Integer.MIN_VALUE;
                int notTake = previous[w];
                if (wt[i] <= w) {
                    take = val[i] + previous[w - wt[i]];
                }

                previous[w] = Math.max(take, notTake);
            }
        }

        return previous[W];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{3, 4, 5};
        int[] val = new int[]{30, 50, 60};
        int W = 8;

        System.out.println(getMaxProfit5(wt, val, W));
    }
}
