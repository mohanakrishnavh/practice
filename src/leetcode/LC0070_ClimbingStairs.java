package leetcode;

/**
 * LeetCode Problem 70: Climbing Stairs
 * Difficulty: Easy
 * 
 * <p>You are climbing a staircase. It takes n steps to reach the top.
 * 
 * <p>Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb
 * to the top?
 * 
 * <p>Example 1:
 * <pre>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= n <= 45</li>
 * </ul>
 * 
 * <p>Dynamic Programming Approach:
 * This is a classic Fibonacci sequence problem. To reach step n, you can come from
 * step (n-1) or step (n-2). Therefore: ways[n] = ways[n-1] + ways[n-2]
 * 
 * <p>Time Complexity: O(n)
 * <p>Space Complexity: O(1) - uses only two variables instead of array
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0070_ClimbingStairs {
    
    /**
     * Calculates the number of distinct ways to climb n stairs.
     * 
     * <p>Uses space-optimized dynamic programming (similar to Fibonacci sequence).
     * Only keeps track of the previous two states instead of maintaining an entire array.
     * 
     * @param n the total number of steps to reach the top
     * @return the number of distinct ways to climb to the top
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev = 1;
        int prev2 = 1;
        for (int i = 2 ; i <= n; i++) {
            int result = prev + prev2;

            prev2 = prev;
            prev = result;
        }

        return prev;
    }
}
