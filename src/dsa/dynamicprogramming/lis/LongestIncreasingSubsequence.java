package dsa.dynamicprogramming.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // Approach 1 : Recursion
    public static int lis(int[] arr) {
        return lis(arr, 0, -1);
    }

    private static int lis(int[] arr, int index, int previousIndex) {
        if (index == arr.length) {
            return 0;
        }

        int length = lis(arr, index+1, previousIndex);
        if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
            length = Math.max(length, 1 + lis(arr, index+1, index));
        }

        return length;
    }

    // Approach 2 : Memoization
    public static int lis2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lis(arr, 0, -1, dp);
    }

    private static int lis(int[] arr, int index, int previousIndex, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }

        if (dp[index][previousIndex+1] != -1) {
            return dp[index][previousIndex+1];
        }

        int length = lis(arr, index+1, previousIndex, dp);
        if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
            length = Math.max(length, 1 + lis(arr, index+1, index, dp));
        }

        dp[index][previousIndex+1] = length;
        return dp[index][previousIndex+1];
    }

    // Approach 3 : Tabulation
    public static int lis3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];

        for(int index = n-1; index >= 0; index--) {
            for(int previousIndex = index-1; previousIndex >= -1; previousIndex--) {
                int length = dp[index+1][previousIndex+1];
                if (previousIndex == -1 || arr[index] > arr[previousIndex]) {
                    length = Math.max(length, 1 + dp[index+1][index+1]);
                }

                dp[index][previousIndex+1] = length;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(lis3(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
