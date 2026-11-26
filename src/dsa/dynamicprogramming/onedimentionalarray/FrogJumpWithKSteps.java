package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * Frog Jump with K Steps Problem.
 * 
 * <p>Extension of {@link FrogJump}: a frog starts on stone 0 and wants to reach the last stone.
 * From stone {@code i} it can jump to any of stones {@code i + 1} to {@code i + k} (instead of just
 * 1 or 2 steps ahead), and each jump costs the absolute difference in height between the two
 * stones. Find the minimum total cost to reach the last stone.
 * 
 * <p><b>Idea:</b> let {@code dp[i]} be the minimum cost to reach stone {@code i}. The frog lands on
 * stone {@code i} from one of the previous {@code k} stones, so
 * {@code dp[i] = min over j in 1..k, i - j >= 0 of (dp[i - j] + |h[i] - h[i - j]|)}, with
 * {@code dp[0] = 0}. The answer is {@code dp[n - 1]}. With {@code k = 2} this is exactly {@link FrogJump}.
 *
 * <p>{@link #minimizeCost(int, int, int[])} solves this bottom-up (tabulation) in O(n*k) time and
 * O(n) space.
 * 
 * <p>Example: For heights [10, 30, 40, 50, 20] and k=3, the minimum cost is 30: stone 0 → 1 → 4
 * (heights 10 → 30 → 20, cost 20 + 10).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FrogJumpWithKSteps {

    /**
     * Finds minimum cost using tabulation (Bottom-Up DP).
     *
     * <p>Fills {@code dp} from stone 0 forward. {@code dp} starts at {@code Integer.MAX_VALUE}
     * (not reached yet) except {@code dp[0] = 0}; for each stone, every jump length {@code 1..k} that
     * starts on a valid stone lowers {@code dp[i]} in place if it is cheaper.
     *
     * <p>Time complexity: O(N * K). Space complexity: O(N).
     *
     * @param n       number of stones
     * @param k       maximum number of stones the frog can jump at once
     * @param heights height of each stone
     * @return the minimum total cost to reach stone {@code n - 1} from stone 0
     */
    public int minimizeCost(int n, int k, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                // try every jump length 1..k that lands on a valid stone
                if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(heights[i] - heights[i - j]));
                }
            }
        }

        return dp[n - 1];
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] heights = {
                {10, 30, 40, 50, 20},                      // 0 -> 1 -> 4: 20 + 10
                {10, 20, 10},                              // k = 1 forces every stone: 10 + 10
                {30, 10, 60, 10, 60, 50},                  // k = 2 is the classic Frog Jump
                {40, 10, 20, 70, 80, 10, 20, 70, 80, 60},  // larger k
                {10},                                      // already on the last stone
                {10, 10, 10, 10},                          // flat stones cost nothing
        };
        int[] ks = {3, 1, 2, 4, 2, 2};
        int[] expected = {30, 20, 40, 40, 0, 0};

        FrogJumpWithKSteps solver = new FrogJumpWithKSteps();
        for (int t = 0; t < heights.length; t++) {
            int result = solver.minimizeCost(heights[t].length, ks[t], heights[t]);
            System.out.println((result == expected[t] ? "PASS" : "FAIL") + " - "
                    + Arrays.toString(heights[t]) + ", k=" + ks[t] + " (expected " + expected[t] + ", got " + result + ")");
        }

        // k larger than the number of stones: the frog can jump straight to the end
        int[] few = {10, 50, 10};
        int result = solver.minimizeCost(few.length, 5, few);
        System.out.println((result == 0 ? "PASS" : "FAIL") + " - " + Arrays.toString(few)
                + ", k=5 (expected 0, got " + result + ")");
    }
}
