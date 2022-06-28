package dsa.recursion.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static List<Integer> subsetSums(int[] arr){
        ArrayList<Integer> sums = new ArrayList<>();
        findSubsetSums(0, 0, arr, sums);
        Collections.sort(sums);

        return sums;
    }

    private static void findSubsetSums(int index, int sum, int[] arr, List<Integer> sums) {
        if (arr.length == index) {
            sums.add(sum);
            return;
        }

        // Pick the index element
        findSubsetSums(index + 1, sum + arr[index], arr, sums);

        // Do not pick the index element
        findSubsetSums(index + 1, sum, arr, sums);
    }

    public static void main(String[] args) {
        System.out.println(subsetSums(new int[]{2, 3}));
        System.out.println(subsetSums(new int[]{3, 1, 2}));
    }
}
