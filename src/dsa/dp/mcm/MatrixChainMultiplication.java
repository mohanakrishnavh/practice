package dsa.dp.mcm;

import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int getCost(int[] nums) {
        int n = nums.length;
        return solve(nums, 1, n - 1);
    }

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

    public static int getCostOptimized(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 1, n - 1, dp);
    }

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
