package dsa.search;

public class NextAlphabeticalElement {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        char result = letters[0];

        while (start <= end) {
            int mid = start  + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                result = letters[mid];
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{ 'a', 'c', 'f', 'h'}, 'f'));
    }
}
