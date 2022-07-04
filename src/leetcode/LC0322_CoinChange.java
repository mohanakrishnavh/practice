package leetcode;

public class LC0322_CoinChange {
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
