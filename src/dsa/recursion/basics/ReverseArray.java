package dsa.recursion.basics;

/**
 * ReverseArray
 *
 * <p>Reverses an array in place using the two-pointer idea expressed recursively.
 *
 * <p><b>Idea:</b> swap {@code arr[i]} with its mirror {@code arr[length - i - 1]}, then recurse on
 * {@code i + 1}. Only half of the array needs swapping, hence the {@code length / 2} stop.
 * A single index suffices because the right pointer is derived from {@code i}.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack (n/2 frames); the array itself is modified in place.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReverseArray {
    /**
     * Public entry point: starts swapping from the outermost pair.
     *
     * @param arr the array to reverse in place
     */
    public static void reverse(int[] arr) {
        reverse(arr, 0);
    }

    /**
     * Swaps {@code arr[i]} with its mirror element, then recurses on the next pair inward.
     *
     * @param arr the array being reversed in place
     * @param i   index of the left element of the current pair; start with 0
     */
    private static void reverse(int[] arr, int i) {
        // Base case: the two pointers have met/crossed, everything is swapped
        if (i >= arr.length/2) {
            return;
        }

        swap(arr, i, arr.length - i - 1);
        reverse(arr, i + 1);
    }

    /**
     * Swaps the elements at two indices.
     *
     * @param arr   the array containing both elements
     * @param left  index of the first element
     * @param right index of the second element
     */
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /**
     * Demo: reverses {1, 2, 3, 4, 5} and prints it.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverse(arr);

        for (int i : arr) {
            System.out.print(i + " "); // 5 4 3 2 1
        }
    }
}
