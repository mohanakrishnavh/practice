package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * StringCompression
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class StringCompression {
    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        List<Character> compressedString = new ArrayList<>();
        char current = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (count > 1) {
                    compressedString.add(current);
                    compressedString.add(Character.forDigit(count, 10));

                    current = chars[i];
                    count = 1;
                }
            } else {
                count++;
            }
        }

        compressedString.add(current);
        if (count > 1) {
            compressedString.add(Character.forDigit(count, 10));
        }

        return compressedString.size();
    }

    public static void main(String[] args) {
        System.out.println(StringCompression.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
