package dsa.recursion.basics;

import java.util.Scanner;

public class PrintNameNTimes {
    public static void printName(int i, int n, String name) {
        if (i > n) {
            return;
        }

        System.out.println(name);
        printName(++i, n, name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = sc.next();

        printName(1, n, name);
    }
}
