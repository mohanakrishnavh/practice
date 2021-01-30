package leetcode.linkedlist;

import dsa.linkedlist.ListNode;

public class RemoveNthFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode forward = sentinel;
        for (int i=0; i<n; i++){
            forward = forward.next;
        }

        ListNode current = sentinel;
        ListNode previous = null;
        while(forward != null) {
            previous = current;
            current = current.next;
            forward = forward.next;
        }

        previous.next = current.next;

        return sentinel.next;
    }
}
