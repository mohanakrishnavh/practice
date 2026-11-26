package dsa.dynamicprogramming.onedimentionalarray;

import java.util.Arrays;

/**
 * House Robber II Problem.
 * 
 * <p>Extension of {@link HouseRobber} where all houses are arranged in a circle.
 * This means the first and last houses are adjacent, so you cannot rob both.
 * 
 * <p><b>Idea:</b> any valid plan leaves out the first house or the last house (or both). So break
 * the circle into two straight streets and solve each with the House Robber recurrence
 * {@code best(i) = max(best(i - 1), nums[i] + best(i - 2))}:
 * <ul>
 *   <li>Case 1: houses {@code 0..n-2} (exclude the last house)</li>
 *   <li>Case 2: houses {@code 1..n-1} (exclude the first house)</li>
 * </ul>
 * The answer is the larger of the two. Each street uses the space-optimized version, keeping only
 * the last two values.
 * 
 * <p>Time Complexity: O(n) - Two passes through array
 * <p>Space Complexity: O(1) - Only constant space
 * 
 * <p>Example: For [2, 3, 2], houses 0 and 2 are adjacent in the circle, so the best is to rob only
 * house 1: max = 3.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class HouseRobberII {

    /**
     * Finds the maximum amount that can be robbed from houses arranged in a circle.
     * 
     * <p>Handles the empty and single-house cases directly (a single house has no neighbour), then
     * returns the better of robbing without the last house and robbing without the first house.
     * 
     * @param nums array of money in each house
     * @return maximum amount that can be robbed without robbing two adjacent houses
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // houses 0..n-2 and houses 1..n-1: neither range contains both ends of the circle
        int maxExcludingLast = rob(nums, 0, nums.length - 1);
        int maxIncludingFirst = rob(nums, 1, nums.length);

        return Math.max(maxExcludingLast, maxIncludingFirst);
    }

    /**
     * Space-optimized House Robber on the straight street {@code nums[start..end-1]}.
     * 
     * <p>{@code second} holds the best up to house {@code i - 1} and {@code first} the best up to
     * house {@code i - 2}. They start at the first two houses of the range, so the loop begins at
     * {@code start + 2}.
     * 
     * @param nums  array of money in each house
     * @param start first house in the range (inclusive)
     * @param end   end of the range (exclusive); the range must contain at least one house
     * @return maximum amount that can be robbed from {@code nums[start..end-1]}
     */
    private int rob(int[] nums, int start, int end) {
        // a single house in the range: rob it
        if (end - start < 2) {
            return nums[start];
        }

        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        int pick, notPick, rob;
        for (int i = start + 2; i < end; i++) {
            pick = nums[i] + first;
            notPick = second;

            rob = Math.max(pick, notPick);

            first = second;
            second = rob;
        }

        return second;
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[][] inputs = {
                {2, 3, 2},             // houses 0 and 2 are adjacent in the circle: only house 1
                {1, 2, 3, 1},          // houses 0 and 2: 1 + 3
                {1, 2, 3},             // house 2 alone beats houses 0 + 2, which are adjacent
                {2, 7, 9, 3, 1},       // 2 + 9 is best; 2 + 9 + 1 is not allowed in a circle
                {200, 3, 140, 20, 10}, // houses 0 and 2: 200 + 140
                {1, 3, 1, 3, 100},     // excluding the first house: 3 + 100
                {5},                   // a single house has no neighbour
                {1, 2},                // two houses are adjacent: take the larger
                {2, 1},
                {},                    // no houses
        };
        int[] expected = {3, 4, 3, 11, 340, 103, 5, 2, 2, 0};

        HouseRobberII solver = new HouseRobberII();
        for (int t = 0; t < inputs.length; t++) {
            int result = solver.rob(inputs[t]);
            System.out.println((result == expected[t] ? "PASS" : "FAIL") + " - " + Arrays.toString(inputs[t])
                    + " (expected " + expected[t] + ", got " + result + ")");
        }
    }
}
