package dsa.recursion.recursion;

/**
 * PrintNTo1
 *
 * <p>Prints n..1 in decreasing order using the <b>induction</b> style of thinking:
 * print n first, then rely on the recursive call to print n-1..1.
 *
 * <p>The print sits <i>before</i> the recursive call, so output is produced while going down the stack.
 * Compare with {@link Print1ToN}, where the print is after the call.
 *
 * <p><b>Complexity:</b> Time O(n), Space O(n) call stack. Requires n &gt;= 1.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintNTo1 {
    public static void print(int n) {
        // Base case: smallest input, just print it
        if (n == 1) {
            System.out.println(n);
            return;
        }

        // Print the current number first, then hand the rest to the recursion
        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        print(10);
    }
}
