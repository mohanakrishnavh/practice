package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Factors
 * 
 * Finds all factors (divisors) of a number, using three approaches of increasing efficiency:
 * a full scan up to n, a scan up to n/2, and a scan up to sqrt(n) that records factor pairs.
 *
 * <p>Complexity: {@code findAllFactors} and {@code findAllFactors2} are O(n); {@code findAllFactorsOptimized} is O(sqrt(n)).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class Factors {
    /**
     * Finds all factors by checking every number from 2 to n-1 (1 and n are added directly).
     *
     * @param n the number to factorise
     * @return factors of {@code n} in ascending order (empty list if {@code n} is 0)
     */
    public static List<Integer> findAllFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 0) {
            return factors;
        }

        factors.add(1);
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        factors.add(n);

        return factors;
    }

    /**
     * Finds all factors by checking only up to n/2, since no factor other than n itself can be larger.
     *
     * @param n the number to factorise
     * @return factors of {@code n} in ascending order (empty list if {@code n} is 0)
     */
    public static List<Integer> findAllFactors2(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 0) {
            return factors;
        }

        factors.add(1);
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        factors.add(n);

        return factors;
    }

    /**
     * Finds all factors by checking only up to sqrt(n). Factors come in pairs (i, n/i), so each
     * divisor found yields its partner too; the list is sorted at the end.
     *
     * @param n the number to factorise
     * @return factors of {@code n} in ascending order (empty list if {@code n} is 0)
     */
    public static List<Integer> findAllFactorsOptimized(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 0) {
            return factors;
        }

        factors.add(1);
        factors.add(n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);

                if (i != Math.sqrt(n)) {
                    factors.add(n / i);
                }
            }
        }

        Collections.sort(factors);

        return factors;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("findAllFactors():");
        System.out.println(findAllFactors(10));
        System.out.println(findAllFactors(15));
        System.out.println(findAllFactors(17));

        System.out.println("findAllFactors2():");
        System.out.println(findAllFactors2(10));
        System.out.println(findAllFactors2(15));
        System.out.println(findAllFactors2(17));

        System.out.println("findAllFactorsOptimized():");
        System.out.println(findAllFactors2(10));
        System.out.println(findAllFactors2(15));
        System.out.println(findAllFactors2(17));
    }
}
