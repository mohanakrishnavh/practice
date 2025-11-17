package dsa.linkedlist;

/**
 * IntersectionOfTwoLinkedLists
 * 
 * <p>This class provides a solution to find the intersection node of two singly-linked lists.
 * If the two lists intersect, they share all nodes from the intersection point onwards.
 * The solution uses a two-pass approach to handle lists of different lengths.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * Finds the intersection node of two linked lists.
     * 
     * <p>The algorithm:
     * 1. Calculate the length of both lists and check if they share the same tail node
     * 2. If they don't share the same tail, they don't intersect (return null)
     * 3. If they do intersect, align the starting points by advancing the longer list
     * 4. Traverse both lists simultaneously until finding the intersection node
     * 
     * <p>Time Complexity: O(m + n) where m and n are the lengths of the two lists
     * <p>Space Complexity: O(1)
     * 
     * @param headA the head of the first linked list
     * @param headB the head of the second linked list
     * @return the intersection node, or null if the lists don't intersect
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }


        ListNode tempA = headA, tempB = headB;
        int lengthA = 1, lengthB = 1;
        while (tempA.next != null) {
            lengthA++;
            tempA = tempA.next;
        }

        while (tempB.next != null) {
            lengthB++;
            tempB = tempB.next;
        }

        // Case 1 : If the two lists do not intersect
        if (tempA != tempB) {
            return null;
        }

        // Case 2 : If the lists intersect
        // Initialize the starting point of temp lists
        if (lengthA > lengthB) {
            tempA = headA;
            tempB = headB;
        } else {
            tempA = headB;
            tempB = headA;
        }

        // Calculate the difference in lengths
        int diff = Math.abs(lengthA - lengthB);
        while (diff > 0) {
            tempA = tempA.next;
            diff--;
        }

        // Iterate through the list until the intersection
        // point is found
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}
