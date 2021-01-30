package ctc;

public class OneAway {

    private static boolean isExtraChar(String str1, String str2) {
        int counter = 0;
        int length1 = str1.length();
        int length2 = str2.length();

        int i = 0;
        int j = 0;
        while (j < length2 || i < length1) {
            if (i >= length1 || j >= length2 || (str1.charAt(i) != str2.charAt(j))) {
                if (length1 > length2) {
                    i++;
                } else if (length2 > length1) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                counter++;
                continue;
            }
            i++;
            j++;
        }

        return counter == 1;
    }

    private static boolean isOneAway(String str1, String str2) {
        if (str1 == null) {
            if (str2 == null) {
                return false;
            } else return str2.length() == 1;
        } else if (str2 == null) {
            return str1.length() == 1;
        }

        int length1 = str1.length();
        int length2 = str2.length();

        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        return isExtraChar(str1, str2);

    }

    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
        System.out.println(isOneAway("ple", "pale"));
    }
}
