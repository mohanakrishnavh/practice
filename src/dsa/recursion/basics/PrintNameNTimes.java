package dsa.recursion.basics;

import java.util.Scanner;

/**
 * PrintNameNTimes
 *
 * <p>Prints a given name N times — the simplest "replace a loop with recursion" example.
 *
 * <p><b>Idea:</b> {@code i} plays the role of the loop counter; each call prints once and
 * moves to {@code i + 1} until it reaches {@code n}.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintNameNTimes {
    /**
     * Prints {@code name} once per call, recursing until {@code i} reaches {@code n}.
     *
     * @param i    current iteration (loop counter); start with 0
     * @param n    total number of times to print the name
     * @param name the text to print
     */
    public static void printName(int i, int n, String name) {
        // Base case: printed n times already
        if (i == n) {
            return;
        }

        System.out.println(name);
        printName(i + 1, n, name);
    }

    /**
     * Reads N and a name from standard input, then prints the name N times.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = sc.next();

        printName(0, n, name);
    }
}