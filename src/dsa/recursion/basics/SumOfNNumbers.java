package dsa.recursion.basics;

/**
 * SumOfNNumbers
 *
 * <p>Sum of the first N natural numbers, shown in the two classic recursion styles.
 *
 * <ul>
 *   <li><b>Parameterized:</b> carry the running total down in an argument; the answer is ready at the
 *       base case and is simply passed back up (tail-recursive in shape).</li>
 *   <li><b>Functional:</b> return {@code n + sum(n-1)}; the answer is built while unwinding the stack.</li>
 * </ul>
 *
 * <p><b>Complexity (both):</b> Time O(n), Space O(n) call stack (Java does not do tail-call optimisation).
 * A closed form n*(n+1)/2 would be O(1).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class SumOfNNumbers {
    /**
     * Parameterized style: call with (n, 0); {@code sum} accumulates i on the way down.
     *
     * @param i   current number to add; start with n
     * @param sum running total so far; start with 0
     * @return the sum of 1..i plus the accumulated {@code sum}
     */
    public static int sumParameterized(int i, int sum) {
        // Base case: nothing left to add, the accumulator holds the answer
        if (i < 1) {
            return sum;
        }

        return sumParameterized(i - 1, sum + i);
    }

    /**
     * Functional style: sum(n) = n + sum(n-1), sum(1) = 1.
     *
     * @param n how many natural numbers to add (must be at least 1, or recursion never stops)
     * @return the sum 1 + 2 + ... + n
     */
    public static int sumFunctional(int n) {
        // Base case: sum of 1..1 is 1
        if (n == 1) {
            return 1;
        }

        return n + sumFunctional(n - 1);
    }

    /**
     * Demo: prints the sum of 1..5 using both styles.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println(sumParameterized(5, 0)); // 15
        System.out.println(sumFunctional(5));       // 15
    }
}
