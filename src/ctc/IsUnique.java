package ctc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    private static boolean isUnique1(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            for (int j = 0; j < inputString.length(); j++) {
                if (i == j) {
                    continue;
                }

                if (inputString.charAt(i) == inputString.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isUnique2(String inputString) {
        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < inputString.length(); i++) {
            if (characters.contains(inputString.charAt(i))) {
                return false;
            }

            characters.add(inputString.charAt(i));
        }
        return true;
    }

    private static boolean isUnique3(String inputString) {
        char[] inputChars = inputString.toCharArray();
        Arrays.sort(inputChars);

        for (int i = 0; i < inputChars.length - 1; i++) {
            if (inputChars[i] == inputChars[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "abcdddeee";

        System.out.println(str1 + " is unique? :" + isUnique3(str1));
        System.out.println(str2 + " is unique? :" + isUnique3(str2));
    }
}
