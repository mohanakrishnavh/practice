package demo;

import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String args[]) {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        System.out.println("Before Inserting elements:");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Adding the elements
        pQueue.add(40);
        pQueue.add(30);
        pQueue.add(20);
        pQueue.add(10);

        // Printing the most priority element
        System.out.println("Head value using peek function:" + pQueue.peek());

        // Printing all elements - Iterating doesn't guarantee the order
        System.out.println("The queue elements:");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Removing the top priority element (or head) and printing the modified pQueue using poll()
        pQueue.poll();
        System.out.println("The queue elements (after removing topmost element):");
        for (Integer integer : pQueue) {
            System.out.println(integer);
        }

        // Check if an element is present using contains()
        boolean b = pQueue.contains(30);
        System.out.println("Priority queue contains 20 or not?: " + b);

        Object[] pQElements = pQueue.toArray();
        for (Object pQElement : pQElements) {
            System.out.println(pQElement);
        }
    }
}
