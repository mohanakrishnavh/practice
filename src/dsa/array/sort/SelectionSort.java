package dsa.array.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 7, 4, 1, 5, 3};
        sort(A);
        System.out.println(Arrays.toString(A));
    }
}
