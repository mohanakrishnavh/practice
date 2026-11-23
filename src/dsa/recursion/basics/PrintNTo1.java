package dsa.recursion.basics;

import java.util.Scanner;

/**
 * PrintNTo1
 *
 * <p>Prints the numbers N..1 in decreasing order, using two different recursion styles.
 * This is the mirror image of {@link Print1ToN}.
 *
 * <ul>
 *   <li><b>Forward:</b> start at n, print, then recurse with i-1.</li>
 *   <li><b>Backtracking:</b> recurse upward from 1 to n first, then print on the way back
 *       (so n prints first, 1 prints last).</li>
 * </ul>
 *
 * <p><b>Complexity (both):</b> Time O(n), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintNTo1 {
    /**
     * Forward style: print i, then recurse with i-1 until i drops below 1.
     *
     * @param i current number to print; start with n
     * @param n the original upper bound (unused here, kept for a symmetric signature)
     */
    public static void printNumbers(int i, int n) {
        // Base case: counted down past 1
        if (i < 1) {
            return;
        }

        System.out.println(i);
        printNumbers(i - 1, n);
    }

    /**
     * Backtracking style: called with i = 1; prints after returning from the deeper calls.
     *
     * @param i current number; start with 1
     * @param n upper bound; recursion stops once i exceeds it
     */
    public static void printNumbersUsingBacktracking(int i, int n) {
        if (i > n) {
            return;
        }

        printNumbersUsingBacktracking(i + 1, n);
        System.out.println(i);
    }

    /**
     * Reads N from standard input and prints N..1.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //printNumbers(n, n);

        printNumbersUsingBacktracking(1, n);
    }
}
