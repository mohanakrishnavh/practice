package dsa.recursion.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * GenerateAllBalancedParentheses
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class GenerateAllBalancedParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();
        solve(n, n, sb, result);

        return result;
    }

    private static void solve(int open, int close, StringBuilder sb, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        if (open != 0) {
            sb.append("(");
            solve(open - 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close > open) {
            sb.append(")");
            solve(open, close - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
