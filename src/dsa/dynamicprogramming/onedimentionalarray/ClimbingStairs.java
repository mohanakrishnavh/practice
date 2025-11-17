package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * Climbing Stairs Problem.
 * 
 * <p>You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * <p>This is essentially a Fibonacci sequence problem where:
 * - ways(n) = ways(n-1) + ways(n-2)
 * - Base cases: ways(1) = 1, ways(2) = 2
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion with Memoization - O(n) time, O(n) space</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For n=3, there are 3 ways: (1+1+1), (1+2), (2+1)
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class ClimbingStairs {

    /**
     * Finds number of ways to climb stairs using space-optimized approach.
     * 
     * <p>Only stores the last two computed values. This is essentially computing
     * Fibonacci numbers since ways(n) = ways(n-1) + ways(n-2).
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Only two variables
     * 
     * @param n number of stairs
     * @return number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1, second = 2;
        int result;
        for (int i = 3; i <= n; i++) {
            result = first + second;

            first = second;
            second = result;
        }

        return second;
    }
}
