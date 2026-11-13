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
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        return combinations;
    }

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
            combination.remove(combination.size() - 1); // backtrack
        }

        // Do not pick element at the current index
        findCombinations(candidates, target, index + 1, combination, combinations);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2, 2, 3], [7]]
    }
}
