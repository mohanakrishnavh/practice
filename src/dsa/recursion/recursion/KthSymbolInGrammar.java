package dsa.recursion.recursion;

/**
 * KthSymbolInGrammar
 *
 * <p>Returns the k-th symbol (1-indexed) in row n of the grammar where each row is built from the previous
 * one by replacing 0 → 01 and 1 → 10 (LeetCode 779).
 *
 * <p><b>Idea:</b> row n has 2^(n-1) symbols. Its first half is identical to row n-1, and its second half is
 * the <i>complement</i> of row n-1. So instead of building the row, jump to the matching position in the
 * previous row:
 * <ul>
 *   <li>{@code k <= mid} → same answer as {@code kthGrammar(n-1, k)}.</li>
 *   <li>{@code k > mid}  → flip the answer of {@code kthGrammar(n-1, k - mid)}.</li>
 * </ul>
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack.
 *
 * <p><b>NOTE:</b> {@code Math.pow} works for small n; {@code 1 << (n - 2)} avoids the double conversion.
 * The comment block below labels rows from N = 0, whereas the method (and LeetCode) treat the first row as n = 1.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class KthSymbolInGrammar {
    /*
    N = 0, Pattern: 0
    N = 1, Pattern: 0 1
    N = 2, Pattern: 0 1 1 0
    N = 3, Pattern: 0 1 1 0 1 0 0 1
    N = 4, Pattern: 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
    */
    public int kthGrammar(int n, int k) {
        // Base case: the first row is just "0"
        if (n == 1 && k == 1) {
            return 0;
        }

        // Length of the first half of row n (= half of 2^(n-1))
        int mid = (int)Math.pow(2, n-1)/2;

        if (k <= mid) {
            // The first half follows the same pattern as the previous row
            return kthGrammar(n - 1, k);
        } else {
            // The second half is a complement of the pattern from the previous row
            return kthGrammar(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}
