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
    public static void subsequenceSum(int[] nums, int k) {
        subsequenceSum(nums, k, 0, new ArrayList<>(), 0);
    }

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
        subsequence.remove(subsequence.size() - 1);
        if (subsequenceSum(nums, k, index+1, subsequence, sum)) {
            return true;
        }

        // Neither branch produced a match
        return false;
    }

    public static void main(String[] args) {
        subsequenceSum(new int[]{1, 2, 1}, 2); // prints [1, 1]
    }
}
