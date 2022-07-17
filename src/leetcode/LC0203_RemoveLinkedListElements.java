package leetcode;

import dsa.linkedlist.ListNode;

public class LC0203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int value) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode current = head, previous = sentinel;
        while (current != null) {
            if (current.val == value) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return sentinel.next;
    }
}
