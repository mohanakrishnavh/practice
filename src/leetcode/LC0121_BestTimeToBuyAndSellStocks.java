package leetcode;

public class LC0121_BestTimeToBuyAndSellStocks {
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
