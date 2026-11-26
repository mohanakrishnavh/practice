package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * Frog Jump Problem.
 * 
 * <p>A frog starts on stone 0 and wants to reach the last stone. From stone {@code i} it can jump
 * to stone {@code i + 1} or {@code i + 2}, and each jump costs the absolute difference in height
 * between the two stones. Find the minimum total cost to reach the last stone.
 * 
 * <p><b>Idea:</b> the frog lands on stone {@code i} from stone {@code i - 1} or {@code i - 2}, so
 * {@code dp[i] = min(dp[i - 1] + |h[i] - h[i - 1]|, dp[i - 2] + |h[i] - h[i - 2]|)}, with
 * {@code dp[0] = 0} and the 2-step option only when {@code i > 1}. The answer is {@code dp[n - 1]}.
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion with Memoization - O(n) time, O(n) space</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For heights [10, 30, 40, 20], minimum cost is 30: stone 0 → 1 → 3
 * (heights 10 → 30 → 20, cost 20 + 10).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FrogJump {
    /**
     * Finds minimum cost using recursion with memoization (top-down DP).
     * 
     * <p>Starts the recursion at the last stone and works back towards stone 0, caching each
     * stone's answer in {@code dp} (-1 means not computed yet).
     * 
     * <p>Time Complexity: O(n) - Each stone computed once
     * <p>Space Complexity: O(n) - DP array + recursion stack
     * 
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        frogJump(heights, n - 1, dp);

        return dp[n-1];
    }

    /**
     * Recursive helper: minimum cost to reach stone {@code n} from stone 0.
     * 
     * <p>Base case: stone 0 costs 0. Otherwise tries arriving from {@code n - 1} and, when it exists,
     * from {@code n - 2}, and stores the cheaper result in {@code dp[n]}.
     * 
     * @param heights array of stone heights
     * @param n current stone index
     * @param dp memoization array; {@code dp[i] == -1} means stone {@code i} is not computed yet
     * @return minimum cost to reach stone {@code n} from stone 0
     */
    private static int frogJump(int[] heights, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1)  {
            return dp[n];
        }

        int left = frogJump(heights, n - 1, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = n > 1 ? frogJump(heights, n -2, dp) + Math.abs(heights[n] - heights[n-2]) : Integer.MAX_VALUE;
        dp[n] = Math.min(left, right);

        return dp[n];
    }

    /**
     * Finds minimum cost using tabulation (Bottom-Up DP).
     * 
     * <p>Fills {@code dp} from stone 0 forward, where {@code dp[i]} is the minimum cost to reach
     * stone {@code i}; each entry needs only the two before it.
     * 
     * <p>Time Complexity: O(n) - Single pass through array
     * <p>Space Complexity: O(n) - DP array
     * 
     * @param n number of stones
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump2(int n, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int right = i > 1 ? dp[i - 2] + Math.abs(heights[i] - heights[i-2]) : Integer.MAX_VALUE;

            dp[i] = Math.min(left, right);
        }

        return dp[n-1];
    }

    /**
     * Finds minimum cost using space-optimized approach.
     * 
     * <p>Same recurrence as {@link #frogJump2(int, int[])}, but only keeps the last two values instead
     * of the whole DP array: {@code second} holds {@code dp[i - 1]} and {@code first} holds
     * {@code dp[i - 2]}. Each iteration computes {@code dp[i]} and shifts the pair forward.
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Only two variables
     * 
     * @param n number of stones
     * @param heights array of stone heights
     * @return minimum cost to reach the last stone
     */
    public static int frogJump3(int n, int[] heights) {
        int first = 0, second = 0;
        for (int i = 1; i < n; i++) {
            int left = second + Math.abs(heights[i] - heights[i - 1]);
            int right = i > 1 ? first + Math.abs(heights[i] - heights[i - 2]) : Integer.MAX_VALUE;

            int result = Math.min(left, right);
            first = second;
            second = result;
        }

        return second;
    }

    /**
     * Demo driver: runs all three approaches on the same input (expected 40).
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(frogJump2(6, new int[]{30, 10, 60, 10, 60, 50}));
        System.out.println(frogJump3(6, new int[]{30, 10, 60, 10, 60, 50}));
    }
}
