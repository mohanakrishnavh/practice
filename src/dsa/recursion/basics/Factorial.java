package dsa.recursion.basics;

/**
 * Factorial
 *
 * <p>Computes n! = n * (n-1) * ... * 1 recursively.
 *
 * <p><b>Idea:</b> n! = n * (n-1)!  — shrink the problem by one each call until the base case.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) for the call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Factorial {
    /**
     * Computes n! recursively: n! = n * (n-1)!.
     *
     * @param n the value whose factorial is wanted (must be non-negative, or recursion never stops)
     * @return n!; note that {@code int} overflows for n > 12
     */
    public static int factorial(int n) {
        // Base case: 0! = 1! = 1
        if (n == 0 || n == 1) {
            return 1;
        }

        // The multiplication happens on the way back up, after the recursive call returns
        return n * factorial(n - 1);
    }

    /**
     * Demo: prints 5! (120).
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}
