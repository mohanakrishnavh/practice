package leetcode;

import dsa.linkedlist.ListNode;

public class LC0160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int length1 = 0;
        while (temp1.next != null) {
            temp1 = temp1.next;
            length1 += 1;
        }

        ListNode temp2 = headB;
        int length2 = 0;
        while (temp2.next != null) {
            temp2 = temp2.next;
            length2 += 1;
        }

        if (temp1 != temp2) {
            return null;
        }

        int difference = Math.abs(length1 - length2);
        if (length1 > length2) {
            temp1 = headA;
            temp2 = headB;
        } else {
            temp1 = headB;
            temp2 = headA;
        }

        while (difference > 0) {
            temp1 = temp1.next;
            difference -= 1;
        }

        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }
}
