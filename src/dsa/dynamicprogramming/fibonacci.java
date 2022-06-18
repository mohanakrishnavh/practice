package dsa.dynamicprogramming;

import java.util.Arrays;

public class fibonacci {
    // Top-Down Approach
    public static int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return dp[n];
    }


    private static int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    // Bottom-Up Approach
    public static int fib2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2;  i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // Optimized Solution
    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 1;
        int second = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = first + second;

            second = first;
            first = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib3(5));
    }
}
