package dsa.search;

/**
 * NextAlphabeticalElement
 *
 * <p>Finds the smallest letter in a sorted array that is <b>strictly greater</b> than a target letter, wrapping
 * around to the first letter if none is greater (LeetCode 744). Example: in {@code [a, c, f, h]} the next
 * greatest letter after {@code 'f'} is {@code 'h'}, and after {@code 'h'} it wraps to {@code 'a'}.
 *
 * <p><b>Idea:</b> this is the "strict ceiling" variant of binary search. If {@code letters[mid] <= target} it is
 * not strictly greater, so discard it and everything to its left. Otherwise it is a valid candidate, but a smaller
 * valid one may exist to the left, so record it and move left. Using {@code <=} (not {@code <}) is what makes an
 * exact match or a run of duplicates of the target get skipped. The last recorded candidate is the answer.
 *
 * <p><b>Wrap-around:</b> {@code result} starts as {@code letters[0]}. If no letter is greater than the target the
 * loop never records a candidate, so the initial value is returned, which is exactly the wrap-around answer.
 *
 * <p><b>Complexity:</b> Time O(log n), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class NextAlphabeticalElement {
    /**
     * Returns the smallest letter in {@code letters} that is lexicographically greater than {@code target},
     * or the first letter if there is none (circular behaviour).
     *
     * <p><b>NOTE:</b> an empty array throws {@code ArrayIndexOutOfBoundsException} at {@code letters[0]}; the
     * problem guarantees at least two letters.
     *
     * @param letters non-empty array of characters sorted in ascending (non-decreasing) order
     * @param target  letter to look past
     * @return the next greatest letter, wrapping around to {@code letters[0]} when none exists
     */
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        // Default answer is the wrap-around case: no letter is greater than target -> first letter
        char result = letters[0];

        while (start <= end) {
            // Overflow-safe midpoint
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                // Not strictly greater (equal or smaller): the answer must be to the right
                start = mid + 1;
            } else {
                // Valid candidate; a smaller valid one may be on the left, so record and keep looking left
                result = letters[mid];
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'a', 'c', 'f', 'h'}, 'f')); // h (strictly greater than 'f')
    }
}
