package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * House Robber Problem.
 * 
 * <p>You are a robber planning to rob houses along a street. Each house has a certain amount of money.
 * Adjacent houses have security systems connected, so you cannot rob two adjacent houses.
 * Find the maximum amount of money you can rob without alerting the police.
 * 
 * <p><b>Idea:</b> let {@code rob(i)} be the most money from houses {@code 0..i}. At house {@code i}
 * you either skip it, keeping {@code rob(i - 1)}, or rob it, which rules out house {@code i - 1}
 * and gives {@code nums[i] + rob(i - 2)}. So {@code rob(i) = max(rob(i - 1), nums[i] + rob(i - 2))},
 * with {@code rob(0) = nums[0]} and {@code rob(-1) = 0}. The answer is {@code rob(n - 1)}.
 * 
 * <p>This implementation provides three approaches:
 * <ul>
 *   <li>Recursion with Memoization - O(n) time, O(n) space</li>
 *   <li>Tabulation - O(n) time, O(n) space</li>
 *   <li>Space Optimization - O(n) time, O(1) space</li>
 * </ul>
 * 
 * <p>Example: For [1, 2, 3, 1], maximum rob = 4 (rob houses 0 and 2: 1 + 3).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class HouseRobber {
    /**
     * Finds maximum rob amount using recursion with memoization (top-down DP).
     * 
     * <p>Starts the recursion at the last house and works back towards house 0, caching each
     * house's answer in {@code dp} (-1 means not computed yet).
     * 
     * <p>Time Complexity: O(n) - Each house computed once
     * <p>Space Complexity: O(n) - DP array + recursion stack
     * 
     * @param nums array of money in each house
     * @return maximum amount that can be robbed
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];

        rob(nums.length-1, nums, dp);

        return dp[nums.length-1];
    }

    /**
     * Recursive helper: maximum amount that can be robbed from houses {@code 0..n}.
     * 
     * <p>Base cases: no houses ({@code n < 0}) gives 0, and only house 0 gives {@code nums[0]}.
     * Otherwise takes the better of robbing house {@code n} (plus the best up to {@code n - 2}) or
     * skipping it (the best up to {@code n - 1}), and stores it in {@code dp[n]}.
     * 
     * @param n current house index
     * @param nums array of money in each house
     * @param dp memoization array; {@code dp[i] == -1} means house {@code i} is not computed yet
     * @return maximum amount that can be robbed from houses {@code 0..n}
     */
    private int rob(int n, int[] nums, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return nums[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int pick = nums[n] + rob(n - 2, nums, dp);
        int notPick = rob(n - 1, nums, dp);

        dp[n] = Math.max(pick, notPick);
        return dp[n];
    }

    /**
     * Finds maximum rob amount using tabulation (Bottom-Up DP).
     * 
     * <p>Fills {@code dp} from house 0 forward, where {@code dp[i]} is the most money from houses
     * {@code 0..i}. For house 1 there is no {@code dp[i - 2]}, so robbing it means taking only
     * {@code nums[1]}.
     * 
     * <p>Time Complexity: O(n) - Single pass through array
     * <p>Space Complexity: O(n) - DP array
     * 
     * @param nums array of money in each house
     * @return maximum amount that can be robbed
     */
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // only house 0: rob it
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // rob house i (plus best up to i - 2) or skip it (best up to i - 1)
            int pick = nums[i];
            int notPick = dp[i - 1];
            if (i > 1) {
                pick = nums[i] + dp[i - 2];
            }

            dp[i] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    /**
     * Finds maximum rob amount using space-optimized approach.
     * 
     * <p>Same recurrence as {@link #rob2(int[])}, but only keeps the last two values instead of the
     * whole DP array: {@code second} holds the best up to house {@code i - 1} and {@code first} the
     * best up to house {@code i - 2}. They start at houses 0 and 1, so the loop begins at house 2.
     * 
     * <p>Time Complexity: O(n) - Single pass
     * <p>Space Complexity: O(1) - Only two variables
     * 
     * @param nums array of money in each house
     * @return maximum amount that can be robbed
     */
    public int rob3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        int pick, notPick, rob;
        for (int i = 2; i < nums.length; i++) {
            pick = nums[i] + first;
            notPick = second;

            rob = Math.max(pick, notPick);

            first = second;
            second = rob;
        }

        return second;
    }

    /**
     * Test driver covering typical and edge cases for all three approaches.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 1},     // houses 0 and 2: 1 + 3
                {2, 7, 9, 3, 1},  // houses 0, 2 and 4: 2 + 9 + 1
                {5},              // a single house
                {2, 1},           // two houses: take the larger
                {1, 2},
                {2, 1, 1, 2},     // houses 0 and 3 are not adjacent: 2 + 2
                {0, 0, 0},        // nothing to rob
                {10, 1, 1, 10},   // skipping two houses in a row can be best
        };
        int[] expected = {4, 12, 5, 2, 2, 4, 0, 20};

        HouseRobber solver = new HouseRobber();
        for (int t = 0; t < inputs.length; t++) {
            int memo = solver.rob(inputs[t]);
            int tab = solver.rob2(inputs[t]);
            int opt = solver.rob3(inputs[t]);
            boolean ok = memo == expected[t] && tab == expected[t] && opt == expected[t];
            System.out.println((ok ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t])
                    + " (expected " + expected[t] + ", memo " + memo + ", tab " + tab + ", opt " + opt + ")");
        }
    }
}
