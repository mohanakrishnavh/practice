package dsa.sort;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] A, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = A[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = A[i];
        }
        sort(l, mid);
        sort(r, n - mid);

        merge(A, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{5, 1, 6, 2, 3, 4};
        MergeSort.sort(A, 6);
        System.out.println(Arrays.toString(A));
    }
}
