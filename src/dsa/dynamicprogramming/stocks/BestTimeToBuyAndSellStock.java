package dsa.dynamicprogramming.stocks;

/**
 * Best Time to Buy and Sell Stock.
 * 
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy and another day in the future to sell.
 * 
 * <p>This is a greedy algorithm problem where we track:
 * - Minimum price seen so far (best day to buy)
 * - Maximum profit achievable (difference between current price and min price)
 * 
 * <p>Time Complexity: O(n) - Single pass through array
 * <p>Space Complexity: O(1) - Only two variables
 * 
 * <p>Example: For [7, 1, 5, 3, 6, 4], buy at 1 and sell at 6 for profit of 5
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Finds maximum profit with single buy-sell transaction.
     * 
     * <p>Greedy approach: Track minimum price and maximum profit in one pass.
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Two variables
     * 
     * @param prices array of stock prices
     * @return maximum profit achievable
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }
}
