package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * CountAllSubsequenceWithSumK
 *
 * <p>Counts how many subsequences add up to {@code k}.
 *
 * <p><b>Pattern:</b> same pick / not-pick recursion as {@link PrintAllSubsequencesWithSumK}, but the
 * function <i>returns</i> a count instead of printing: a leaf returns 1 (valid) or 0 (invalid), and each
 * node returns {@code left + right}. This "return-and-combine" shape is the stepping stone to DP counting problems.
 *
 * <p><b>Complexity:</b> Time O(2^n), Space O(n) recursion depth.
 *
 * <p><b>NOTE:</b> the {@code subsequence} list is only needed for debugging output (see the commented-out print);
 * the count itself depends only on {@code index} and {@code sum}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CountAllSubsequenceWithSumK {
    /**
     * Public entry point: counts the subsequences of {@code nums} whose elements add up to {@code k}.
     *
     * @param nums the source array
     * @param k    the target sum
     * @return the number of matching subsequences
     */
    public static int subsequenceSum(int[] nums, int k) {
        return subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    /**
     * Pick / not-pick recursion that returns a count: a leaf gives 1 (sum matches) or 0, and each
     * node returns the sum of its two branches.
     *
     * @param nums        the source array
     * @param k           the target sum
     * @param index       the element currently being decided; start with 0
     * @param subsequence the elements picked so far (debug only; restored while backtracking)
     * @param sum         the sum of the picked elements; start with 0
     * @return the number of matching subsequences reachable from this state
     */
    private static int subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            // condition is satisfied
            if (sum == k) {
                //System.out.println(subsequence);
                return 1;
            }

            // condition is not satisfied
            return 0;
        }

        // Pick: count of valid subsequences that include nums[index]
        subsequence.add(nums[index]);
        int left = subsequenceSum(nums, k, index+1, subsequence, sum + nums[index]);

        // Not pick: count of valid subsequences that exclude nums[index]
        subsequence.removeLast();
        int right = subsequenceSum(nums, k, index+1, subsequence, sum);

        // Total = both branches
        return left + right;
    }

    /**
     * Demo: counts matches for typical, no-match, empty-target, empty-array and negative-number cases.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(subsequenceSum(new int[]{1, 2, 1}, 2));  // 2  ([1, 1] and [2])
        System.out.println(subsequenceSum(new int[]{1, 2, 3}, 10)); // 0  (no match)
        System.out.println(subsequenceSum(new int[]{1, 2, 3}, 0));  // 1  (only the empty subsequence)
        System.out.println(subsequenceSum(new int[]{}, 0));         // 1  (empty array, empty subsequence)
        System.out.println(subsequenceSum(new int[]{1, 1, 1}, 2));  // 3  (three ways to choose two 1s)
        System.out.println(subsequenceSum(new int[]{5, -2, 3}, 3)); // 2  ([5, -2] and [3])
    }
}
