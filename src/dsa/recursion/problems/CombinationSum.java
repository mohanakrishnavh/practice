package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * CombinationSum
 *
 * <p>Finds all unique combinations of candidates that add up to {@code target}, where each candidate
 * may be used <b>unlimited times</b> (LeetCode 39). Candidates are distinct.
 *
 * <p><b>Idea:</b> pick / not-pick with one twist — after picking {@code candidates[index]} we recurse with the
 * <i>same</i> index (so it can be picked again); only the "not pick" branch advances the index. This also
 * guarantees each combination is generated in one fixed order, so no duplicates appear.
 *
 * <p><b>Complexity:</b> Time roughly O(2^t * k) where t = target / min(candidate) and k = average combination length;
 * Space O(t) recursion depth (excluding output).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CombinationSum {
    /**
     * Public entry point: finds all unique combinations of {@code candidates} that sum to {@code target},
     * where each candidate may be reused any number of times.
     *
     * @param candidates distinct positive integers to choose from
     * @param target     the sum each combination must reach
     * @return every combination that sums to {@code target} (empty list if none)
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        return combinations;
    }

    /**
     * Pick / not-pick backtracking. Picking keeps the same index (reuse allowed); not picking advances it.
     *
     * @param candidates   the candidate values
     * @param target       the amount still needed to reach the original target
     * @param index        the candidate currently being considered; start with 0
     * @param combination  the values picked so far (restored while backtracking)
     * @param combinations collects a copy of each valid combination
     */
    private static void findCombinations(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
        // Base case: ran out of candidates; keep the path only if the target was reached exactly
        if (index == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination)); // copy, since `combination` is reused
            }

            return;
        }

        // Pick the element at the current index (only if it is left that or equal to current target value)
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            // Same index: the element can be reused
            findCombinations(candidates, target - candidates[index], index, combination, combinations);
            combination.removeLast(); // backtrack
        }

        // Do not pick element at the current index
        findCombinations(candidates, target, index + 1, combination, combinations);
    }

    /**
     * Demo: runs typical, reuse-heavy, no-match and single-candidate cases.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));    // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        System.out.println(combinationSum(new int[]{2}, 1));          // [] (target smaller than any candidate)
        System.out.println(combinationSum(new int[]{2}, 6));          // [[2, 2, 2]] (one candidate reused)
        System.out.println(combinationSum(new int[]{1}, 3));          // [[1, 1, 1]]
    }
}
