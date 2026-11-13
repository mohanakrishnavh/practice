package dsa.recursion.recursion;

/**
 * Print1ToN
 *
 * <p>Prints 1..n in increasing order using the <b>induction</b> style of thinking:
 * "assume print(n-1) prints 1..n-1 correctly, then print n afterwards."
 *
 * <p>The print sits <i>after</i> the recursive call, so the output is produced while the stack unwinds.
 * Compare with {@link PrintNTo1}, where moving the print before the call reverses the order.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack. Requires n &gt;= 1.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Print1ToN {
    public static void print(int n) {
        // Base case: smallest input, just print it
        if (n == 1) {
            System.out.println(n);
            return;
        }

        // Hypothesis: this prints 1..n-1
        print(n - 1);
        // Induction step: then print n
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(10);
    }
}
