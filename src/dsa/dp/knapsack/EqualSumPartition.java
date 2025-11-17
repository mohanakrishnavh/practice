package dsa.dp.knapsack;

/**
 * EqualSumPartition
 * 
 * <p>This class determines if an array can be partitioned into two subsets with equal sum.
 * The problem reduces to finding if a subset with sum equal to half of the total array sum
 * exists. If the total sum is odd, no equal partition is possible. This is a variation of
 * the Subset Sum problem.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class EqualSumPartition {
    /**
     * Checks if the array can be partitioned into two subsets with equal sum.
     * 
     * <p>Algorithm:
     * 1. Calculate the total sum of the array
     * 2. If sum is odd, return false (cannot be divided equally)
     * 3. Check if there exists a subset with sum = totalSum / 2
     * 
     * <p>Time Complexity: O(n * sum) where n is array length
     * <p>Space Complexity: O(n * sum) from the SubsetSum algorithm
     * 
     * @param nums the input array of integers
     * @return true if the array can be partitioned into two equal sum subsets, false otherwise
     * 
     * @example
     * Input: [1, 5, 11, 5]
     * Output: true (can be partitioned into [1, 5, 5] and [11])
     */
    public static boolean hasEqualSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        return SubsetSum.hasSubsetSum(nums, sum / 2);
    }

    public static void main(String[] args) {
        System.out.println(hasEqualSum(new int[]{1, 5, 11, 5}));
        System.out.println(hasEqualSum(new int[]{1, 11, 5, 2}));
    }
}
