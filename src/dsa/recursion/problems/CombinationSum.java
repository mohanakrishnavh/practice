package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> result) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if (candidates[index] <= target) {
            combination.add(candidates[index]);
            combinationSum(candidates, target - candidates[index], index, combination, result);
            combination.remove(combination.size() - 1);
        }

        combinationSum(candidates, target, index + 1, combination, result);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
