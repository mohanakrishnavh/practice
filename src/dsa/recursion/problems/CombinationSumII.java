package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CombinationSumII
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
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
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            findCombinations(candidates, target - candidates[i], i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
