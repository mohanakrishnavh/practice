package dsa.dp.mcm;

import java.util.Arrays;

/**
 * PalindromePartitioning
 * 
 * <p>This class solves the Palindrome Partitioning problem, which finds the minimum number
 * of cuts needed to partition a string such that every substring is a palindrome. Uses a
 * Matrix Chain Multiplication-style approach where we try all possible partition points
 * and choose the one that minimizes the total cuts. Provides both recursive and memoized
 * solutions with optimization to skip already palindromic substrings.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PalindromePartitioning {
    /**
     * Finds the minimum number of partitions using naive recursion.
     * 
     * <p>Time Complexity: O(2^n) - exponential without memoization
     * <p>Space Complexity: O(n) for recursion stack
     * 
     * @param s the input string
     * @return minimum number of cuts needed
     */
    public static int getPartitions(String s) {
        return solve(s, 0, s.length() - 1);
    }

    /**
     * Helper method for recursive solution.
     * If substring is already a palindrome, no cuts needed.
     */
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

    /**
     * Finds the minimum number of partitions using memoization (top-down DP).
     * 
     * <p>Time Complexity: O(n^3) where n is the length of the string
     * <p>Space Complexity: O(n^2) for the DP table
     * 
     * @param s the input string
     * @return minimum number of cuts needed
     */
    public static int getPartitionsOptimized(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(s, 0, s.length() - 1, dp);
    }

    /**
     * Helper method for memoized solution with additional optimization.
     * Checks DP table before recursing to avoid recomputation.
     */
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

    /**
     * Checks if a substring is a palindrome.
     * 
     * @param s the string
     * @param i start index
     * @param j end index
     * @return true if substring s[i..j] is a palindrome
     */
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
