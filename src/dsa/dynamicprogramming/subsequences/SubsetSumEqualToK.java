package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

public class SubsetSumEqualToK {
    // Approach 1: Recursion
    public static boolean subsetSumEqualsK(int[] arr, int k) {
        return subsetSumHelper(arr, arr.length-1, k);
    }

    private static boolean subsetSumHelper(int[] arr, int index, int k) {
        if (k == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == k;
        }

        boolean notTake = subsetSumHelper(arr, index-1, k);
        boolean take = false;
        if (arr[index] <= k) {
            take = subsetSumHelper(arr, index-1, k - arr[index]);
        }

        return take || notTake;
    }

    // Approach 2 : Memoization
    public static boolean subsetSumEqualsK2(int[] arr, int k) {
        int[][] dp = new int[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subsetSumHelper(arr, arr.length-1, k, dp);
    }

    private static boolean subsetSumHelper(int[] arr, int index, int target, int[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[0] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean notTake = subsetSumHelper(arr, index-1, target, dp);
        boolean take = false;
        if (arr[index] <= target) {
            take = subsetSumHelper(arr, index-1, target - arr[index], dp);
        }

        dp[index][target] = (take || notTake) ? 1 : 0;
        return (take || notTake);
    }

    // Approach 3 : Bottom-Up
    public static boolean subsetSumEqualsK3(int[] arr, int k) {
        boolean[][] dp = new boolean[arr.length][k+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        dp[0][arr[0]] = true;

        for (int index = 1; index < arr.length; index++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if (arr[index] <= target) {
                    take = dp[index-1][target - arr[index]];
                }

                dp[index][target] = take || notTake;
            }
        }

        return dp[arr.length-1][k];
    }

    // Approach 4 : Space Optimization
    public static boolean subsetSumEqualsK4(int[] arr, int k) {
        boolean[] previous = new boolean[k+1];
        previous[0] = true;

        if (arr[0] <= k) {
            previous[arr[0]] = true;
        }

        for (int index = 1; index < arr.length; index++) {
            boolean[] current = new boolean[k+1];
            current[0] = true;

            for (int target = 1; target <= k; target++) {
                boolean notTake = previous[target];
                boolean take = false;
                if (arr[index] <= target) {
                    take = previous[target - arr[index]];
                }

                current[target] = take || notTake;
            }

            previous = current;
        }

        return previous[k];
    }

    public static void main(String[] args) {
        System.out.println(subsetSumEqualsK4(new int[]{2, 3, 1, 1}, 4));
        System.out.println(subsetSumEqualsK4(new int[]{2, 3, 1, 1}, 10));
    }
}
