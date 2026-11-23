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
    /**
     * Prints every subsequence of {@code arr} using pick / not-pick recursion.
     *
     * @param arr         the source array
     * @param index       the element currently being decided; start with 0
     * @param subsequence the elements picked so far (mutated and restored while backtracking); start empty
     */
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
        subsequence.removeLast();

        // Choice 2: skip arr[index]
        printSubsequences(arr, index + 1, subsequence);
    }

    /**
     * Demo: prints all subsequences for a few inputs, including the empty and single-element arrays.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        System.out.println("[3, 1, 2]:");  // 8 subsequences, from [3, 1, 2] down to []
        printSubsequences(new int[]{3, 1, 2}, 0, new ArrayList<>());

        System.out.println("[]:");         // just the empty subsequence: []
        printSubsequences(new int[]{}, 0, new ArrayList<>());

        System.out.println("[7]:");        // [7] and []
        printSubsequences(new int[]{7}, 0, new ArrayList<>());

        System.out.println("[1, 1]:");     // duplicates are NOT merged: [1, 1], [1], [1], []
        printSubsequences(new int[]{1, 1}, 0, new ArrayList<>());
    }
}
