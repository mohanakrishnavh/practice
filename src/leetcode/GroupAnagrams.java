package leetcode;

import java.util.*;

public class GroupAnagrams {

    private Map<Integer, List<String>> getCountVectorWordMap(String[] words) {
        Map<Integer, List<String>> countVectorWordMap = new HashMap<>();
        for (String word : words) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for (int i=0; i<word.length(); i++) {
                count[word.charAt(i)-'a']++;
            }

            int hashCode = Arrays.hashCode(count);
            if (!countVectorWordMap.containsKey(hashCode)) {
                countVectorWordMap.put(hashCode, new ArrayList<>());
            }
            countVectorWordMap.get(hashCode).add(word);
        }

        return countVectorWordMap;
    }

    public List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> groups = new ArrayList<>();
        if (words.length == 0) {
            return groups;
        }

        Map<Integer, List<String>> countVectorWordMap = getCountVectorWordMap(words);
        groups.addAll(countVectorWordMap.values());

        return groups;
    }

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        System.out.println(obj.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}
