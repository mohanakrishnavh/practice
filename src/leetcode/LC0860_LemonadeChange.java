package leetcode;

/**
 * LC0860_LemonadeChange
 *
 * Decides whether correct change can be given to every customer at a lemonade stand (LeetCode 860).
 *
 * <p>Problem: Each lemonade costs $5. Customers queue in order and pay with a $5, $10 or $20
 * bill. You start with no change and must give each customer the correct change.
 *
 * <p>Approach (greedy): Track only the number of $5 and $10 bills held ($20s are never used as
 * change). For a $20 bill, prefer giving one $10 + one $5 over three $5s, because $5 bills are
 * the most flexible and should be kept for as long as possible.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 * @see dsa.greedy.LemonadeChange
 */
public class LC0860_LemonadeChange {

    /**
     * Returns whether every customer can be given the correct change.
     *
     * @param bills the bill each customer pays with, in queue order (5, 10 or 20)
     * @return true if change can be given to all customers (also true for an empty queue),
     * false as soon as one customer cannot be given change
     */
    public boolean lemonadeChange(int[] bills) {
        // Bills available as change
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                // Exact payment: no change needed
                five += 1;
            } else if (bills[i] == 10) {
                // Change due is $5
                if (five > 0) {
                    five -= 1;
                    ten += 1;
                } else {
                    return false;
                }
            } else {
                // $20: change due is $15. Prefer $10 + $5 to keep the more flexible $5 bills
                if (ten > 0 && five > 0) {
                    ten -= 1;
                    five -= 1;
                } else if (five >= 3) {
                    // Fall back to three $5 bills
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
