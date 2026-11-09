package dsa.search;

/**
 * SingleElementInSortedArray
 *
 * <p>In a sorted array where every value appears exactly twice except one that appears once, finds the single
 * value in O(log n) (LeetCode 540). Example: {@code [1, 1, 2, 3, 3, 4, 4, 8, 8]} → 2.
 *
 * <p><b>Key observation (index parity):</b> before the single element, each pair starts at an <i>even</i> index
 * ({@code arr[0]==arr[1]}, {@code arr[2]==arr[3]}, ...). The single element shifts everything after it by one, so
 * after it each pair starts at an <i>odd</i> index. So at any {@code mid}, the pairing parity tells which side the single
 * element is on:
 * <ul>
 *   <li>{@code mid} is odd and equals its <i>left</i> neighbour, or {@code mid} is even and equals its <i>right</i>
 *       neighbour → the pairs are still "even-aligned", so the single element is to the right.</li>
 *   <li>otherwise the alignment has already flipped, so the single element is at {@code mid} or to the left.</li>
 * </ul>
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>NOTE:</b> assumes the input is sorted and really has exactly one unpaired value (so the length is odd);
 * otherwise the loop can end and return -1.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SingleElementInSortedArray {
    /**
     * Returns the one value that does not have a duplicate.
     *
     * @param arr sorted array in which every value appears twice except exactly one
     * @return the single value, or -1 if the input does not satisfy the assumptions
     */
    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        // If there is only one element in the array
        if (n == 1) {
            return arr[0];
        }

        // If the first element is the single element
        if (arr[0] != arr[1]) {
            return arr[0];
        }

        // If the last element is the single element
        if (arr[n - 2] != arr[n - 1]) {
            return arr[n - 1];
        }

        // The two ends are handled above, so mid always has both neighbours: search [1, n - 2]
        int low = 1, high = n - 2;
        while (low <= high) {
            // Overflow-safe midpoint
            int mid = low + (high - low) / 2;

            // Found the Single Element: it differs from both neighbours
            if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // Eliminating half of the search space
            // Checking if we are in the left half
            // (pairs still start at even indices -> the single element is on the right)
            if ((mid % 2 == 1 && arr[mid - 1] == arr[mid]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})); // 2
    }
}
