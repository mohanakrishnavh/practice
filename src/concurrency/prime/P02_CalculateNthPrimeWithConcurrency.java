package concurrency.prime;

import java.util.Scanner;

public class P02_CalculateNthPrimeWithConcurrency {
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
            thread.start();
        }
    }
}
