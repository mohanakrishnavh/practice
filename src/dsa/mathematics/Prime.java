package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prime {
    // If any number other than 1 & n divides n, then n is not prime
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

    // There cannot be a factor of n that is greater than n/2
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

    // If (a == b) => a^2 = n => a = sqrt(n) [Special case]
    // If a < b => a < sqrt(n) , b > sqrt(n)
    // If b < a => b < sqrt(n), a > sqrt(n)
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

    // Sieve of Eratosthenes
    // If a number is primes, all the multiples of that number can't be prime.
    // Initially we mark all the numbers as primes
    // Going over the elements i= 0 -> sqrt(n), we mark all the multiples of i as not primes
    // Time Complexity : O(log(log(n))
    public static List<Integer> findPrimesOptimized(int n) {
        Integer[] primes = new Integer[n+1];
        for (int i=2; i <= n; i++) {
            primes[i] = 1;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j <= n; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        return Arrays.asList(primes);
    }

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
        System.out.println(findPrimes(15));
    }
}
