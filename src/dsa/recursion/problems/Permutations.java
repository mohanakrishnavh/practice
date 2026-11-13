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
    public static List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[arr.length];

        permute(arr, new ArrayList<>(), permutations, used);
        return permutations;
    }

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
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
    }

    // Approach 2 : Swapping all elements for an index
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        findPermutations(0, nums, permutations);

        return permutations;
    }

    private static void findPermutations(int index, int[] nums, List<List<Integer>> permutations) {
        // Base case: positions 0..n-1 are all fixed; the array itself is one permutation
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                permutation.add(nums[i]);
            }

            permutations.add(permutation);
            return;
        }

        // Try each remaining element (i >= index) in position `index`
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            findPermutations(index+1, nums, permutations);
            swap(nums, i, index); // backtrack: undo the swap
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1, 2, 3}));
        System.out.println(permute2(new int[] {1, 2, 3}));
    }
}
