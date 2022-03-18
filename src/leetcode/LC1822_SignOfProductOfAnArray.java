package leetcode;

public class LC1822_SignOfProductOfAnArray {
    public int arraySign(int[] nums) {
        boolean isZero = false;
        boolean isNegative = false;
        for (int num : nums) {
            if (num == 0)  {
                isZero = true;
            } else if (num < 0) {
                isNegative = !isNegative;
            }
        }

        return isZero ? 0 : (isNegative ? -1 : 1);
    }
}
