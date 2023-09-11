package dsa.linkedlist;

public class IntersectionOfTwoLinkedLists {

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
