package interview.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class GiftingGroups {
    public int findCirclesCount(int[][] M) {
        int count = 0;
        int[] visited = new int[M.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while(!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j=0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GiftingGroups obj = new GiftingGroups();

        int[][] M1 = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(obj.findCirclesCount(M1));

        int[][] M2 = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(obj.findCirclesCount(M2));
    }
}
