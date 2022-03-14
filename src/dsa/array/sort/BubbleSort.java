package dsa.array.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    swapped = true;
                }
            }

            // In a pass if no elements are swapped, the array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 7, 4, 1, 5, 3};
        BubbleSort.sort(A);
        System.out.println(Arrays.toString(A));
    }
}
