package dsa.recursion.basic;

import java.util.Scanner;

public class Print1ToN {
    public static void printNumbers(int i, int n) {
        if (i > n) {
            return;
        }

        System.out.println(i);
        printNumbers(++i, n);
    }

    // Using Backtracking
    public static void printNumbersUsingBacktracking(int i) {
        if (i < 1) {
            return;
        }

        printNumbersUsingBacktracking(i - 1);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNumbers(1, n);

        printNumbersUsingBacktracking(n);
    }
}
