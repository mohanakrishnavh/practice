package dsa.dp.knapsack;

/**
 * CountOfSubsetSum
 * 
 * <p>This class solves the problem of counting the number of subsets in an array that sum
 * to a given target value. Uses dynamic programming with a 2D table where dp[i][j] represents
 * the count of subsets using the first i elements that sum to j. This is a variation of the
 * classic 0/1 Knapsack problem.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class CountOfSubsetSum {
    /**
     * Counts the number of subsets that sum to the given target.
     * 
     * <p>Uses bottom-up dynamic programming. For each element, we can either include it
     * in the subset or exclude it. The count is the sum of both possibilities.
     * 
     * <p>Time Complexity: O(n * sum) where n is array length and sum is the target
     * <p>Space Complexity: O(n * sum) for the DP table
     * 
     * @param arr the input array of positive integers
     * @param sum the target sum
     * @return the count of subsets that sum to the target value
     * 
     * @example
     * Input: arr = [2, 3, 5, 6, 8, 10], sum = 10
     * Output: 3 (subsets: {2,3,5}, {2,8}, {10})
     */
    public static int subsetSumCount(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println(subsetSumCount(new int[]{2, 3, 5, 6, 8, 10}, 10));
    }
}
