package dsa.dp.mcm;

import java.util.Arrays;

public class PalindromePartitioning {
    public static int getPartitions(String s) {
        return solve(s, 0, s.length() - 1);
    }

    public static int solve(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int partitions = 1 + solve(s, i, k) + solve(s, k + 1, j);

            if (partitions < min) {
                min = partitions;
            }
        }

        return min;
    }

    public static int getPartitionsOptimized(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, s.length() - 1, dp);
    }

    public static int solve(String s, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i >= j || isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = dp[i][k] != -1 ? dp[i][k] : solve(s, i, k, dp);
            int right = dp[k + 1][j] != -1 ? dp[k + 1][j] : solve(s, k + 1, j, dp);
            int partitions = 1 + left + right;

            if (partitions < min) {
                min = partitions;
            }
        }

        return min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        if (i == j) {
            return true;
        }

        if (i > j) {
            return true;
        }

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(getPartitions("nitin"));
        System.out.println(getPartitions("nitik"));

        System.out.println(getPartitionsOptimized("nitin"));
        System.out.println(getPartitionsOptimized("nitik"));
    }
}
