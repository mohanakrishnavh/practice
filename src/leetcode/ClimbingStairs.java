package leetcode;

/**
 * ClimbingStairs
 * 
 * Counts the distinct ways to climb a staircase taking 1 or 2 steps at a time.
 *
 * <p>Approach: Dynamic programming. {@code dp[i] = dp[i-1] + dp[i-2]} (a Fibonacci recurrence),
 * since the last move was either a single or a double step.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(n).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ClimbingStairs {
    /**
     * Returns the number of distinct ways to reach step {@code n}.
     *
     * @param n the number of steps
     * @return the number of ways, or 0 if {@code n <= 0}
     */
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
