package leetcode;

/**
 * LeetCode Problem 322: Coin Change
 * Difficulty: Medium
 * 
 * <p>You are given an integer array coins representing coins of different denominations and
 * an integer amount representing a total amount of money.
 * 
 * <p>Return the fewest number of coins that you need to make up that amount. If that amount
 * of money cannot be made up by any combination of the coins, return -1.
 * 
 * <p>You may assume that you have an infinite number of each kind of coin.
 * 
 * <p>Example 1:
 * <pre>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: coins = [2], amount = 3
 * Output: -1
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: coins = [1], amount = 0
 * Output: 0
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= coins.length <= 12</li>
 *   <li>1 <= coins[i] <= 2^31 - 1</li>
 *   <li>0 <= amount <= 10^4</li>
 * </ul>
 * 
 * <p>Dynamic Programming Approach (Unbounded Knapsack):
 * <ol>
 *   <li>dp[i][amount] = minimum coins needed using first i coin types to make amount</li>
 *   <li>For each coin, we can either take it (if it fits) or skip it</li>
 *   <li>If we take it, we add 1 coin and solve for (amount - coin_value)</li>
 *   <li>Since we can use a coin multiple times, after taking it we stay at same coin index</li>
 * </ol>
 * 
 * <p>Time Complexity: O(n * amount) where n is the number of coin types
 * <p>Space Complexity: O(amount) - space optimized using 1D array
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0322_CoinChange {
    
    /**
     * Finds the minimum number of coins needed to make up the target amount.
     * 
     * <p>Uses dynamic programming with space optimization. For each coin type,
     * we update the minimum number of coins needed for each amount.
     * 
     * @param coins  array of coin denominations available
     * @param target the target amount to make
     * @return the minimum number of coins needed, or -1 if impossible
     */
    public int coinChange(int[] coins, int target) {
        int[] previous = new int[target+1];
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0) {
                previous[t] = t/coins[0];
            } else {
                previous[t] = (int) Math.pow(10, 9);
            }
        }

        for (int i = 1; i < coins.length; i++) {
            int[] current = new int[target+1];
            for (int t = 0; t <= target; t++) {
                int notTake = previous[t];
                int take = (int) Math.pow(10, 9);
                if (coins[i] <= t) {
                    take = 1 + current[t - coins[i]];
                }

                current[t] = Math.min(take, notTake);
            }
            previous = current;
        }

        int numberOfCoins = previous[target];
        if (numberOfCoins >= (int) Math.pow(10, 9)) {
            return -1;
        }

        return numberOfCoins;
    }
}
