package dsa.search;

import dsa.util.MathUtil;

/**
 * MinimumNumberOfPages
 *
 * <p>"Allocate Books" / "Split Array Largest Sum": given the page counts of books in a fixed order and {@code k}
 * students, give each student a <b>contiguous</b> block of books so that the <i>maximum</i> pages any one student
 * reads is as small as possible, and return that minimum maximum.
 *
 * <p><b>Pattern: binary search on the answer.</b> The answer is not an array index but a number in the range
 * {@code [max(nums), sum(nums)]}:
 * <ul>
 *   <li>Lower end = the largest single book (some student must read it).</li>
 *   <li>Upper end = the total pages (one student reads everything).</li>
 * </ul>
 * For a candidate limit {@code m}, {@link #isValid} greedily checks whether the books can be split among at most
 * {@code k} students without anyone exceeding {@code m}. Feasibility is monotonic (if {@code m} works, any larger
 * limit also works), so binary search finds the smallest feasible {@code m}.
 *
 * <p><b>Complexity:</b> Time O(n * log(sum - max)), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class MinimumNumberOfPages {
    /**
     * Returns the smallest possible value of the maximum pages assigned to any student.
     *
     * @param nums page counts of the books, in the order they must be assigned
     * @param k    number of students
     * @return the minimised maximum pages, or -1 if there are fewer books than students (each student needs a book)
     */
    public static int getMinimumPages(int[] nums, int k) {
        // Impossible: at least one student would get no book
        if (nums.length < k) {
            return -1;
        }

        int result = -1;
        // Search space for the answer: no student can read less than the biggest book, nor more than everything
        int start = MathUtil.max(nums);
        int end = MathUtil.sum(nums);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, k, mid)) {
                // mid is feasible; remember it and try for a smaller limit
                result = mid;
                end = mid - 1;
            } else {
                // mid is too small to split among k students; the limit must be larger
                start = mid + 1;
            }
        }

        return result;
    }

    /**
     * Checks whether the books can be divided among at most {@code k} students such that nobody reads more than
     * {@code maximumNumberOfPages}.
     *
     * <p>Greedy: keep giving the next book to the current student until it would exceed the limit, then start a
     * new student with that book. Packing each student as full as possible uses the fewest students.
     *
     * @param nums                 page counts of the books, in order
     * @param k                    maximum number of students allowed
     * @param maximumNumberOfPages the per-student page limit being tested
     * @return {@code true} if at most {@code k} students suffice
     */
    private static boolean isValid(int[] nums, int k, int maximumNumberOfPages) {
        int numberOfStudents = 1;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            // If the number of pages allocated to current student exceeds the maximum,
            // we allocate a new student
            if (sum > maximumNumberOfPages) {
                numberOfStudents++;
                // The book that didn't fit starts the next student's load
                sum = num;
            }

            // If the numbers of students needed for current iteration is greater than
            // the given k, then this is an invalid state
            if (numberOfStudents > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 2)); // 60 ([10,20,30] | [40])
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 5)); // -1 (more students than books)
        System.out.println(getMinimumPages(new int[]{10, 20, 30, 40}, 3)); // 40 ([10,20] | [30] | [40])
    }
}
