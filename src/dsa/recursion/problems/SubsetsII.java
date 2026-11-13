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
 * <p><b>NOTE:</b> {@code subsets} sorts the caller's array in place. {@code main} is empty — no demo yet.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SubsetsII {
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        // Sorting groups duplicates together so they can be detected as neighbours
        Arrays.sort(arr);
        findSubsets(0, arr, new ArrayList<>(), result);

        return result;
    }

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
            subset.remove(subset.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {

    }
}
