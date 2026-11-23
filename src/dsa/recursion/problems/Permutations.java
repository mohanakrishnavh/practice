package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 *
 * <p>Generates all permutations of an array of distinct integers (LeetCode 46). Two approaches:
 * <ol>
 *   <li><b>Used-array:</b> build a permutation slot by slot, trying every unused element for each slot.</li>
 *   <li><b>Swapping:</b> fix position {@code index} by swapping each later element into it, recurse on
 *       {@code index + 1}, then swap back. Uses no extra {@code used} array or temporary list.</li>
 * </ol>
 *
 * <p><b>Complexity (both):</b> Time O(n! * n), Space O(n) recursion depth (approach 1 also O(n) for {@code used}).
 *
 * <p><b>NOTE:</b> approaches produce the same set but in a different order; the swap version mutates
 * {@code nums} during the search but restores it before returning.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Permutations {
    // Approach 1: Using used map/array to keep of elements that has been picked
    /**
     * Approach 1 entry point: generates all permutations using a {@code used} array.
     *
     * @param arr distinct integers to permute
     * @return all n! permutations
     */
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        permute(arr, new ArrayList<>(), permutations, used);
        return permutations;
    }

    /**
     * Fills the next slot with each unused element in turn, recursing until every slot is filled.
     *
     * @param arr          the source elements
     * @param permutation  the elements placed so far (restored while backtracking)
     * @param permutations collects a copy of each completed permutation
     * @param used         {@code used[i]} is true while {@code arr[i]} is in {@code permutation}
     */
    private static void permute(int[] arr, List<Integer> permutation, List<List<Integer>> permutations, boolean[] used) {
        // Base case: every slot filled -> store a copy
        if (permutation.size() == arr.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // Only use elements not already in the current permutation
            if (!used[i]) {
                used[i] = true;
                permutation.add(arr[i]);
                permute(arr, permutation, permutations, used);
                // Backtrack: free the element for other positions/branches
                permutation.removeLast();
                used[i] = false;
            }
        }
    }

    // Approach 2 : Swapping all elements for an index
    /**
     * Approach 2 entry point: generates all permutations by swapping elements into each position.
     *
     * @param nums distinct integers to permute (restored to its original order before returning)
     * @return all n! permutations
     */
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(0, nums, permutations);

        return permutations;
    }

    /**
     * Fixes position {@code idx} by swapping each later element into it, recursing, then swapping back.
     *
     * @param idx        the position being fixed; start with 0
     * @param nums         the array being permuted in place
     * @param permutations collects a snapshot of {@code nums} at each leaf
     */
    private static void findPermutations(int idx, int[] nums, List<List<Integer>> permutations) {
        // Base case: positions 0..n-1 are all fixed; the array itself is one permutation
        if (idx == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                permutation.add(nums[i]);
            }

            permutations.add(permutation);
            return;
        }

        // Try each remaining element (i >= idx) in position `idx`
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            findPermutations(idx+1, nums, permutations);
            swap(nums, i, idx); // backtrack: undo the swap
        }
    }

    /**
     * Swaps the elements at two indices.
     *
     * @param nums the array containing both elements
     * @param i    index of the first element
     * @param j    index of the second element
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Demo: prints permutations with both approaches for typical, empty, single-element and two-element inputs.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1, 2, 3}));
        System.out.println(permute2(new int[] {1, 2, 3}));
        System.out.println(permute(new int[] {}));       // [[]] (one permutation: the empty one)
        System.out.println(permute2(new int[] {}));      // [[]]
        System.out.println(permute(new int[] {5}));      // [[5]]
        System.out.println(permute2(new int[] {5}));     // [[5]]
        System.out.println(permute(new int[] {1, 2}));   // [[1, 2], [2, 1]]
        System.out.println(permute2(new int[] {1, 2}));  // [[1, 2], [2, 1]]
        System.out.println(permute(new int[] {1, 2, 3, 4}).size());  // 24 (4!)
        System.out.println(permute2(new int[] {1, 2, 3, 4}).size()); // 24
    }
}
