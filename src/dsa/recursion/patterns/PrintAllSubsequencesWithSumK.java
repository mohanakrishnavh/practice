package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * PrintAllSubsequencesWithSumK
 *
 * <p>Prints every subsequence whose elements add up to {@code k}.
 *
 * <p><b>Pattern:</b> pick / not-pick (see {@link PrintAllSubsequences}) plus a running {@code sum}
 * that is checked at the leaf. The public method hides the extra bookkeeping parameters
 * (index, current subsequence, sum) from callers.
 *
 * <p><b>Complexity:</b> Time O(2^n * n), Space O(n) recursion depth.
 *
 * <p><b>NOTE:</b> only checking at the leaf keeps the code simple; if all values are non-negative you can
 * prune early when {@code sum > k}. That is not valid if negatives are allowed.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintAllSubsequencesWithSumK {
    /**
     * Public entry point: prints every subsequence of {@code nums} whose elements add up to {@code k}.
     *
     * @param nums the source array
     * @param k    the target sum
     */
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    /**
     * Pick / not-pick recursion that checks the running sum at each leaf.
     *
     * @param nums        the source array
     * @param k           the target sum
     * @param index       the element currently being decided; start with 0
     * @param subsequence the elements picked so far (restored while backtracking)
     * @param sum         the sum of {@code subsequence}; start with 0
     */
    private static void subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        // Base case: all elements decided; print only if the target is met
        if (index == nums.length) {
            if (sum == k) {
                System.out.println(subsequence);
            }

            return;
        }

        // Pick nums[index]: add to the list and to the running sum
        subsequence.add(nums[index]);
        subsequenceSum(nums, k, index+1, subsequence, sum + nums[index]);

        // Backtrack, then do not pick nums[index]
        subsequence.removeLast();
        subsequenceSum(nums, k, index+1, subsequence, sum);
    }

    /**
     * Demo: runs matching, non-matching, empty-target and negative-number cases.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("{1, 2, 1}, k=2:");
        subsequenceSum(new int[]{1, 2, 1}, 2);   // [1, 1] and [2]

        System.out.println("{1, 2, 3}, k=10:");
        subsequenceSum(new int[]{1, 2, 3}, 10);  // nothing printed (no match)

        System.out.println("{1, 2, 3}, k=0:");
        subsequenceSum(new int[]{1, 2, 3}, 0);   // [] (the empty subsequence sums to 0)

        System.out.println("{5, -2, 3}, k=3:");
        subsequenceSum(new int[]{5, -2, 3}, 3);  // [5, -2] and [3] (negatives work: no early pruning)
    }
}
