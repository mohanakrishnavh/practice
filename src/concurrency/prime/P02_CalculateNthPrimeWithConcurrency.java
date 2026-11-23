package concurrency.prime;

import java.util.Scanner;

/**
 * P02_CalculateNthPrimeWithConcurrency
 * 
 * Calculates the n-th prime on a separate thread per request.
 *
 * <p>Reads {@code n} from standard input in a loop and prints the n-th prime computed by
 * {@link PrimeNumberUtil#calculatePrime(int)}. Enter 0 or a negative number to exit.
 *
 * <p>Each input starts a new non-daemon thread, so the prompt stays responsive and the JVM
 * waits for running calculations to finish before exiting.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class P02_CalculateNthPrimeWithConcurrency {
    /**
     * Prompts for {@code n} and starts a worker thread for each request.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args){
        // Each execution of while loop start a new thread
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nEnter a value n: ");
            int n = sc.nextInt();
            if (n <= 0) break;

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n" + n + "th prime number : " + number);
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
