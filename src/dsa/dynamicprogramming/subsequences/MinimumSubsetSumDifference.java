package dsa.dynamicprogramming.subsequences;

import java.util.Arrays;

/**
 * Minimum Subset Sum Difference Problem.
 * 
 * <p>Given an array of integers, partition it into two subsets such that
 * the absolute difference between their sums is minimized.
 * 
 * <p>Approach:
 * - Find all possible subset sums up to totalSum/2 using DP
 * - The largest achievable sum ≤ totalSum/2 is S1
 * - The other subset sum S2 = totalSum - S1
 * - Minimum difference = |S1 - S2| = |S1 - (totalSum - S1)| = |2*S1 - totalSum|
 * 
 * <p>Time Complexity: O(n * sum/2) where sum is total array sum
 * <p>Space Complexity: O(sum/2) - Space-optimized DP
 * 
 * <p>Example: For [1, 6, 11, 5], minimum difference = 1 (partition: [11] and [1,6,5])
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MinimumSubsetSumDifference {
    /**
     * Finds the minimum absolute difference between two subset sums.
     * 
     * <p>Uses space-optimized DP to find all achievable sums up to totalSum/2.
     * 
     * <p>Time Complexity: O(n * sum/2)
     * <p>Space Complexity: O(sum/2)
     * 
     * @param arr input array
     * @param n array length
     * @return minimum absolute difference between two subset sums
     */
    public static int minSubsetSumDifference(int[] arr, int n) {
        int sum = Arrays.stream(arr).sum();
        int k = sum / 2;

        boolean[] previous = new boolean[k + 1];
        previous[0] = true;

        if (arr[0] <= k) {
            previous[arr[0]] = true;
        }

        for (int index = 1; index < arr.length; index++) {
            boolean[] current = new boolean[k + 1];
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

        // The first true in the array will give us a subset sum equal to k
        int firstSubsetSum = previous.length - 1;
        while (!previous[firstSubsetSum]) {
            firstSubsetSum--;
        }


        return Math.abs(firstSubsetSum - (sum - firstSubsetSum));
    }
}
