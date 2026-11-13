package dsa.recursion.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateAllBalancedParentheses
 *
 * <p>Generates all well-formed strings with {@code n} pairs of parentheses (LeetCode 22).
 *
 * <p><b>Idea:</b> build the string one character at a time, tracking how many opening ({@code open}) and
 * closing ({@code close}) brackets are <i>still available</i>. Two rules keep every string valid:
 * <ol>
 *   <li>An opening bracket may be added while any remain ({@code open != 0}).</li>
 *   <li>A closing bracket may be added only if more closers remain than openers
 *       ({@code close > open}), i.e. there is an unmatched "(" to close.</li>
 * </ol>
 * Because invalid prefixes are never generated, no filtering is needed afterwards.
 *
 * <p><b>Complexity:</b> Time O(4^n / sqrt(n)) — the n-th Catalan number of results, each O(n) to copy;
 * Space O(n) recursion depth (excluding output).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class GenerateAllBalancedParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        // Start with n of each bracket still to place
        solve(n, n, sb, result);

        return result;
    }

    private static void solve(int open, int close, StringBuilder sb, List<String> result) {
        // Base case: every bracket placed -> the string is complete and valid
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        // Option 1: place "(" if we still have some
        if (open != 0) {
            sb.append("(");
            solve(open - 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }

        // Option 2: place ")" only if it closes an already-opened "("
        // (remaining closers > remaining openers means unmatched "(" exist)
        if (close > open) {
            sb.append(")");
            solve(open, close - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3)); // [((())), (()()), (())(), ()(()), ()()()]
    }
}
