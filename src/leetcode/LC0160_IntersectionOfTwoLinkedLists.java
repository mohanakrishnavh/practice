package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 160: Intersection of Two Linked Lists
 * Difficulty: Easy
 * 
 * <p>Find the node where two linked lists intersect.
 * 
 * <p>Time Complexity: O(?) - TODO: Analyze complexity
 * <p>Space Complexity: O(?) - TODO: Analyze complexity
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0, lengthB = 0;
        ListNode tempA, tempB;

        // Calculating the length of list A
        tempA = headA;
        while (tempA.next != null) {
            lengthA += 1;
            tempA = tempA.next;
        }

        // Calculating the length of list B
        tempB = headB;
        while (tempB.next != null) {
            lengthB += 1;
            tempB = tempB.next;
        }

        // If the last node of the two lists is not the same, the lists don't intersect
        if (tempA != tempB) {
            return null;
        }

        int difference = Math.abs(lengthA - lengthB);
        // Assigning the larger list to tempA and smaller list to tempB
        if (lengthA > lengthB) {
            tempA = headA;
            tempB = headB;
        } else {
            tempB = headA;
            tempA = headB;
        }

        // Giving the pointer to the list A a head start by the difference
        // in the length of the lists
        while (difference > 0) {
            tempA = tempA.next;
            difference--;
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}
