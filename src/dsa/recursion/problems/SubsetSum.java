package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SubsetSum
 *
 * <p>Returns the sum of every subset of the array, in ascending order (the "Subset Sums" problem).
 *
 * <p><b>Pattern:</b> pick / not-pick carrying a running {@code sum}. At the leaf the accumulated sum is
 * recorded; there are 2^n leaves so the result has 2^n entries (duplicates are kept).
 * No backtracking undo is needed because the sum is passed by value.
 *
 * <p><b>Complexity:</b> Time O(2^n + 2^n log 2^n) (generate + sort), Space O(2^n) for the result plus O(n) stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SubsetSum {
    /**
     * Public entry point: computes the sum of every subset of {@code arr}.
     *
     * @param arr the source array
     * @return the 2^n subset sums in ascending order (duplicates kept; the empty subset contributes 0)
     */
    public static List<Integer> subsetSums(int[] arr){
        ArrayList<Integer> sums = new ArrayList<>();
        findSubsetSums(0, 0, arr, sums);
        Collections.sort(sums);

        return sums;
    }

    /**
     * Pick / not-pick recursion that carries the running sum and records it at each leaf.
     *
     * @param index the element currently being decided; start with 0
     * @param sum   the sum of the elements picked so far; start with 0
     * @param arr   the source array
     * @param sums  collects the total of every completed path
     */
    private static void findSubsetSums(int index, int sum, int[] arr, List<Integer> sums) {
        // Base case: all elements decided -> this path's total is one subset sum
        if (arr.length == index) {
            sums.add(sum);
            return;
        }

        // Pick the index element
        findSubsetSums(index + 1, sum + arr[index], arr, sums);

        // Do not pick the index element
        findSubsetSums(index + 1, sum, arr, sums);
    }

    /**
     * Demo: prints subset sums for typical, empty, single-element, duplicate and negative inputs.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(subsetSums(new int[]{2, 3}));    // [0, 2, 3, 5]
        System.out.println(subsetSums(new int[]{3, 1, 2})); // [0, 1, 2, 3, 3, 4, 5, 6]
        System.out.println(subsetSums(new int[]{}));        // [0] (only the empty subset)
        System.out.println(subsetSums(new int[]{5}));       // [0, 5]
        System.out.println(subsetSums(new int[]{1, 1}));    // [0, 1, 1, 2] (duplicates kept)
        System.out.println(subsetSums(new int[]{-1, 2}));   // [-1, 0, 1, 2]
    }
}
