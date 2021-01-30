package leetcode;

public class Atoi {
    public int stringToInteger(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }

        double result = 0;
        int start = 0;
        boolean isNegative = false;
        if (s.charAt(0) == '+') {
            start++;
        } else if (s.charAt(0) == '-') {
            start++;
            isNegative = true;
        }

        for (int i=start; i<s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                break;
            }

            result = result*10 + (int)s.charAt(i)-'0';
        }

        if (isNegative) {
            result = -result;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        return (int) result;
    }
}
