package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * Subset Sum Problem.
 * 
 * <p>Given an array of non-negative integers and a target sum K,
 * determine if there exists a subset of the array with sum equal to K.
 * 
 * <p>This is a classic DP problem with decision at each element: include it or exclude it.
 * 
 * <p>This implementation provides four approaches:
 * <ul>
 *   <li>Recursion - Explores all possibilities, O(2^n)</li>
 *   <li>Memoization (Top-Down DP) - O(n*K) time, O(n*K) space</li>
 *   <li>Tabulation (Bottom-Up DP) - O(n*K) time, O(n*K) space</li>
 *   <li>Space Optimization - O(n*K) time, O(K) space</li>
 * </ul>
 * 
 * <p>Example: For [3, 34, 4, 12, 5, 2] and K=9, subset [4, 5] exists
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class SubsetSum {
    // Approach 1: Recursion
    public static boolean hasSubsetSum(int[] arr, int k) {
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
    public static boolean hasSubsetSum2(int[] arr, int k) {
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
    public static boolean hasSubsetSum3(int[] arr, int k) {
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
    public static boolean hasSubsetSum4(int[] arr, int k) {
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
        System.out.println(hasSubsetSum4(new int[]{2, 3, 1, 1}, 4));
        System.out.println(hasSubsetSum4(new int[]{2, 3, 1, 1}, 10));
    }
}
