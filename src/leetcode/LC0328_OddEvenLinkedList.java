package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 328: Odd Even Linked List
 * Difficulty: Medium
 * 
 * <p>Group all odd nodes together followed by even nodes.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = null, oddTail = null, evenHead = null, evenTail = null;
        ListNode current = head;
        boolean isOdd = true;
        while (current != null) {
            if (isOdd) {
                if (oddHead == null) {
                    oddHead = current;
                } else {
                    oddTail.next = current;
                }
                oddTail = current;
            } else {
                if (evenHead == null) {
                    evenHead = current;
                } else {
                    evenTail.next = current;
                }
                evenTail = current;
            }

            isOdd = !isOdd;
            current = current.next;
        }

        evenTail.next = null;
        oddTail.next = evenHead;

        return oddHead;
    }
}
