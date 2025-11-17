package dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LetterCominationOfPhoneNumber
 * 
 * <p>This class provides a solution to generate all possible letter combinations that
 * a phone number could represent based on the traditional phone keypad mapping (like T9).
 * Each digit from 2-9 maps to a set of letters. The solution uses an iterative approach
 * to build combinations by progressively combining letters from each digit.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LetterCominationOfPhoneNumber {

    /**
     * Generates all possible letter combinations for the given phone number digits.
     * 
     * <p>Uses an iterative approach where each digit's letters are combined with all
     * previously generated combinations. For example:
     * - digits = "23"
     * - i=0: combine("abc", [""]) → ["a", "b", "c"]
     * - i=1: combine("def", ["a", "b", "c"]) → ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     * 
     * <p>Time Complexity: O(4^n) where n is the number of digits (worst case when digits map to 4 letters)
     * <p>Space Complexity: O(4^n) for storing all combinations
     * 
     * @param digits a string containing digits from 2-9
     * @return a list of all possible letter combinations
     * 
     * @example
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
     */
    public static List<String> letterCombinations(String digits) {
        String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<String>();

        if (digits.length()==0) return result;

        result.add("");
        for (int i=0; i<digits.length(); i++)
            result = combine(digitletter[digits.charAt(i)-'0'],result);

        return result;
    }

    /**
     * Combines each letter from a digit's mapping with all existing combinations.
     * 
     * <p>For each letter in the digit's mapping and each existing combination,
     * creates a new combination by appending the letter to the existing string.
     * 
     * @param digit the string of letters mapped to a digit (e.g., "abc" for digit 2)
     * @param l the list of existing combinations
     * @return a new list with all combinations after adding the current digit's letters
     */
    public static List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<>();

        for (int i=0; i<digit.length(); i++)
            for (String x : l)
                result.add(x+digit.charAt(i));

        return result;
    }
}
