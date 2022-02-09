package interview.amazon;

import java.util.*;

public class ShoppingPairs {
    public static int getMinScore(int productNodes, int[] productsFrom, int[] productsTo) {
        if (productNodes < 3) {
            return -1;
        }


        int minScore = Integer.MAX_VALUE;


        return minScore;
    }

    public static void main(String[] args) {
        System.out.println(getMinScore(6, new int[]{1, 2, 2, 3, 4, 5}, new int[]{2, 4, 5, 5, 5, 6}));
    }

    class Graph {
        int numberOfVertices;
        Map<Integer, Set<Integer>> edges;
        int[] degree;

        public Graph(int numberOfVertices) {
            this.numberOfVertices = numberOfVertices;
            this.edges = new HashMap<>();
            this.degree = new int[numberOfVertices];
        }

        public void addEdge(int u, int v) {
            edges.put(u, edges.getOrDefault(u, new HashSet<>(Collections.singletonList(v))));
            edges.put(v, edges.getOrDefault(v, new HashSet<>(Collections.singletonList(u))));

            degree[u] += 1;
            degree[v] += 1;
        }

        public int getDegree(int u) {
            return degree[u];
        }
    }
}
