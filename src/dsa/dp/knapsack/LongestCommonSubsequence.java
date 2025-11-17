package dsa.dp.knapsack;

/**
 * LongestCommonSubsequence
 * 
 * <p>This class solves the Longest Common Subsequence (LCS) problem, which finds the length
 * of the longest subsequence present in both given strings. A subsequence is a sequence that
 * appears in the same relative order but not necessarily contiguous. Uses dynamic programming
 * with a 2D table where dp[i][j] represents the LCS length of the first i characters of text1
 * and first j characters of text2.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LongestCommonSubsequence {
    /**
     * Finds the length of the longest common subsequence between two strings.
     * 
     * <p>If characters match, we include it in LCS and move diagonally.
     * If they don't match, we take the maximum of excluding one character from either string.
     * 
     * <p>Time Complexity: O(m * n) where m and n are the lengths of the two strings
     * <p>Space Complexity: O(m * n) for the DP table
     * 
     * @param text1 the first string
     * @param text2 the second string
     * @return the length of the longest common subsequence
     * 
     * @example
     * Input: text1 = "abcde", text2 = "ace"
     * Output: 3 (LCS is "ace")
     */
    public static int length(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] t = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[m][n];
    }

    public static void main(String[] args) {
        System.out.println(LongestCommonSubsequence.length("abcde", "ace"));
    }
}
