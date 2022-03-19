package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    List<List<Integer>> adjacacencyList;
    boolean[] visited;
    int size;

    public Graph(int size) {
        this.size = size;
        this.adjacacencyList = new ArrayList<>();
        this.visited = new boolean[this.size];

        for (int i = 0; i < size; i++) {
            adjacacencyList.add(i, new ArrayList<>());
        }
    }

    public void addUndirectedEdges(int[][] edgeList) {
        for (int[] edge : edgeList) {
            addUndirectedEdge(edge[0], edge[1]);
        }
    }

    public void addUndirectedEdge(int a, int b) {
        adjacacencyList.get(a).add(b);
        adjacacencyList.get(b).add(a);
    }

    public void addDirectedEdges(int[][] edgeList) {
        for (int[] edge : edgeList) {
            addDirectedEdge(edge[0], edge[1]);
        }
    }

    public void addDirectedEdge(int a, int b) {
        adjacacencyList.get(a).add(b);
    }

    public void refreshVisited() {
        this.visited = new boolean[this.size];
    }

    public List<Integer> depthFirstTraversal(int start) {
        List<Integer> traversal = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            // Pop the vertex from the stack
            Integer node = stack.pop();

            // Visit the unvisited vertex, add it to output
            if (!visited[node]) {
                visited[node] = true;
                traversal.add(node);
            }

            // View the adjacency list and add the nodes that have not been visited to the stack
            List<Integer> children = adjacacencyList.get(node);
            for (Integer child : children) {
                if (!visited[child]) {
                    stack.push(child);
                }
            }
        }

        return traversal;
    }

    public List<Integer> breadthFirstTraversal(int start) {
        List<Integer> traversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            // Deque the node from the queue and add it output
            Integer node = queue.poll();

            // Visit the unvisited vertex, add it to output
            if (!visited[node]) {
                visited[node] = true;
                traversal.add(node);
            }

            List<Integer> children = adjacacencyList.get(node);
            for (Integer child : children) {
                if (!visited[child]) {
                    queue.add(child);
                }
            }
        }

        return traversal;
    }
}
