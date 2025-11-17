package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
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
        if (permutation.size() == arr.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(arr[i]);
                permute(arr, permutation, permutations, used);
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
        if (index == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                permutation.add(nums[i]);
            }

            permutations.add(permutation);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            findPermutations(index+1, nums, permutations);
            swap(nums, i, index);
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
