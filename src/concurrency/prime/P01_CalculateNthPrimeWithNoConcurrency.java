package concurrency.prime;

import java.util.Scanner;

/**
 * P01_CalculateNthPrimeWithNoConcurrency
 * 
 * Calculates the n-th prime on the main thread (baseline with no concurrency).
 *
 * <p>Reads {@code n} from standard input in a loop and prints the n-th prime computed by
 * {@link PrimeNumberUtil#calculatePrime(int)}. Enter 0 or a negative number to exit.
 *
 * <p>The prompt is blocked while a calculation runs, so large inputs make the program unresponsive.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class P01_CalculateNthPrimeWithNoConcurrency {
    /**
     * Prompts for {@code n} and prints the n-th prime until a non-positive value is entered.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter a value n: ");
            int n = sc.nextInt();
            if (n <= 0) break;
            int number = PrimeNumberUtil.calculatePrime(n);
            System.out.println("\n" + n + "th prime number : " + number);
        }
    }

}
