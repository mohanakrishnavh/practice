package interview.goldman;

public class PowerOfTen {
    public boolean isPowerOfTen(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 10 == 0) {
            n /= 10;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        PowerOfTen obj = new PowerOfTen();
        System.out.println(obj.isPowerOfTen(10));
        System.out.println(obj.isPowerOfTen(12));
        System.out.println(obj.isPowerOfTen(10000));
        System.out.println(obj.isPowerOfTen(123));

    }
}
