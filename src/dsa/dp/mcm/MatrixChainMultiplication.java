package dsa.dp.mcm;

import java.util.Arrays;

/**
 * MatrixChainMultiplication
 * 
 * <p>This class solves the Matrix Chain Multiplication problem, which finds the minimum number
 * of scalar multiplications needed to multiply a chain of matrices. The order of multiplication
 * matters because matrix multiplication is associative: (A*B)*C ≠ A*(B*C) in terms of cost.
 * Given dimensions array where matrix i has dimensions [nums[i-1] x nums[i]], we find the
 * optimal parenthesization. Provides both recursive and memoized solutions.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MatrixChainMultiplication {
    /**
     * Calculates the minimum cost using naive recursion.
     * 
     * <p>Time Complexity: O(2^n) - exponential due to overlapping subproblems
     * <p>Space Complexity: O(n) for recursion stack
     * 
     * @param nums array where nums[i-1] x nums[i] are dimensions of matrix i
     * @return minimum number of scalar multiplications needed
     */
    public static int getCost(int[] nums) {
        int n = nums.length;
        return solve(nums, 1, n - 1);
    }

    /**
     * Helper method for recursive solution.
     * Tries all possible split points k between i and j.
     */
    private static int solve(int[] nums, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost = solve(nums, i, k)
                    + solve(nums, k + 1, j)
                    + nums[i - 1] * nums[k] * nums[j];

            if (cost < min) {
                min = cost;
            }
        }

        return min;
    }

    /**
     * Calculates the minimum cost using memoization (top-down DP).
     * 
     * <p>Time Complexity: O(n^3) where n is the number of matrices
     * <p>Space Complexity: O(n^2) for the DP table
     * 
     * @param nums array where nums[i-1] x nums[i] are dimensions of matrix i
     * @return minimum number of scalar multiplications needed
     */
    public static int getCostOptimized(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 1, n - 1, dp);
    }

    /**
     * Helper method for memoized solution.
     * Uses DP table to avoid recomputing overlapping subproblems.
     */
    private static int solve(int[] nums, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int cost = solve(nums, i, k)
                    + solve(nums, k + 1, j)
                    + nums[i - 1] * nums[k] * nums[j];

            if (cost < min) {
                min = cost;
            }
        }
        dp[i][j] = min;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(getCost(new int[]{10, 30, 5, 60}));
        System.out.println(getCost(new int[]{1, 2, 3, 4, 3}));

        System.out.println(getCostOptimized(new int[]{10, 30, 5, 60}));
        System.out.println(getCostOptimized(new int[]{1, 2, 3, 4, 3}));
    }
}
