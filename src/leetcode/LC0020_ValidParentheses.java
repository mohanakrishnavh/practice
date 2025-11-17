package leetcode;

import java.util.Stack;

/**
 * LeetCode Problem 20: Valid Parentheses
 * Difficulty: Easy
 * 
 * <p>Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * <p>An input string is valid if:
 * <ol>
 *   <li>Open brackets must be closed by the same type of brackets</li>
 *   <li>Open brackets must be closed in the correct order</li>
 *   <li>Every close bracket has a corresponding open bracket of the same type</li>
 * </ol>
 * 
 * <p>Example 1:
 * <pre>
 * Input: s = "()"
 * Output: true
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: s = "()[]{}"
 * Output: true
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: s = "(]"
 * Output: false
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>1 <= s.length <= 10^4</li>
 *   <li>s consists of parentheses only '()[]{}'</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the length of the string
 * <p>Space Complexity: O(n) for the stack in worst case
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0020_ValidParentheses {
    
    /**
     * Checks if an opening bracket matches a closing bracket.
     * 
     * @param open  the opening bracket character ('(', '{', or '[')
     * @param close the closing bracket character (')', '}', or ']')
     * @return true if the brackets form a valid pair, false otherwise
     */
    private boolean isPair(char open, char close) {
        return open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']';
    }

    /**
     * Determines if the given string has valid bracket matching.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Use a stack to track opening brackets</li>
     *   <li>For each character in the string:
     *     <ul>
     *       <li>If it's an opening bracket, push it onto the stack</li>
     *       <li>If it's a closing bracket:
     *         <ul>
     *           <li>Check if stack is empty (no matching opening bracket) - return false</li>
     *           <li>Check if top of stack matches this closing bracket</li>
     *           <li>If matches, pop from stack; if not, return false</li>
     *         </ul>
     *       </li>
     *     </ul>
     *   </li>
     *   <li>After processing all characters, stack should be empty (all brackets matched)</li>
     * </ol>
     * 
     * <p>Key insight: Stack naturally handles the "last opened, first closed" property
     * of valid bracket sequences.
     * 
     * @param s the input string containing only bracket characters
     * @return true if all brackets are properly matched and nested, false otherwise
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || !isPair(stack.peek(), ch)) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
