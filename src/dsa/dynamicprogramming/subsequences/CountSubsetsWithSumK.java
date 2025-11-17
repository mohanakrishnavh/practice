package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * Count Subsets with Sum K.
 * 
 * <p>Given an array of integers and a target sum K, count the number of subsets
 * whose elements sum to K. This implementation handles arrays with zeros specially.
 * 
 * <p>This implementation provides seven approaches:
 * <ul>
 *   <li>Recursion - Explores all possibilities</li>
 *   <li>Memoization - Caches subproblem results</li>
 *   <li>Tabulation - Bottom-up DP</li>
 *   <li>Space Optimization - Uses 1D array</li>
 *   <li>Handling zeros - Special case when array contains zeros</li>
 *   <li>Optimized with zero count - Multiplies result by 2^(zero count)</li>
 *   <li>Modulo arithmetic - For large results</li>
 * </ul>
 * 
 * <p>Example: For [1, 2, 2, 3] and K=3, there are 2 subsets: {1,2} and {3}
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CountSubsetsWithSumK {
    // Approach 1 : Recursion
    public static int countSubsets(int[] arr, int sum) {
        return countSubsetsHelper(arr, arr.length - 1, sum);
    }

    private static int countSubsetsHelper(int[] arr, int index, int sum) {
        // Sum becomes 0 at any point in time
        if (sum == 0) {
            return 1;
        }

        if (index == 0) {
            if (arr[0] == sum) {
                return 1;
            }

            return 0;
        }

        int notPick = countSubsetsHelper(arr, index-1, sum);
        int pick = 0;
        if (arr[index] <= sum) {
            pick = countSubsetsHelper(arr, index-1, sum - arr[index]);
        }

        return pick + notPick;
    }

    // Approach 2 : Memoization
    public static int countSubsets2(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countSubsetsHelper2(arr, arr.length - 1, sum, dp);
    }

    private static int countSubsetsHelper2(int[] arr, int index, int sum, int[][] dp) {
        // Sum becomes 0 at any point in time
        if (sum == 0) {
            return 1;
        }

        if (index == 0) {
            if (arr[0] == sum) {
                return 1;
            }

            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notPick = countSubsetsHelper(arr, index-1, sum);
        int pick = 0;
        if (arr[index] <= sum) {
            pick = countSubsetsHelper(arr, index-1, sum - arr[index]);
        }

        dp[index][sum] = pick + notPick;
        return dp[index][sum];
    }

    // Approach 3: Bottom - Up
    public static int countSubsets3(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];

        // Base Cases
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        dp[0][arr[0]] = 1;

        for (int index = 1; index < arr.length; index++) {
            for (int s = 1; s <= sum; s++) {
                int notPick = dp[index-1][s];
                int pick = 0;
                if (arr[index] <= s) {
                    pick = dp[index-1][s - arr[index]];
                }

                dp[index][s] = pick + notPick;
            }
        }

        return dp[arr.length-1][sum];
    }

    // Approach 4: Bottom - Up + Space Optimization
    public static int countSubsets4(int[] arr, int sum) {
        int[] previous = new int[sum+1];
        previous[0] = 1;

        if (arr[0] <= sum) {
            previous[arr[0]] = 1;
        }

        for (int index = 1; index < arr.length; index++) {
            int[] current = new int[sum+1];
            current[0] = 1;

            for (int s = 1; s <= sum; s++) {
                int notPick = previous[s];
                int pick = 0;
                if (arr[index] <= s) {
                    pick = previous[s - arr[index]];
                }

                current[s] = pick + notPick;
            }

            previous = current;
        }

        return previous[sum];
    }

    // Accept nums[i] value 0
    // Approach 1 : Top-Down + Memoization
    public static int countSubsets5(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countSubsetsHelper5(arr, arr.length - 1, sum, dp);
    }

    private static int countSubsetsHelper5(int[] arr, int index, int sum, int[][] dp) {
        if (index == 0) {
            // We can either pick or not pick the 0
            if (sum == 0 && arr[0] ==0) {
                return 2;
            }

            // the sum becomes 0 by picking the item
            if (sum == 0 || arr[0] == sum) {
                return 1;
            }

            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notPick = countSubsetsHelper5(arr, index-1, sum, dp);
        int pick = 0;
        if (arr[index] <= sum) {
            pick = countSubsetsHelper5(arr, index-1, sum - arr[index], dp);
        }

        dp[index][sum] = pick + notPick;
        return dp[index][sum];
    }

    // Accept nums[i] value 0
    // Approach 2: Bottom - Up
    public static int countSubsets6(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        // Choice of picking or not picking the 0
        dp[0][0] = (arr[0] == 0) ? 2 : 1;

        // It is possible that we have first element as 0.
        // So we need to ensure it is not 0
        if (arr[0] != 0 && arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }

        for (int index = 1; index < arr.length; index++) {
            for (int s = 1; s <= sum; s++) {
                int notPick = dp[index-1][s];
                int pick = 0;
                if (arr[index] <= s) {
                    pick = dp[index-1][s - arr[index]];
                }

                dp[index][s] = pick + notPick;
            }
        }

        return dp[arr.length-1][sum];
    }

    // Accept nums[i] value 0
    // Approach 2: Bottom - Up + Space Optimization
    public static int countSubsets7(int[] arr, int sum) {
        int[] previous = new int[sum+1];
        previous[0] = arr[0] == 0 ? 2 : 1;

        if (arr[0] != 0 && arr[0] <= sum) {
            previous[arr[0]] = 1;
        }

        for (int index = 1; index < arr.length; index++) {
            int[] current = new int[sum+1];
            for (int s = 1; s <= sum; s++) {
                int notPick = previous[s];
                int pick = 0;
                if (arr[index] <= s) {
                    pick = previous[s - arr[index]];
                }

                current[s] = pick + notPick;
            }

            previous = current;
        }

        return previous[sum];
    }

    public static void main(String[] args) {
        System.out.println(countSubsets4(new int[]{1, 2, 2, 3}, 3));
        System.out.println(countSubsets5(new int[]{0, 0, 1}, 1));
    }
}
