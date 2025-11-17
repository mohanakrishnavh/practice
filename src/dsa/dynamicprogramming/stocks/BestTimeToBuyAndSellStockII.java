package dsa.dynamicprogramming.stocks;

import java.util.Arrays;

/**
 * Best Time to Buy and Sell Stock II.
 * 
 * <p>Extension of stock problem where you can complete unlimited transactions.
 * However, you must sell the stock before you buy again (no multiple holdings).
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Memoization - O(n) time, O(n) space with states (index, canBuy)</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For [7, 1, 5, 3, 6, 4], multiple transactions can give profit of 7
 * (buy at 1, sell at 5, buy at 3, sell at 6)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BestTimeToBuyAndSellStockII {
    /**
     * Finds maximum profit with multiple transactions using memoization.
     * 
     * <p>State: (day, canBuy) where canBuy=1 means we can buy, canBuy=0 means we must sell
     * 
     * <p>Time Complexity: O(n) - Each state computed once
     * <p>Space Complexity: O(n) - DP table + recursion stack
     * 
     * @param prices array of stock prices
     * @return maximum profit achievable
     */
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return maxProfit(0, 1, prices, dp);
    }

    /**
     * Helper method for memoized calculation.
     * 
     * @param day current day
     * @param canBuy 1 if can buy, 0 if must sell
     * @param prices array of stock prices
     * @param dp memoization table
     * @return maximum profit from current state
     */
    private static int maxProfit(int day, int canBuy, int[] prices, int[][] dp) {
        if (day == prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }


        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(-prices[day] + maxProfit(day+1, 0, prices, dp), maxProfit(day+1, 1, prices, dp));
        } else {
            profit = Math.max(prices[day] + maxProfit(day+1, 1, prices, dp), maxProfit(day+1, 0, prices, dp));
        }

        dp[day][canBuy] = profit;
        return profit;
    }

    /**
     * Finds maximum profit using tabulation (Bottom-Up DP).
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(n) - DP table
     * 
     * @param prices array of stock prices
     * @return maximum profit achievable
     */
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
