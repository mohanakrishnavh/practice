package dsa.search;

import leetcode.ArrayReader;

/**
 * SearchInASortedArrayOfUnknownSize
 *
 * <p>Searches a sorted (ascending) array whose length is <b>unknown</b>; elements can only be read through an
 * {@link ArrayReader} (LeetCode 702). As in that problem, reading an index past the end is assumed to return a
 * very large sentinel ({@code Integer.MAX_VALUE}) rather than throw, which behaves like "bigger than any target".
 *
 * <p><b>Idea (two phases):</b>
 * <ol>
 *   <li><b>Find a window:</b> without knowing the length, we can't set {@code end = length - 1}. Instead start with a
 *       window of size 2 and keep <i>doubling</i> its right edge until {@code reader.get(end) >= target}. The target,
 *       if it exists, must then lie inside {@code [start, end]}.</li>
 *   <li><b>Binary search</b> inside that window.</li>
 * </ol>
 * Doubling reaches an index at or beyond the target's position in O(log p) steps (p = the target's position), and
 * the final window is at most about p wide, so the binary search is O(log p) too.
 *
 * <p><b>Complexity:</b> Time O(log p), where p is the index of the target (or, if absent, where it would be);
 * Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SearchInASortedArrayOfUnknownSize {
    /**
     * Returns the index of {@code target} in the hidden sorted array, or -1 if it is absent.
     *
     * @param reader access to the array; {@code get(i)} is assumed to return {@code Integer.MAX_VALUE} for
     *               out-of-range {@code i}
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present
     */
    public int search(ArrayReader reader, int target) {
        int start = 0;
        int end = start + 1;
        // Phase 1: exponentially expand the window until its right edge is >= target.
        // The old right edge becomes the new left edge (everything before it is < target), and the right edge doubles.
        while (target > reader.get(end)) {
            start = end;
            end = end * 2;
        }

        // Phase 2: the target, if present, is within [start, end]
        return binarySearch(reader, start, end, target);
    }

    /**
     * Standard binary search over {@code [start, end]} using the reader instead of an array.
     *
     * <p>{@code end} may point past the real end of the array; that is fine because such reads return the huge
     * sentinel, so {@code target < midVal} and the search moves left.
     *
     * @param reader access to the sorted array
     * @param start  first index to consider
     * @param end    last index to consider (may be beyond the array's actual length)
     * @param target value to find
     * @return index of {@code target}, or -1 if it is not present in the window
     */
    public int binarySearch(ArrayReader reader, int start, int end, int target) {
        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;
            // Read once per iteration: each get() is an access we want to keep to a minimum
            int midVal = reader.get(mid);

            if (target == midVal) {
                return mid;
            }

            if (target < midVal) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
