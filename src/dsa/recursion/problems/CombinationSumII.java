package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CombinationSumII
 *
 * <p>Finds all unique combinations that add up to {@code target}, where each candidate may be used
 * <b>at most once</b> and the input may contain duplicates (LeetCode 40).
 *
 * <p><b>Idea:</b> sort, then use the for-loop form of backtracking:
 * <ul>
 *   <li>Recurse with {@code i + 1} so an element is not reused.</li>
 *   <li>Skip an element equal to its predecessor at the same level ({@code i > index && same value}) to
 *       avoid duplicate combinations.</li>
 *   <li>Because the array is sorted, once {@code candidates[i] > target} every later one is too, so {@code break}
 *       prunes the whole rest of the loop.</li>
 * </ul>
 *
 * <p><b>Complexity:</b> Time O(2^n * k) worst case, Space O(n) recursion depth (excluding output).
 *
 * <p><b>NOTE:</b> sorts the caller's array in place.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        // The combinations are in sorted order. This will also help us avoid duplicate candidates
        Arrays.sort(candidates);
        findCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        return combinations;
    }

    private static void findCombinations(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        // Base case: target reached exactly -> record a copy of the current combination
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates at the same level so the same combination isn't produced twice
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            // Sorted input: this and all following candidates are too large -> stop the loop
            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            // i + 1: each element can be used only once
            findCombinations(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)); // [[1,1,6], [1,2,5], [1,7], [2,6]]
    }
}
