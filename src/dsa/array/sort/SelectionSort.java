package dsa.array.sort;

import java.util.Arrays;

/**
 * SelectionSort
 * 
 * Selection sort: repeatedly selects the minimum element of the unsorted part and swaps it
 * into the next position of the sorted prefix.
 *
 * <p>Time complexity: O(n^2) in all cases. Space complexity: O(1). In-place, not stable, and performs at most n-1 swaps.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SelectionSort {
    /**
     * Sorts the array in ascending order in place.
     *
     * @param arr the array to sort
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] A = new int[]{2, 7, 4, 1, 5, 3};
        sort(A);
        System.out.println(Arrays.toString(A));
    }
}
