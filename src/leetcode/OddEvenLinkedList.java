package leetcode;

import dsa.linkedlist.LinkedList;
import dsa.linkedlist.ListNode;

public class OddEvenLinkedList {
    public static ListNode getOddEvenLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead, oddHead, evenTail, oddTail;
        evenHead = oddHead = evenTail = oddTail = null;

        int position = 1;
        ListNode current = head;
        while (current != null) {
            if (position % 2 != 0) {
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else {
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }

            current = current.next;
            position++;
        }

        oddTail.next = evenHead;

        if (evenTail != null) {
            evenTail.next = null;
        }

        return oddHead;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        ListNode head = list.getHead();

        OddEvenLinkedList.getOddEvenLinkedList(head);

    }
}
