package dsa.search;

/**
 * LastOccurrenceOfAnElement
 *
 * <p>Finds the <b>rightmost</b> index of a value in a sorted (ascending) array that may contain duplicates.
 *
 * <p><b>Idea:</b> mirror of {@link FirstOccurrenceOfAnElement}. On a match we <i>record the index but keep
 * searching the right half</i> ({@code start = mid + 1}), because a later occurrence might still exist.
 * When the window empties, the last recorded index is the rightmost one.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>Related:</b> with both bounds, the number of occurrences of a value is {@code last - first + 1}
 * (and 0 if either lookup returns -1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LastOccurrenceOfAnElement {
    /**
     * Returns the index of the last occurrence of {@code x} in a sorted array.
     *
     * @param nums array sorted in ascending order (duplicates allowed)
     * @param x    value to find
     * @return the largest index {@code i} with {@code nums[i] == x}, or -1 if {@code x} is not present
     */
    public static int getLastOccurrence(int[] nums, int x) {
        // Best answer found so far; stays -1 if x is never matched
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                // Candidate answer: remember it, then look further right for a later duplicate
                index = mid;
                start = mid + 1;
            } else if (x < nums[mid]) {
                // x is smaller than the middle value -> it can only be in the left half
                end = mid - 1;
            } else {
                // x is larger than the middle value -> it can only be in the right half
                start = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println(getLastOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 10)); // 4
        System.out.println(getLastOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 1));  // -1
    }
}
