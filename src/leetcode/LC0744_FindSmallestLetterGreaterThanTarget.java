package leetcode;

public class LC0744_FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        char result = letters[0];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                result = letters[mid];
                end = mid - 1;
            }
        }

        return result;
    }
}
