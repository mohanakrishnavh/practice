package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    List<List<Integer>> adjacacencyList;
    boolean[] visited;

    public Graph(int size) {
        adjacacencyList = new ArrayList<>();
        visited = new boolean[size];

        for (int i = 0; i < size; i++) {
            adjacacencyList.add(i, new ArrayList<>());
        }
    }

    public void addUndirectedEdge(int a, int b) {
        adjacacencyList.get(a).add(b);
        adjacacencyList.get(b).add(a);
    }

    public void addDirectedEdge(int a, int b) {
        adjacacencyList.get(a).add(b);
    }

    public List<Integer> breadthFirstTraversal(int startIndex) {
        List<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        visited[startIndex] = true;
        bfsTraversal.add(startIndex);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> children = adjacacencyList.get(node);

            for (Integer child : children) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                    bfsTraversal.add(child);
                }
            }
        }

        return bfsTraversal;
    }

    public List<Integer> depthFirstTraversal(int startIndex) {
        List<Integer> dfsTraversal = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);
        visited[startIndex] = true;

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            dfsTraversal.add(node);

            List<Integer> children = adjacacencyList.get(node);
            for (Integer child : children) {
                if (!visited[child]) {
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }

        return dfsTraversal;
    }
}
