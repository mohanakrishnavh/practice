package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * PrintAnySubsequenceWithSumK
 *
 * <p>Prints only the <i>first</i> subsequence found whose sum equals {@code k}, then stops.
 *
 * <p><b>Pattern:</b> pick / not-pick with an early exit. The recursive function returns a
 * {@code boolean}: {@code true} means "solution found, stop exploring". Each caller checks the result and
 * returns {@code true} immediately, which short-circuits all remaining branches.
 *
 * <p><b>Complexity:</b> worst case Time O(2^n) (when no subsequence matches), Space O(n) recursion depth.
 *
 * <p><b>NOTE:</b> when a match is found we return before the {@code remove}, so the list is left
 * "dirty" — fine here because the search is over, but it would be a bug if the list were reused afterwards.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintAnySubsequenceWithSumK {
    /**
     * Public entry point: prints the first subsequence of {@code nums} that adds up to {@code k},
     * or nothing if none exists.
     *
     * @param nums the source array
     * @param k    the target sum
     */
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

    /**
     * Pick / not-pick recursion with an early exit: stops exploring as soon as one match is printed.
     *
     * @param nums        the source array
     * @param k           the target sum
     * @param index       the element currently being decided; start with 0
     * @param subsequence the elements picked so far
     * @param sum         the sum of the picked elements; start with 0
     * @return {@code true} if a matching subsequence was found and printed, so callers can stop searching
     */
    private static boolean subsequenceSum(int[] nums, int k, int index, List<Integer> subsequence, int sum) {
        if (index == nums.length) {
            // condition is satisfied
            if (sum == k) {
                System.out.println(subsequence);
                return true;
            }

            // condition is not satisfied
            return false;
        }

        // Pick: if this branch finds an answer, propagate "found" upward without exploring more
        subsequence.add(nums[index]);
        if (subsequenceSum(nums, k, index+1, subsequence, sum + nums[index])) {
            return true;
        }

        // Backtrack, then try not picking
        subsequence.removeLast();
        if (subsequenceSum(nums, k, index+1, subsequence, sum)) {
            return true;
        }

        // Neither branch produced a match
        return false;
    }

    /**
     * Demo: runs matching, no-match, empty-target and negative-number cases.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("{1, 2, 1}, k=2:");
        subsequenceSum(new int[]{1, 2, 1}, 2);   // [1, 1] (found first; [2] is never printed)

        System.out.println("{1, 2, 3}, k=10:");
        subsequenceSum(new int[]{1, 2, 3}, 10);  // nothing printed (no match)

        System.out.println("{1, 2, 3}, k=0:");
        subsequenceSum(new int[]{1, 2, 3}, 0);   // [] (empty subsequence)

        System.out.println("{5, -2, 3}, k=3:");
        subsequenceSum(new int[]{5, -2, 3}, 3);  // [5, -2] (found first; [3] is never printed)
    }
}
