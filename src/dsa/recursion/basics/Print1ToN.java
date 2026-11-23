package dsa.recursion.basics;

import java.util.Scanner;

/**
 * Print1ToN
 *
 * <p>Prints the numbers 1..N in increasing order, using two different recursion styles.
 *
 * <ul>
 *   <li><b>Parameterized / forward:</b> carry the counter {@code i} and print <i>before</i> recursing.</li>
 *   <li><b>Backtracking:</b> recurse down to the base case first, then print <i>while returning</i>.</li>
 * </ul>
 *
 * <p><b>Complexity (both):</b> Time O(n), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Print1ToN {
    /**
     * Forward style: print i, then move on to i+1 until we pass n.
     *
     * @param i current number to print; start with 1
     * @param n last number to print (inclusive)
     */
    public static void printNumbers(int i, int n) {
        // Base case: counted past n
        if (i > n) {
            return;
        }

        System.out.println(i);
        printNumbers(i + 1, n);
    }

    // Using Backtracking
    /**
     * Backtracking style: the print happens AFTER the recursive call returns, so the deepest call
     * (i = 1) prints first and the outermost call (i = n) prints last. Called with i = n.
     *
     * @param i the number to print on this call; start with n
     */
    public static void printNumbersUsingBacktracking(int i) {
        if (i == 0) {
            return;
        }

        printNumbersUsingBacktracking(i - 1);
        System.out.println(i);
    }

    /**
     * Reads N from standard input and prints 1..N.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //printNumbers(1, n);

        printNumbersUsingBacktracking(n);
    }
}
