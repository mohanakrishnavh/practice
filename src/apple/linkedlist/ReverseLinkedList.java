package apple.linkedlist;

import dsa.linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head, previous = null, next;
        while (current != null) {
            // Hold reference to the next element
            next = current.next;

            // Reverse the pointers
            current.next = previous;

            // Update the moving pointers
            previous = current;
            current = next;
        }

        return previous;
    }
}
