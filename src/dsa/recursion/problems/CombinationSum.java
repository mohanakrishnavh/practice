package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinations(candidates, target, 0, new ArrayList<>(), combinations);

        return combinations;
    }

    private static void findCombinations(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> combinations) {
        if (index == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            }

            return;
        }

        // Pick the element at the current index (only if it is left that or equal to current target value)
        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            findCombinations(candidates, target - candidates[index], index, combination, combinations);
            combination.remove(combination.size() - 1);
        }

        // Do not pick element at the current index
        findCombinations(candidates, target, index + 1, combination, combinations);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
