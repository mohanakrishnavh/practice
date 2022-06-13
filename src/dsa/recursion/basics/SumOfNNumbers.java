package dsa.recursion.basics;

public class SumOfNNumbers {
    public static void sumParameterized(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        sumParameterized(i - 1, sum + i);
    }

    public static int sumFunctional(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sumFunctional(n - 1);
    }
}
