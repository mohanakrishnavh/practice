package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * Count Subsets with Given Difference.
 * 
 * <p>Given an array and a target difference D, count the number of ways to partition
 * the array into two subsets S1 and S2 such that |S1 - S2| = D.
 * 
 * <p>This problem reduces to the subset sum problem:
 * - If S1 + S2 = totalSum and S1 - S2 = D
 * - Then S1 = (totalSum + D) / 2
 * - Problem becomes: count subsets with sum = (totalSum + D) / 2
 * 
 * <p>Time Complexity: O(n * sum) where sum = (totalSum + D) / 2
 * <p>Space Complexity: Depends on subset sum implementation used
 * 
 * <p>Example: For [1, 1, 2, 3] and D=1, there are 3 ways
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CountSubsetsWithDifference {
    public static int countSubsets(int[] arr, int sum) {
        int[][] dp = new int[arr.length][sum+1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countSubsetsHelper(arr, arr.length - 1, sum, dp);
    }

    private static int countSubsetsHelper(int[] arr, int index, int sum, int[][] dp) {
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

        int notPick = countSubsetsHelper(arr, index-1, sum, dp);
        int pick = 0;
        if (arr[index] <= sum) {
            pick = countSubsetsHelper(arr, index-1, sum - arr[index], dp);
        }

        dp[index][sum] = pick + notPick;
        return dp[index][sum];
    }

    public static int countPartitions(int[] arr, int d) {
        int totalSum = Arrays.stream(arr).sum();

        if ((totalSum - d) < 0 || (totalSum -d) % 2 != 0) {
            return 0;
        }

        return countSubsets(arr, (totalSum - d)/2);
    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{5, 2, 6, 4}, 3));
    }
}
