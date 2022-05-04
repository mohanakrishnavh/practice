package dsa.recursion.basic;

import java.util.Scanner;

public class PrintNTo1 {
    public static void printNumbers(int i, int n) {
        if (i < 1) {
            return;
        }

        System.out.println(i);
        printNumbers(i-1, n);
    }

    public static void printNumbersUsingBacktracking(int i, int n) {
        if (i > n) {
            return;
        }

        printNumbersUsingBacktracking(i+1, n);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNumbers(n, n);

        printNumbersUsingBacktracking(1, n);
    }
}
