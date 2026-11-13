package dsa.recursion.basics;

/**
 * Fibonacci
 *
 * <p>Returns the nth Fibonacci number (0, 1, 1, 2, 3, 5, 8, ...).
 *
 * <p><b>Idea:</b> F(n) = F(n-1) + F(n-2), with F(0) = 0 and F(1) = 1 (multiple recursion / two calls per level).
 *
 * <p><b>Complexity:</b> Time O(2^n) — the same subproblems are recomputed many times;
 * Space O(n) call-stack depth.
 *
 * <p><b>NOTE:</b> memoization (or a bottom-up loop) brings this down to O(n) time. This overlap
 * of subproblems is exactly what motivates Dynamic Programming.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n <= 1) {
            return n;
        }

        // Two recursive branches form a binary recursion tree
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3)); // 2
    }
}
