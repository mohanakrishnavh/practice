package dsa.recursion.recursion;

/**
 * Print1ToN
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Print1ToN {
    public static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(10);
    }
}
