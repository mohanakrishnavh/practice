package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * PrimeFactorization
 * 
 * Computes the prime factorization of a number as a list of (prime, exponent) pairs,
 * e.g. 24 = 2^3 x 3 gives [[2, 3], [3, 1]].
 *
 * <p>Two versions: one divides by every candidate up to n, the other stops at sqrt(n) and adds
 * any remaining value greater than 1 as a prime factor (O(sqrt(n)) time).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrimeFactorization {
    /**
     * Finds the prime factors by trial division with every candidate from 2 to n.
     *
     * @param n the number to factorise
     * @return list of [prime, exponent] pairs in ascending prime order (empty if {@code n} is 0)
     */
    public static List<List<Integer>> findPrimeFactors(int n) {
        List<List<Integer>> primeFactors = new ArrayList<>();
        if (n == 0) {
            return primeFactors;
        }

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n = n / i;
                    count++;
                }

                primeFactors.add(new ArrayList<>(Arrays.asList(i, count)));
            }
        }

        return primeFactors;
    }

    /**
     * Finds the prime factors by trial division up to sqrt(n). After dividing out all small
     * factors, whatever remains (if greater than 1) is itself a prime factor.
     *
     * @param n the number to factorise
     * @return list of [prime, exponent] pairs in ascending prime order (empty if {@code n} is 0)
     */
    public static List<List<Integer>> findPrimeFactorsOptimized(int n) {
        List<List<Integer>> primeFactors = new ArrayList<>();
        if (n == 0) {
            return primeFactors;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n = n / i;
                    count++;
                }

                primeFactors.add(new ArrayList<>(Arrays.asList(i, count)));
            }
        }

        if (n != 1) {
            primeFactors.add(new ArrayList<>(Arrays.asList(n, 1)));
        }

        return primeFactors;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Prime Factors:");
        System.out.println("Primes Factors of 24 : " + findPrimeFactors(24));
        System.out.println("Primes Factors of 36 : " + findPrimeFactors(36));
        System.out.println("Primes Factors of 17 : " + findPrimeFactors(17));

        System.out.println();

        System.out.println("Prime Factors:");
        System.out.println("Primes Factors of 24 : " + findPrimeFactorsOptimized(24));
        System.out.println("Primes Factors of 36 : " + findPrimeFactorsOptimized(36));
        System.out.println("Primes Factors of 17 : " + findPrimeFactorsOptimized(17));
        System.out.println("Primes Factors of 25 : " + findPrimeFactorsOptimized(25));
    }
}
