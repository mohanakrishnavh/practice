package dsa.search;

/**
 * AllocateMinimumPages
 *
 * <p>"Allocate Books": given the page counts of books in a fixed order and {@code k} students, give each student a
 * <b>contiguous</b> block of books (every student gets at least one) so that the <i>maximum</i> pages any one student
 * reads is as small as possible, and return that minimum maximum.
 *
 * <p><b>Pattern: binary search on the answer.</b> The answer lies in {@code [max(arr), sum(arr)]}:
 * <ul>
 *   <li>Lower end = the largest single book (some student must read it).</li>
 *   <li>Upper end = the total pages (one student reads everything).</li>
 * </ul>
 * For a candidate limit {@code m}, {@link #isValid} greedily checks whether the books fit within {@code k} students.
 * Feasibility is monotonic (if {@code m} works, any larger limit works too), so binary search finds the smallest
 * feasible {@code m}. The search bounds and sums use {@code long} to avoid overflow on large inputs.
 *
 * <p><b>Complexity:</b> Time O(n * log(sum - max)), Space O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class AllocateMinimumPages {
    /**
     * Returns the smallest possible value of the maximum pages assigned to any student.
     *
     * @param arr page counts of the books, in the order they must be assigned
     * @param k   number of students
     * @return the minimised maximum pages, or -1 if there are no books or fewer books than students
     */
    public static int findPages(int[] arr, int k) {
        // Impossible: at least one student would get no book
        if (arr.length == 0 || arr.length < k) {
            return -1;
        }

        int maxPages = -1;
        long sumOfPages = 0;

        // Get the search space
        for (int pages : arr) {
            maxPages = Math.max(pages, maxPages);
            sumOfPages += pages;
        }

        long start = maxPages, end = sumOfPages;
        int result = -1;
        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isValid(arr, k, mid)) {
                // mid is feasible; remember it and try for a smaller limit
                result = (int) mid;
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
     * {@code maxPages}.
     *
     * <p>Greedy: keep giving the next book to the current student until it would exceed the limit, then start a
     * new student with that book. Packing each student as full as possible uses the fewest students.
     *
     * @param arr      page counts of the books, in order
     * @param k        maximum number of students allowed
     * @param maxPages the per-student page limit being tested
     * @return {@code true} if at most {@code k} students suffice
     */
    private static boolean isValid(int[] arr, int k, long maxPages) {
        int student = 1;
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > maxPages) {
                // The book that didn't fit starts the next student's load
                student++;
                sum = arr[i];

                if (student > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(findPages(new int[]{12, 34, 67, 90}, 2));        // 113 ([12,34,67] | [90])
        System.out.println(findPages(new int[]{10, 20, 30, 40}, 2));        // 60 ([10,20,30] | [40])
        System.out.println(findPages(new int[]{10, 20, 30, 40}, 3));        // 40 ([10,20] | [30] | [40])
        System.out.println(findPages(new int[]{10, 20, 30, 40}, 4));        // 40 (one book each)
        System.out.println(findPages(new int[]{10, 20, 30, 40}, 1));        // 100 (single student reads all)
        System.out.println(findPages(new int[]{10, 20, 30, 40}, 5));        // -1 (more students than books)
        System.out.println(findPages(new int[]{}, 1));                      // -1 (no books)
        System.out.println(findPages(new int[]{7}, 1));                     // 7
        System.out.println(findPages(new int[]{5, 5, 5, 5}, 2));            // 10
        System.out.println(findPages(new int[]{Integer.MAX_VALUE, 1}, 2));  // 2147483647 (long sum avoids overflow while searching)
    }
}
