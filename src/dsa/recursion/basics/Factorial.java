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
    public static int factorial(int n) {
        // Base case: 1! = 1 and 0! = 1 (using <= also stops negative input from recursing forever)
        if (n <= 1) {
            return 1;
        }

        // Recursive case: the multiplication happens on the way back up (after the call returns)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
}
