package dsa.dynamicprogramming.stocks;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
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
