package dsa.recursion.basics;

import java.util.Scanner;

public class PrintNameNTimes {
    public static void printName(int index, int n, String name) {
        if (index == n) {
            return;
        }

        System.out.println(name);
        printName(++index, n, name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String name = sc.next();

        printName(0, n, name);
    }
}
