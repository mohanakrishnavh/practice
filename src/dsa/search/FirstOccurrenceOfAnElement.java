package dsa.search;

/**
 * FirstOccurrenceOfAnElement
 *
 * <p>Finds the <b>leftmost</b> index of a value in a sorted (ascending) array that may contain duplicates.
 *
 * <p><b>Idea:</b> plain binary search stops at the first match it lands on, which could be any of the
 * duplicates. Here, on a match we <i>record the index but keep searching the left half</i>
 * ({@code end = mid - 1}), because an earlier occurrence might still exist. When the window empties, the
 * last recorded index is the leftmost one.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * <p><b>Related:</b> mirroring this (on a match, set {@code start = mid + 1} instead) gives the last occurrence;
 * together they give the count of an element as {@code last - first + 1}.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class FirstOccurrenceOfAnElement {
    /**
     * Returns the index of the first occurrence of {@code x} in a sorted array.
     *
     * @param nums array sorted in ascending order (duplicates allowed)
     * @param x    value to find
     * @return the smallest index {@code i} with {@code nums[i] == x}, or -1 if {@code x} is not present
     */
    public static int getFirstOccurrence(int[] nums, int x) {
        // Best answer found so far; stays -1 if x is never matched
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (x == nums[mid]) {
                // Candidate answer: remember it, then look further left for an earlier duplicate
                index = mid;
                end = mid - 1;
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
        System.out.println(getFirstOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 10)); // 2
        System.out.println(getFirstOccurrence(new int[]{2, 4, 10, 10, 10, 18, 20}, 1));  // -1
    }
}
