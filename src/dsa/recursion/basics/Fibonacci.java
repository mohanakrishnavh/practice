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
    /**
     * Returns the nth Fibonacci number using plain double recursion.
     *
     * @param n the position in the sequence (0-based; must be non-negative)
     * @return F(n), where F(0) = 0 and F(1) = 1
     */
    public static int fibonacci(int n) {
        // Base cases: F(0) = 0, F(1) = 1
        if (n <= 1) {
            return n;
        }

        // Two recursive branches form a binary recursion tree
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Demo: prints F(n) for a spread of inputs, including both base cases.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(fibonacci(0));  // 0  (base case)
        System.out.println(fibonacci(1));  // 1  (base case)
        System.out.println(fibonacci(2));  // 1
        System.out.println(fibonacci(3));  // 2
        System.out.println(fibonacci(6));  // 8
        System.out.println(fibonacci(10)); // 55
        System.out.println(fibonacci(20)); // 6765 (already ~22k calls — shows the O(2^n) cost)
    }
}
