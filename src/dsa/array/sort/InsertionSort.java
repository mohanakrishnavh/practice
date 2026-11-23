package dsa.array.sort;

/**
 * InsertionSort
 * 
 * Insertion sort: builds a sorted prefix one element at a time by moving each new element
 * left (via adjacent swaps) until it sits in its correct position.
 *
 * <p>Time complexity: O(n^2) worst/average, O(n) best (already sorted). Space complexity: O(1). Stable, in-place.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class InsertionSort {

    /**
     * Sorts the array in ascending order in place.
     *
     * @param arr the array to sort
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }

    /**
     * Entry point (currently empty).
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){

    }
}
