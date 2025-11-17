package leetcode;

/**
 * LeetCode Problem 121: Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * 
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * 
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * 
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve
 * any profit, return 0.
 * 
 * <p>Example 1:
 * <pre>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= prices.length <= 10^5</li>
 *   <li>0 <= prices[i] <= 10^4</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the length of the prices array
 * <p>Space Complexity: O(1) - only uses constant extra space
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0121_BestTimeToBuyAndSellStocks {
    
    /**
     * Calculates the maximum profit that can be achieved from one buy and one sell transaction.
     * 
     * <p>Algorithm (One-pass greedy approach):
     * <ol>
     *   <li>Track the minimum price seen so far (best buying price)</li>
     *   <li>For each day:
     *     <ul>
     *       <li>If current price is higher than minimum, calculate potential profit</li>
     *       <li>Update maximum profit if current profit is higher</li>
     *       <li>If current price is lower than minimum, update minimum price</li>
     *     </ul>
     *   </li>
     *   <li>Return the maximum profit found</li>
     * </ol>
     * 
     * <p>Key insight: We want to buy at the lowest price and sell at the highest price
     * after the buy. By tracking the minimum price seen so far and calculating profit
     * at each step, we find the optimal buy-sell pair in a single pass.
     * 
     * @param prices array of stock prices where prices[i] is the price on day i
     * @return the maximum profit that can be achieved, or 0 if no profit is possible
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                profit = Math.max(profit, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return profit;
    }
}
