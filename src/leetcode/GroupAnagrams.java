package leetcode;

import java.util.*;

/**
 * LeetCode Problem 49: Group Anagrams
 * Difficulty: Medium
 * 
 * <p>Given an array of strings strs, group the anagrams together. You can return the answer
 * in any order.
 * 
 * <p>An Anagram is a word or phrase formed by rearranging the letters of a different word
 * or phrase, typically using all the original letters exactly once.
 * 
 * <p>Example 1:
 * <pre>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: strs = [""]
 * Output: [[""]]
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: strs = ["a"]
 * Output: [["a"]]
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= strs.length <= 10^4</li>
 *   <li>0 <= strs[i].length <= 100</li>
 *   <li>strs[i] consists of lowercase English letters</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n * k) where n is the number of strings and k is the max length
 * <p>Space Complexity: O(n * k) for storing all strings in the hashmap
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        System.out.println(obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    /**
     * Creates a map of character frequency vectors to list of words.
     * 
     * <p>For each word, creates a character frequency array of size 26 (for 'a'-'z').
     * Uses the hash code of this array as the key to group anagrams together.
     * 
     * @param words array of strings to process
     * @return map where keys are hash codes of frequency vectors and values are lists of anagrams
     */
    private Map<Integer, List<String>> getCountVectorWordMap(String[] words) {
        Map<Integer, List<String>> countVectorWordMap = new HashMap<>();
        for (String word : words) {
            int[] count = new int[26];
            Arrays.fill(count, 0);
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a']++;
            }

            int hashCode = Arrays.hashCode(count);
            if (!countVectorWordMap.containsKey(hashCode)) {
                countVectorWordMap.put(hashCode, new ArrayList<>());
            }
            countVectorWordMap.get(hashCode).add(word);
        }

        return countVectorWordMap;
    }

    /**
     * Groups anagrams together from the input array.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>For each word, compute a character frequency array (26 letters)</li>
     *   <li>Use the hash of this frequency array as a key</li>
     *   <li>Words with the same frequency array are anagrams</li>
     *   <li>Group all anagrams using the frequency hash as the key</li>
     * </ol>
     * 
     * @param words array of strings to group
     * @return list of lists where each inner list contains anagrams
     */
    public List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> groups = new ArrayList<>();
        if (words.length == 0) {
            return groups;
        }

        Map<Integer, List<String>> countVectorWordMap = getCountVectorWordMap(words);
        groups.addAll(countVectorWordMap.values());

        return groups;
    }
}
