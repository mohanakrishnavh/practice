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
    /**
     * Public entry point: generates every subset (the power set) of {@code arr}.
     *
     * @param arr the source array
     * @return all 2^n subsets, each as its own list
     */
    public static List<List<Integer>> findSubsets(int[] arr){
        List<List<Integer>> subsets = new ArrayList<>();
        findSubsets(0, arr, new ArrayList<>(), subsets);

        return subsets;
    }

    /**
     * Pick / not-pick backtracking that records a snapshot of the subset at each leaf.
     *
     * @param idx  the element currently being decided; start with 0
     * @param arr    the source array
     * @param subset the elements picked so far (restored while backtracking)
     * @param subsets collects a copy of every completed subset
     */
    private static void findSubsets(int idx, int[] arr, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: all elements decided -> record a snapshot of the current subset
        if (idx == arr.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        // Pick the idx element
        subset.add(arr[idx]);
        findSubsets(idx + 1, arr, subset, subsets);
        subset.removeLast(); // backtrack

        // Do not pick the idx element
        findSubsets(idx + 1, arr, subset, subsets);
    }

    /**
     * Demo: prints the power set for typical, empty, single-element and duplicate-value inputs.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(findSubsets(new int[]{2, 3}));    // [[2, 3], [2], [3], []]
        System.out.println(findSubsets(new int[]{3, 1, 2})); // 8 subsets
        System.out.println(findSubsets(new int[]{}));        // [[]] (just the empty subset)
        System.out.println(findSubsets(new int[]{7}));       // [[7], []]
        System.out.println(findSubsets(new int[]{1, 1}));    // [[1, 1], [1], [1], []] (duplicates are not merged)
    }
}
