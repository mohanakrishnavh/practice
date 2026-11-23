package dsa.array.sort;

import java.util.Arrays;

/**
 * MergeSort
 * 
 * Merge sort: a divide-and-conquer algorithm that splits the array in half, recursively sorts
 * each half and merges the two sorted halves.
 *
 * <p>Time complexity: O(n log n) in all cases. Space complexity: O(n) for the temporary halves. Stable.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MergeSort {
    /**
     * Sorts the array in ascending order in place by recursively splitting and merging.
     *
     * @param A the array to sort
     */
    public static void mergeSort(int[] A) {
        int n = A.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = A[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(A, left, right);
    }

    /**
     * Merges two sorted arrays into {@code A}. The left element is taken on ties, keeping the sort stable.
     *
     * @param A     destination array; its length must equal {@code left.length + right.length}
     * @param left  sorted left half
     * @param right sorted right half
     */
    public static void merge(int[] A, int[] left, int[] right) {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;

        while (i < nL && j < nR) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }

        while (i < nL) {
            A[k++] = left[i++];
        }

        while (j < nR) {
            A[k++] = right[j++];
        }
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 6, 2, 3, 4};
        mergeSort(A);
        System.out.println(Arrays.toString(A));
    }
}
