package dsa.dynamicprogramming;

public class LongestCommonSubsequence {
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
