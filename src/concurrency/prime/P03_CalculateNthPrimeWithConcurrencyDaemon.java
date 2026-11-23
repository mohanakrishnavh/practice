package concurrency.prime;

import java.util.Scanner;

/**
 * P03_CalculateNthPrimeWithConcurrencyDaemon
 * 
 * Calculates the n-th prime on a separate daemon thread per request.
 *
 * <p>Reads {@code n} from standard input in a loop and prints the n-th prime computed by
 * {@link PrimeNumberUtil#calculatePrime(int)}. Enter 0 or a negative number to exit.
 *
 * <p>Same as {@code P02}, but worker threads are daemon threads, so the JVM can exit as soon
 * as the main thread finishes even if calculations are still running.
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class P03_CalculateNthPrimeWithConcurrencyDaemon {
    /**
     * Prompts for {@code n} and starts a daemon worker thread for each request.
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
            thread.setDaemon(true);
            thread.start();
        }
    }
}
