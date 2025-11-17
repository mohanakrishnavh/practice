package dsa.dp.knapsack;

/**
 * SubsetSum
 * 
 * <p>This class solves the Subset Sum problem, which determines if there exists a subset
 * of the given array whose sum equals the target value. Uses dynamic programming with a
 * 2D boolean table where dp[i][j] indicates whether a sum of j can be achieved using the
 * first i elements. This is a classic 0/1 Knapsack variation.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class
SubsetSum {
    /**
     * Checks if there exists a subset with the given sum.
     * 
     * <p>Uses bottom-up DP where for each element, we can either include it or exclude it.
     * Base case: sum of 0 can always be achieved (empty subset).
     * 
     * <p>Time Complexity: O(n * sum) where n is array length and sum is the target
     * <p>Space Complexity: O(n * sum) for the DP table
     * 
     * @param arr the input array of positive integers
     * @param sum the target sum to achieve
     * @return true if a subset with the given sum exists, false otherwise
     * 
     * @example
     * Input: arr = [2, 3, 7, 8, 10], sum = 11
     * Output: true (subset: {3, 8})
     */
    public static boolean hasSubsetSum(int[] arr, int sum) {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];

        int j = 0;
        for (int i = 0; i <= arr.length; i++) {
            t[i][j] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(hasSubsetSum(new int[]{2, 3, 7, 8, 10}, 11));
        System.out.println(hasSubsetSum(new int[]{2, 3, 7, 13, 10}, 11));
    }
}
