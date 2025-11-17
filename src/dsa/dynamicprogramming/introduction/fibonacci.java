package dsa.dynamicprogramming.introduction;

import java.util.Arrays;

/**
 * Fibonacci Number - Dynamic Programming Introduction
 * 
 * <p>The Fibonacci numbers form a sequence where each number is the sum of the two
 * preceding ones, starting from 0 and 1. That is: F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n > 1.
 * 
 * <p>This classic problem demonstrates three dynamic programming approaches:
 * <ol>
 *   <li>Top-Down (Memoization): Recursive with caching - O(n) time, O(n) space</li>
 *   <li>Bottom-Up (Tabulation): Iterative with array - O(n) time, O(n) space</li>
 *   <li>Space Optimized: Iterative with variables - O(n) time, O(1) space</li>
 * </ol>
 * 
 * <p>Problem: Given n, calculate F(n).
 * 
 * <p>Example:
 * <pre>
 * Input: n = 5
 * Output: 5
 * Explanation: F(5) = F(4) + F(3) = 3 + 2 = 5
 * Sequence: 0, 1, 1, 2, 3, 5
 * </pre>
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class fibonacci {
    
    /**
     * Calculates the nth Fibonacci number using top-down memoization.
     * 
     * <p>Time Complexity: O(n) - each subproblem computed once
     * <p>Space Complexity: O(n) - for dp array and recursion stack
     * 
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    // Top-Down Approach
    public static int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        fib(n, dp);

        return dp[n];
    }

    /**
     * Helper method for top-down memoization.
     * 
     * @param n current position to calculate
     * @param dp memoization array
     * @return the nth Fibonacci number
     */
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

    /**
     * Calculates the nth Fibonacci number using bottom-up tabulation.
     * 
     * <p>Builds the solution iteratively from base cases up to n.
     * 
     * <p>Time Complexity: O(n)
     * <p>Space Complexity: O(n) - for the dp array
     * 
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    // Bottom-Up Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int fib2(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2;  i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    /**
     * Calculates the nth Fibonacci number using space-optimized iteration.
     * 
     * <p>Only keeps track of the previous two values instead of entire array.
     * This is the most efficient solution.
     * 
     * <p>Time Complexity: O(n)
     * <p>Space Complexity: O(1) - only uses two variables
     * 
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    // Space Optimized Solution
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 1;
        int second = 0;
        for (int i = 2; i <= n; i++) {
            int result = first + second;

            second = first;
            first = result;
        }

        return first;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib2(5));
        System.out.println(fib3(5));
    }
}
