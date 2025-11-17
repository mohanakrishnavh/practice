package concurrency.prime;

import java.util.Scanner;

/**
 * P01_CalculateNthPrimeWithNoConcurrency
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class P01_CalculateNthPrimeWithNoConcurrency {
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
