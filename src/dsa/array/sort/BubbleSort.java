package dsa.array.sort;

import java.util.Arrays;

/**
 * BubbleSort
 * 
 * Bubble sort: repeatedly swaps adjacent out-of-order elements so the largest remaining
 * element "bubbles" to the end of the unsorted part on each pass.
 *
 * <p>An early-exit flag stops the algorithm if a full pass makes no swaps (already sorted).
 *
 * <p>Time complexity: O(n^2) worst/average, O(n) best. Space complexity: O(1). Stable, in-place.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class BubbleSort {
    /**
     * Sorts the array in ascending order in place.
     *
     * @param arr the array to sort
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    isSwapped = true;
                }
            }

            if (!isSwapped) {
                break;
            }
        }
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 4, 1, 5, 3};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
