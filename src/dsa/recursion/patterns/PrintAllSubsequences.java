package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * PrintAllSubsequences
 *
 * <p>Prints every subsequence (2^n of them, including the empty one) of an array.
 *
 * <p><b>Pattern: pick / not-pick.</b> At each index make two choices — include the element or skip it —
 * and recurse. When {@code index == arr.length} the current {@code subsequence} is a complete answer.
 * The "undo" step ({@code remove}) after the first branch is the <i>backtracking</i> that restores
 * shared state before exploring the second branch.
 *
 * <p><b>Complexity:</b> Time O(2^n * n) (printing each subsequence costs O(n)), Space O(n) recursion depth.
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class PrintAllSubsequences {
    public static void printSubsequences(int[] arr, int index, List<Integer> subsequence) {
        // Base case: a decision has been made for every element
        if (index == arr.length) {
            System.out.println(subsequence);
            return;
        }

        // Choice 1: take arr[index]
        subsequence.add(arr[index]);
        printSubsequences(arr, index + 1, subsequence);

        // Backtrack: undo the choice so the "not take" branch starts from the same state
        subsequence.remove(subsequence.size() - 1);

        // Choice 2: skip arr[index]
        printSubsequences(arr, index + 1, subsequence);
    }

    public static void main(String[] args) {
        printSubsequences(new int[]{3, 1, 2}, 0, new ArrayList<>());
    }
}
