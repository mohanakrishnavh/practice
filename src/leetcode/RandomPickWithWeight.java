package leetcode;

public class RandomPickWithWeight {
    int[] cumulativeSum;
    int totalSum;

    public RandomPickWithWeight(int[] w) {
        cumulativeSum = new int[w.length];
        totalSum = 0;
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            cumulativeSum[i] += totalSum;
        }
    }

    public static void main(String[] args) {
        RandomPickWithWeight random = new RandomPickWithWeight(new int[]{1, 2, 3});
        System.out.println(random.pickIndex());
    }

    public int pickIndex() {
        double target = Math.random() * totalSum;
        int start = 0;
        int end = cumulativeSum.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > cumulativeSum[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
