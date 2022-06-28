package leetcode;

public class LC0779_KthSymbolInGrammar {
    /*
    N = 0, Pattern: 0
    N = 1, Pattern: 0 1
    N = 2, Pattern: 0 1 1 0
    N = 3, Pattern: 0 1 1 0 1 0 0 1
    N = 4, Pattern: 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
    */
    public int kthGrammar(int n, int k) {
        if (n == 1 && k == 1) {
            return 0;
        }

        int mid = (int)Math.pow(2, n-1)/2;

        if (k <= mid) {
            // The first half follows the same pattern as the previous row
            return kthGrammar(n - 1, k);
        } else {
            // The second half is a complement of the pattern from the previous row
            return kthGrammar(n - 1, k - mid) == 0 ? 1 : 0;
        }
    }
}
