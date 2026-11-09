package dsa.search;

/**
 * ElementCount
 *
 * <p>Counts how many times a value occurs in a sorted (ascending) array, without scanning the whole array.
 *
 * <p><b>Idea:</b> equal values sit next to each other in a sorted array, so they form one contiguous block.
 * Two binary searches find the block's edges — the first and last index of the value — and the count is
 * {@code last - first + 1}. If the value is absent both searches return -1 and the count is 0.
 *
 * <p><b>Complexity:</b> Time O(log n) (two binary searches) versus O(n) for a linear count, Space O(1).
 *
 * <p><b>NOTE:</b> {@link FirstOccurrenceOfAnElement} and {@link LastOccurrenceOfAnElement} contain the same
 * two searches; they are duplicated here to keep this file self-contained. Calling those classes instead would
 * remove the duplication.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ElementCount {
    /**
     * Returns the index of the first (leftmost) occurrence of {@code x}.
     *
     * <p>On a match it records the index and keeps searching the left half for an earlier duplicate.
     *
     * @param nums array sorted in ascending order (duplicates allowed)
     * @param x    value to find
     * @return smallest index {@code i} with {@code nums[i] == x}, or -1 if absent
     */
    public static int getFirstOccurrence(int[] nums, int x) {
        // Best (leftmost) match found so far
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                // Record and keep looking left for an earlier occurrence
                index = mid;
                end = mid - 1;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

    /**
     * Returns the index of the last (rightmost) occurrence of {@code x}.
     *
     * <p>On a match it records the index and keeps searching the right half for a later duplicate.
     *
     * @param nums array sorted in ascending order (duplicates allowed)
     * @param x    value to find
     * @return largest index {@code i} with {@code nums[i] == x}, or -1 if absent
     */
    public static int getLastOccurrence(int[] nums, int x) {
        // Best (rightmost) match found so far
        int maxIndex = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                // Record and keep looking right for a later occurrence
                maxIndex = mid;
                start = mid + 1;
            } else if (x < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return maxIndex;
    }

    /**
     * Counts the occurrences of {@code x} in a sorted array.
     *
     * @param nums array sorted in ascending order (duplicates allowed)
     * @param x    value to count
     * @return number of times {@code x} appears; 0 if it is absent
     */
    public static int elementCount(int[] nums, int x) {
        int minIndex = getFirstOccurrence(nums, x);
        int maxIndex = getLastOccurrence(nums, x);

        // Value not in the array (checking one index would suffice: both are -1 or both are valid)
        if (minIndex == -1 && maxIndex == -1) {
            return 0;
        }

        // Inclusive size of the contiguous block [minIndex, maxIndex]
        return maxIndex - minIndex + 1;
    }

    public static void main(String[] args) {
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 10));  // 3
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 18));  // 1
        System.out.println(elementCount(new int[]{2, 4, 10, 10, 10, 18, 20}, 100)); // 0
    }
}
