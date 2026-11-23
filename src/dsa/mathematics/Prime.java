package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prime
 * 
 * Primality testing and prime generation, with several approaches of increasing efficiency:
 * trial division up to n, up to n/2, and up to sqrt(n); listing primes by testing each number; and
 * the Sieve of Eratosthenes.
 *
 * <p>Complexity: {@code isPrime} O(n), {@code isPrime2} O(n/2), {@code isPrimeOptimized} O(sqrt(n)),
 * sieve O(n log log n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Prime {
    /**
     * Tests primality by checking whether any number from 2 to n-1 divides {@code n}.
     *
     * @param n the number to test
     * @return true if {@code n} is prime
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Tests primality by checking divisors only below n/2.
     *
     * <p>Note: the loop bound is exclusive, so a number whose smallest factor equals n/2 (such as 4)
     * is reported as prime.
     *
     * @param n the number to test
     * @return true if {@code n} is judged prime
     */
    public static boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Tests primality by checking divisors only up to sqrt(n): if {@code n} has a factor larger
     * than its square root, it also has a matching factor smaller than it.
     *
     * @param n the number to test
     * @return true if {@code n} is prime
     */
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Lists all primes below {@code n} by testing each candidate with {@link #isPrimeOptimized}.
     *
     * @param n exclusive upper bound
     * @return primes less than {@code n} in ascending order
     */
    public static List<Integer> findPrimes(int n) {
        if (n <= 1) {
            return new ArrayList<>();
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrimeOptimized(i)) {
                primes.add(i);
            }
        }

        return primes;
    }

    /**
     * Lists all primes up to and including {@code n} using the Sieve of Eratosthenes.
     *
     * <p>All numbers start as prime; for each prime i up to sqrt(n), every multiple of i is marked
     * composite. Time complexity O(n log log n), space O(n).
     *
     * @param n inclusive upper bound (must be at least 1)
     * @return primes less than or equal to {@code n} in ascending order
     */
    public static List<Integer> findPrimesOptimized(int n) {
        int[] primes = new int[n+1];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j <= n; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1) {
                primesList.add(i);
            }
        }

        return primesList;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Test Method 1 - isPrime()");
        System.out.println(isPrime(10));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(-1));

        System.out.println("Test Method 2 - isPrime2()");
        System.out.println(isPrime2(10));
        System.out.println(isPrime2(1));
        System.out.println(isPrime2(2));
        System.out.println(isPrime2(3));
        System.out.println(isPrime2(-1));

        System.out.println("Test Method 3 - isPrimeOptimized()");
        System.out.println(isPrimeOptimized(10));
        System.out.println(isPrimeOptimized(1));
        System.out.println(isPrimeOptimized(2));
        System.out.println(isPrimeOptimized(3));
        System.out.println(isPrimeOptimized(-1));

        System.out.print("Test Method 4 - findPrimes()");
        System.out.println(findPrimes(15));

        System.out.print("Test Method 5 - findPrimesOptimized()");
        System.out.println(findPrimesOptimized(15));
    }
}
