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

    private static int maxProfit(int[] prices, int index, int buy, int[][] dp) {
        if (index == prices.length -1) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }


        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[index] + maxProfit(prices, index+1, 0, dp), maxProfit(prices, index+1, 1, dp));
        } else {
            profit = Math.max(prices[index] + maxProfit(prices, index+1, 1, dp), maxProfit(prices, index+1, 0, dp));
        }

        dp[index][buy] = profit;
        return profit;
    }
}
