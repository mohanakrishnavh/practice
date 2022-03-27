package leetcode;

import dsa.linkedlist.ListNode;

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
