package concurrency.prime;

/**
 * Prime Number Utility Class
 * 
 * <p>Provides utility methods for calculating prime numbers.
 * 
 * <p>Note: This implementation uses a simple (and intentionally inefficient) trial division
 * algorithm to demonstrate performance differences in concurrent vs non-concurrent scenarios.
 * 
 * <p>The inefficiency is intentional to make timing differences more observable when
 * comparing single-threaded vs multi-threaded prime number calculations.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PrimeNumberUtil {
    
    /**
     * Calculates the nth prime number using trial division.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Start with number = 1 and primesFound = 0</li>
     *   <li>Increment number and test if it's prime</li>
     *   <li>To test primality: try dividing by all numbers from 2 to number</li>
     *   <li>If no divisor is found, number is prime</li>
     *   <li>Continue until we've found n primes</li>
     * </ol>
     * 
     * <p>Warning: This is an intentionally inefficient implementation for demonstration
     * purposes. For production use, consider:
     * <ul>
     *   <li>Sieve of Eratosthenes for finding multiple primes</li>
     *   <li>Trial division only up to sqrt(n)</li>
     *   <li>Optimizations like checking only odd numbers after 2</li>
     * </ul>
     * 
     * <p>Time Complexity: O(n² * sqrt(n)) - very inefficient
     * <p>Space Complexity: O(1)
     * 
     * @param n the position of the prime number to find (1st prime is 2, 2nd is 3, etc.)
     * @return the nth prime number
     */
    // Inefficient program to calculate prime number
    public static int calculatePrime(int n) {
        int number;
        int numberOfPrimesFound;
        int i;
        number = 1;
        numberOfPrimesFound = 0;

        while (numberOfPrimesFound < n) {
            number++;
            for (i = 2; i <= number && number % i != 0; i++) {
            }
            if (i == number) {
                numberOfPrimesFound++;
            }
        }

        return number;
    }
}
