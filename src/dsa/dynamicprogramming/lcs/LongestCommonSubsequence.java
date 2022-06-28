package dsa.dynamicprogramming.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static int lcs(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lcs(n - 1, m - 1, text1, text2, dp);
    }

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
