package dsa.dynamicprogramming.stocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxProfit(prices, 0, 1, dp);
    }

    private static int maxProfit(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length) {
            return 0;
        }

        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }


        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + maxProfit(prices, idx+1, 0, dp), maxProfit(prices, idx+1, 1, dp));
        } else {
            profit = Math.max(prices[idx] + maxProfit(prices, idx+1, 1, dp), maxProfit(prices, idx+1, 0, dp));
        }

        dp[idx][buy] = profit;
        return profit;
    }


    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int profit = 0;
        if (n <= 1) {
            return profit;
        }

        int[][] dp = new int[n + 1][2];
        dp[n][0] = 0;
        dp[n][1] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    profit = Math.max(-prices[idx] + dp[idx +1][0], dp[idx +1][1]);
                } else {
                    profit = Math.max(prices[idx] + dp[idx +1][1], dp[idx +1][0]);
                }

                dp[idx][buy] = profit;
            }
        }

        return dp[0][1];
    }

    public static int maxProfit3(int[] prices) {
        int n = prices.length;
        int profit = 0;
        if (n <= 1) {
            return profit;
        }

        int[] next = new int[2];
        int[] current = new int[2];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    profit = Math.max(-prices[idx] + next[0], next[1]);
                } else {
                    profit = Math.max(prices[idx] + next[1], next[0]);
                }

                current[buy] = profit;
            }

            next = current;
        }

        return next[1];
    }
}
