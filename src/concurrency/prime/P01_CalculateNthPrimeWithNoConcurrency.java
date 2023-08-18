package concurrency.prime;

import java.util.Scanner;

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
