package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 *
 * <p>Returns all subsets (the power set) of an array of distinct integers (LeetCode 78).
 *
 * <p><b>Pattern: pick / not-pick.</b> For each index decide to include or exclude the element. When every
 * index has been decided, a <i>copy</i> of the current subset is stored — copying is essential because
 * {@code subset} is mutated and reused by backtracking.
 *
 * <p><b>Complexity:</b> Time O(2^n * n) (copying each subset), Space O(n) recursion depth (excluding output).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Subsets {
    public static List<List<Integer>> findSubsets(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), subsets);

        return subsets;
    }

    private static void findSubsets(int index, int[] arr, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: all elements decided -> record a snapshot of the current subset
        if (index == arr.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Pick the index element
        subset.add(arr[index]);
        findSubsets(index + 1, arr, subset, subsets);
        subset.remove(subset.size()-1); // backtrack

        // Do not pick the index element
        findSubsets(index + 1, arr, subset, subsets);
    }

    public static void main(String[] args) {
        System.out.println(findSubsets(new int[]{2, 3}));
        System.out.println(findSubsets(new int[]{3, 1, 2}));
    }
}
