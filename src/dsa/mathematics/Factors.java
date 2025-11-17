package dsa.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Factors
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class Factors {
    // All numbers from 1 to n that divide the number n
    // are the Factors on n.
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

    // A number is always divisible by 1 and itself
    // Apart from this, the smallest factor it can have is 2 and the largest factor is n/2
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

    // The factors of a number exists in pairs a x b = n
    // If a < b, a < sqrt(n) and b > sqrt(n)
    // If a == b, a = b = sqrt(n)
    // So we can run the loop till sqrt(n) and add i and n/i to the factors list
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
