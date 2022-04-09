package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorization {
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
