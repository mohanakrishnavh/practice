package leetcode;

import dsa.greedy.AssignCookies;

import java.util.Arrays;

/**
 * LC0045_AssignCookies
 *
 * Maximizes the number of content children when handing out cookies (LeetCode 455).
 *
 * <p>Problem: Each child {@code i} has a greed factor {@code g[i]} (the minimum cookie size that
 * satisfies them) and each cookie {@code j} has a size {@code s[j]}. A cookie can go to at most
 * one child and satisfies them only if {@code s[j] >= g[i]}.
 *
 * <p>Approach (greedy): Sort both arrays, then walk through the cookies from smallest to largest,
 * giving each cookie to the least greedy child still unsatisfied. A cookie too small for that
 * child is too small for every remaining child, so it is skipped.
 *
 * <p>Time complexity: O(n log n + m log m) for sorting. Space complexity: O(1) beyond the sort.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see dsa.greedy.AssignCookies
 */
public class LC0045_AssignCookies {
    /**
     * Returns the maximum number of children that can be satisfied.
     *
     * <p>Note: both input arrays are sorted in place.
     *
     * @param g the greed factor of each child
     * @param s the size of each cookie
     * @return the number of content children (0 if there are no children or no cookies)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // left = next unsatisfied child, right = current cookie
        int left = 0, right = 0;
        while (left < g.length && right < s.length) {
            // Cookie is big enough for this child: satisfy them and move to the next child
            if (g[left] <= s[right]) {
                left += 1;
            }

            // Either way the cookie is used up or too small for everyone left, so move on
            right += 1;
        }

        // Children satisfied so far
        return left;
    }

    /**
     * Runs one test case and prints PASS or FAIL.
     *
     * @param name     a short description of the case
     * @param g        the children's greed factors
     * @param s        the cookie sizes
     * @param expected the expected number of content children
     */
    private static void check(String name, int[] g, int[] s, int expected) {
        int actual = new AssignCookies().findContentChildren(g, s);
        System.out.println((actual == expected ? "PASS" : "FAIL")
                + " - " + name + " (expected " + expected + ", got " + actual + ")");
    }

    /**
     * Test driver covering typical and edge cases.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        check("fewer cookies than children", new int[]{1, 2, 3}, new int[]{1, 1}, 1);
        check("enough cookies for everyone", new int[]{1, 2}, new int[]{1, 2, 3}, 2);
        check("unsorted inputs", new int[]{3, 1, 2}, new int[]{2, 3, 1}, 3);
        check("cookie size equals greed", new int[]{2}, new int[]{2}, 1);
        check("all cookies too small", new int[]{5, 6}, new int[]{1, 2, 3}, 0);
        check("big cookie not wasted on small greed", new int[]{1, 10}, new int[]{1, 10}, 2);
        check("duplicate greed factors", new int[]{2, 2, 2}, new int[]{2, 2}, 2);
        check("single large cookie, one child served", new int[]{1, 2, 3}, new int[]{10}, 1);
        check("no children", new int[]{}, new int[]{1, 2}, 0);
        check("no cookies", new int[]{1, 2}, new int[]{}, 0);
    }
}
