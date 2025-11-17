package dsa.dynamicprogramming.lcs;

import java.util.Arrays;

/**
 * Longest Common Subsequence (LCS) Problem.
 * 
 * <p>Given two strings, find the length of the longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order but not necessarily contiguous.
 * 
 * <p>This implementation provides four approaches with increasing optimization:
 * <ul>
 *   <li>Recursion - Explores all possibilities</li>
 *   <li>Memoization (Top-Down DP) - Caches overlapping subproblems</li>
 *   <li>Tabulation (Bottom-Up DP) - Iteratively fills DP table</li>
 *   <li>Space Optimization - Uses only two arrays instead of 2D table</li>
 * </ul>
 * 
 * <p>Example: For s1 = "abcde" and s2 = "ace", the LCS is "ace" with length 3.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LongestCommonSubsequence {
    /**
     * Finds the length of LCS using memoization (Top-Down DP).
     * 
     * <p>Caches results of subproblems to avoid redundant calculations.
     * 
     * <p>Time Complexity: O(m*n) - Each state computed once
     * <p>Space Complexity: O(m*n) - DP table + recursion stack
     * 
     * @param text1 first string
     * @param text2 second string
     * @return length of longest common subsequence
     */
    public static int lcs(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lcs(n - 1, m - 1, text1, text2, dp);
    }

    /**
     * Helper method for memoized LCS calculation.
     * 
     * @param i current index in text1
     * @param j current index in text2
     * @param text1 first string
     * @param text2 second string
     * @param dp memoization table
     * @return LCS length from indices i and j
     */
    private static int lcs(int i, int j, String text1, String text2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + lcs(i - 1, j - 1, text1, text2, dp);
        } else {
            dp[i][j] = Math.max(lcs(i - 1, j, text1, text2, dp), lcs(i, j - 1, text1, text2, dp));
        }

        return dp[i][j];
    }

    /**
     * Finds the length of LCS using tabulation (Bottom-Up DP).
     * 
     * <p>Builds the DP table iteratively from base cases to final answer.
     * 
     * <p>Time Complexity: O(m*n) - Fills entire DP table
     * <p>Space Complexity: O(m*n) - DP table
     * 
     * @param text1 first string
     * @param text2 second string
     * @return length of longest common subsequence
     */
    public static int lcs2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Finds the length of LCS with space optimization.
     * 
     * <p>Uses only two arrays (previous and current row) instead of full 2D table.
     * 
     * <p>Time Complexity: O(m*n) - Same as tabulation
     * <p>Space Complexity: O(m) - Only two arrays of size m
     * 
     * @param text1 first string
     * @param text2 second string
     * @return length of longest common subsequence
     */
    public static int lcs3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j - 1]);
                }
            }
            prev=(int[])(cur.clone());
        }

        return prev[m];
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "ace"));
        System.out.println(lcs2("abcde", "ace"));
        System.out.println(lcs3("acd", "ced"));
    }
}
