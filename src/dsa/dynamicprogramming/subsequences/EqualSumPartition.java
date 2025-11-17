package dsa.dynamicprogramming.subsequences;

import static dsa.dynamicprogramming.subsequences.SubsetSum.hasSubsetSum4;

/**
 * Equal Sum Partition Problem.
 * 
 * <p>Given an array of integers, determine if it can be partitioned into two subsets
 * such that the sum of elements in both subsets is equal.
 * 
 * <p>This problem reduces to the subset sum problem:
 * - If total sum is odd, partition is impossible
 * - If total sum is even, check if there exists a subset with sum = totalSum / 2
 * 
 * <p>Time Complexity: O(n * sum) where sum = totalSum / 2
 * <p>Space Complexity: Depends on subset sum implementation
 * 
 * <p>Example: For [1, 5, 11, 5], can partition into [1, 5, 5] and [11]
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class EqualSumPartition {
    /**
     * Checks if array can be partitioned into two equal sum subsets.
     * 
     * <p>Time Complexity: O(n * sum/2) - Subset sum complexity
     * <p>Space Complexity: Depends on subset sum implementation
     * 
     * @param arr input array
     * @return true if equal partition exists, false otherwise
     */
    public static boolean canPartition(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        return hasSubsetSum4(arr, sum/2);
    }
}
