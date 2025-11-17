package dsa.recursion.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * PrintAllSubsequences
 * 
 * <p>TODO: Add class description
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PrintAllSubsequences {
    public static void printSubsequences(int[] arr, int index, List<Integer> subsequence) {
        if (index == arr.length) {
            System.out.println(subsequence);
            return;
        }

        subsequence.add(arr[index]);
        printSubsequences(arr, index + 1, subsequence);
        subsequence.remove(subsequence.size() - 1);
        printSubsequences(arr, index + 1, subsequence);
    }

    public static void main(String[] args) {
        printSubsequences(new int[]{3, 1, 2}, 0, new ArrayList<>());
    }
}
