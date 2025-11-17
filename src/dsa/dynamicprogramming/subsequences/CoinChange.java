package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * Coin Change Problem (Minimum Coins).
 * 
 * <p>Given an infinite supply of coins of different denominations and a target amount,
 * find the minimum number of coins needed to make the target amount.
 * If the amount cannot be made, return -1.
 * 
 * <p>This implementation provides four approaches:
 * <ul>
 *   <li>Recursion - Explores all possibilities</li>
 *   <li>Memoization - Caches subproblem results</li>
 *   <li>Tabulation - Bottom-up DP</li>
 *   <li>Space Optimization - Uses 1D array</li>
 * </ul>
 * 
 * <p>Example: For coins [1, 2, 5] and amount=11, minimum coins = 3 (5+5+1)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CoinChange {
    // Approach 1 : Recursion
    public static int minCoins(int[] coins, int target) {
        return minCoinsHelper(coins, coins.length - 1, target);
    }

    private static int minCoinsHelper(int[] coins, int index, int target) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return target/coins[0];
            }

            return (int)Math.pow(10,9);
        }

        int notTake = minCoinsHelper(coins, index-1, target);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
            take = 1 + minCoinsHelper(coins, index, target - coins[index]);
        }

        return Math.min(take, notTake);
    }

    // Approach 2: Top Down + Memoization
    public static int minCoins2(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minCoinsHelper2(coins, coins.length - 1, target, dp);
    }

    private static int minCoinsHelper2(int[] coins, int index, int target, int[][] dp) {
        if (index == 0) {
            if (target % coins[0] == 0) {
                return target/coins[0];
            }

            return (int)Math.pow(10,9);
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = minCoinsHelper2(coins, index-1, target, dp);
        int take = (int) Math.pow(10, 9);
        if (coins[index] <= target) {
            take = 1 + minCoinsHelper2(coins, index, target - coins[index], dp);
        }

        dp[index][target] = Math.min(take, notTake);
        return dp[index][target];
    }

    // Approach 3: Tabulation (Bottom - Up)
    public static int minCoins3(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int t = 0; t <= target; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t/coins[0];
            } else {
                dp[0][t] = (int) Math.pow(10, 9);
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int t = 0; t <= target; t++) {
                int notTake = dp[i-1][t];
                int take = (int) Math.pow(10, 9);
                if (coins[i] <= t) {
                    take = 1 + dp[i][t - coins[i]];
                }

                dp[i][t] = Math.min(take, notTake);
            }
        }

        int numberOfCoins = dp[coins.length-1][target];
        if (numberOfCoins >= (int) Math.pow(10, 9)) {
            return -1;
        }

        return numberOfCoins;
    }

    // Approach 4: Tabulation (Bottom - Up) + Space Optimization
    public static int minCoins4(int[] coins, int target) {
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

    public static void main(String[] args) {
        int[] coins = new int[]{9, 6, 5, 1};
        System.out.println(minCoins4(coins, 11));
    }
}
