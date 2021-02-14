package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ReArrangeWordsInASentence {
    public static String arrangeWords(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        String[] words = text.split(" ");
        TreeMap<Integer, List<String>> countMap = new TreeMap<>();

        for (String word : words) {
            countMap.computeIfAbsent(word.length(), x -> new ArrayList<>()).add(word.toLowerCase());
        }

        StringBuilder sb = new StringBuilder();
        for (List<String> wordList : countMap.values()) {
            for (String word : wordList) {
                sb.append(word + " ");
            }
        }

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(ReArrangeWordsInASentence.arrangeWords("Leetcode is cool"));
        System.out.println(ReArrangeWordsInASentence.arrangeWords("Keep calm and code on"));
        System.out.println(ReArrangeWordsInASentence.arrangeWords("To be or not to be"));
    }
}
