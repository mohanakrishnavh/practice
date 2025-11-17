package dsa.recursion.recursion;

/**
 * PrintNTo1
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PrintNTo1 {
    public static void print(int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }

        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        print(10);
    }
}
