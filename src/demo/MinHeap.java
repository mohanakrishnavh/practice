package demo;

import java.util.PriorityQueue;

/**
 * Demonstrates the usage of Java's PriorityQueue as a Min Heap.
 * A min heap is a complete binary tree where each node is smaller than its children.
 * The PriorityQueue in Java implements a min heap by default.
 * 
 * <p>Key Operations:
 * <ul>
 *   <li>add(element) - O(log n) - Insert element</li>
 *   <li>peek() - O(1) - Get minimum element without removing</li>
 *   <li>poll() - O(log n) - Remove and return minimum element</li>
 *   <li>contains(element) - O(n) - Check if element exists</li>
 * </ul>
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MinHeap {
    
    /**
     * Main method demonstrating various PriorityQueue operations.
     * Shows insertion, retrieval, removal, and iteration operations.
     * 
     * <p><b>Note:</b> Iteration over a PriorityQueue does NOT guarantee
     * sorted order. Use poll() repeatedly to get elements in sorted order.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Creating empty priority queue (min heap by default)
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        System.out.println("Before Inserting elements:");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Adding elements - heap property maintained automatically
        pQueue.add(40);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(10);

        // Printing the most priority element (minimum)
        System.out.println("Head value using peek function: " + pQueue.peek());

        // Printing all elements - Iterating doesn't guarantee sorted order
        System.out.println("The queue elements:");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Removing the top priority element (minimum) using poll()
        pQueue.poll();
        System.out.println("The queue elements (after removing topmost element):");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Check if an element is present using contains()
        boolean b = pQueue.contains(30);
        System.out.println("Priority queue contains 30 or not?: " + b);

        // Convert to array
        Object[] pQElements = pQueue.toArray();
        System.out.println("Queue elements as array:");
        for (Object pQElement : pQElements) {
            System.out.println(pQElement);
        }
    }
}
