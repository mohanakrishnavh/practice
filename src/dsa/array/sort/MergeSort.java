package dsa.array.sort;

import java.util.Arrays;

public class MergeSort {
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

    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 6, 2, 3, 4};
        mergeSort(A);
        System.out.println(Arrays.toString(A));
    }
}
