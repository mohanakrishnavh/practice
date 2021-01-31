package leetcode;

public class FirstUniqueCharacter {

    private int getFirstUniqueCharIndex(String s) {
        int[] count = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter obj = new FirstUniqueCharacter();
        System.out.println(obj.getFirstUniqueCharIndex("leetcode"));
        System.out.println(obj.getFirstUniqueCharIndex("loveleetcode"));
        System.out.println(obj.getFirstUniqueCharIndex("aabbcc"));
        System.out.println(obj.getFirstUniqueCharIndex("aabbcc"));
    }
}
