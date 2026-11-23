package dsa.greedy;

/**
 * JumpGame
 *
 * Determines whether the last index of an array can be reached by jumping (LeetCode 55).
 *
 * <p>Problem: You start at index 0, and {@code nums[i]} is the maximum jump length from
 * index {@code i}. Return true if you can reach the last index.
 *
 * <p>Example: {@code [2,3,1,1,4]} is reachable; {@code [3,2,1,0,4]} is not, because every path
 * gets stuck at index 3 (jump length 0).
 *
 * <p>Approach (greedy): Track the farthest index reachable so far. Scan left to right; if the
 * current index is beyond that farthest point it is unreachable, so the end cannot be reached.
 * Otherwise extend the farthest point using {@code i + nums[i]}.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class JumpGame {

    /**
     * Returns whether the last index is reachable from index 0.
     *
     * @param nums the maximum jump length at each index
     * @return true if the last index can be reached (also true for an empty array
     * or a single element), false otherwise
     */
    public boolean canJump(int[] nums) {
        // maxIdx = farthest index reachable so far; jumpIdx = farthest index reachable from i
        int maxIdx = 0, jumpIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            // Stuck: index i cannot be reached by any earlier jump
            if (i > maxIdx) {
                return false;
            }

            jumpIdx = i + nums[i];
            maxIdx = Math.max(maxIdx, jumpIdx);

            // Can land exactly on the last index: done early
            if (jumpIdx == nums.length - 1) {
                return true;
            }
        }

        // Every index was reachable, including the last one
        return true;
    }

    /**
     * Runs one test case and prints PASS or FAIL.
     *
     * @param name     a short description of the case
     * @param nums     the maximum jump length at each index
     * @param expected whether the last index should be reachable
     */
    private static void check(String name, int[] nums, boolean expected) {
        boolean actual = new JumpGame().canJump(nums);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        check("reachable [2,3,1,1,4]", new int[]{2, 3, 1, 1, 4}, true);
        check("stuck at the zero [3,2,1,0,4]", new int[]{3, 2, 1, 0, 4}, false);
        check("single element", new int[]{0}, true);
        check("empty array", new int[]{}, true);
        check("zero at start, more elements", new int[]{0, 1}, false);
        check("exact jump to last index", new int[]{1, 0}, true);
        check("jump overshoots the end", new int[]{5, 0, 0, 0}, true);
        check("zeros skipped by a big jump", new int[]{2, 0, 0}, true);
        check("blocked before the end", new int[]{1, 1, 0, 1}, false);
        check("all ones", new int[]{1, 1, 1, 1}, true);
        check("first index cannot move", new int[]{0, 2, 3}, false);
    }
}
