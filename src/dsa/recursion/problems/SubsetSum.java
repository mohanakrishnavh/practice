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
    public static List<Integer> subsetSums(int[] arr){
        ArrayList<Integer> sums = new ArrayList<>();
        findSubsetSums(0, 0, arr, sums);
        Collections.sort(sums);

        return sums;
    }

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

    public static void main(String[] args) {
        System.out.println(subsetSums(new int[]{2, 3}));    // [0, 2, 3, 5]
        System.out.println(subsetSums(new int[]{3, 1, 2})); // [0, 1, 2, 3, 3, 4, 5, 6]
    }
}
