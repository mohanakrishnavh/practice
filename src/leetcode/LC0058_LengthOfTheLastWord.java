package leetcode;

public class LC0058_LengthOfTheLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int i = s.length() - 1;
        // Removing any trailing white space
        while (s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;
        // Computing the length of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
