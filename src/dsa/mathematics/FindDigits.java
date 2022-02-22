package dsa.mathematics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDigits {
    public static List<Integer> getDigits(int n, int base) {
        if (n == 0 || base == 0) {
            return List.of(0);
        }

        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            int remainder = n % base;
            digits.add(remainder);
            n = n/base;
        }

        Collections.reverse(digits);
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(getDigits(125, 10));
        System.out.println(getDigits(125, 2));
    }
}
