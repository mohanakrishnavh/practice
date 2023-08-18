package dsa.recursion.basics;

public class SumOfNNumbers {
    public static int sumParameterized(int i, int sum) {
        if (i < 1) {
            return sum;
        }

        return sumParameterized(i - 1, sum + i);
    }

    public static int sumFunctional(int n) {
        if (n == 0) {
            return 0;
        }

        return n + sumFunctional(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumParameterized(5, 0));
        System.out.println(sumFunctional(5));
    }
}
