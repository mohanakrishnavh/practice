package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * SubsetsII
 *
 * <p>Returns all <i>unique</i> subsets of an array that may contain duplicates (LeetCode 90).
 *
 * <p><b>Idea:</b> sort first so equal values are adjacent, then use the "for-loop" form of subset generation:
 * every recursive call records the current subset, then tries adding each later element in turn.
 * To avoid duplicates, at a given recursion level skip an element that equals its predecessor
 * ({@code i != index && arr[i] == arr[i-1]}) — the first copy at that level already covers those subsets.
 *
 * <p><b>Complexity:</b> Time O(2^n * n), Space O(n) recursion depth (excluding output).
 *
 * <p><b>NOTE:</b> {@code subsets} sorts the caller's array in place.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SubsetsII {
    /**
     * Public entry point: generates every unique subset of {@code arr}, which may contain duplicates.
     *
     * @param arr the source array (sorted in place)
     * @return all unique subsets, including the empty one
     */
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting groups duplicates together so they can be detected as neighbours
        Arrays.sort(arr);
        findSubsets(0, arr, new ArrayList<>(), result);

        return result;
    }

    /**
     * For-loop style backtracking: records the current subset, then extends it with each later element,
     * skipping a value equal to its predecessor at the same level to avoid duplicate subsets.
     *
     * @param index  the first position that may be added next; start with 0
     * @param arr    the sorted source array
     * @param subset the elements picked so far (restored while backtracking)
     * @param result collects a copy of every unique subset
     */
    private static void findSubsets(int index, int[] arr, List<Integer> subset, List<List<Integer>> result) {
        // Every node of the recursion tree is itself a valid subset
        result.add(new ArrayList<>(subset));

        for (int i = index; i < arr.length; i++) {
            // Skip duplicates at the same level (but allow a duplicate deeper, where i == index)
            if (i != index && arr[i] == arr[i-1]) {
                continue;
            }

            subset.add(arr[i]);
            findSubsets(i+1, arr, subset, result);
            subset.removeLast();
        }
    }

    /**
     * Demo: prints unique subsets for typical, all-equal, empty, single-element and unsorted inputs.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2}));    // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
//        System.out.println(subsets(new int[]{1, 1, 1}));    // [[], [1], [1, 1], [1, 1, 1]]
//        System.out.println(subsets(new int[]{}));           // [[]]
//        System.out.println(subsets(new int[]{0}));          // [[], [0]]
//        System.out.println(subsets(new int[]{4, 1, 4}));    // unsorted input: [[], [1], [1, 4], [1, 4, 4], [4], [4, 4]]
    }
}
