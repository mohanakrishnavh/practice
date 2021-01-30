package ctc;

public class StringCompression {

    private static String compress(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int length = str.length();
        int counter = 0;

        for (int i = 0; i < length - 1; i++) {
            char currentChar = str.charAt(i);
            counter++;

            if (currentChar != str.charAt(i + 1)) {
                result.append(currentChar);
                result.append(counter);
                counter = 0;
            }

        }
        result.append(str.charAt(length - 1));
        result.append(++counter);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
        System.out.println(compress("aabccccca"));
        System.out.println(compress(""));
        System.out.println(compress(null));
        System.out.println(compress("abcd"));
    }
}
