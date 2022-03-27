package leetcode;

import dsa.linkedlist.ListNode;

public class LC0019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode slow = sentinel;
        ListNode fast = head;

        // Moving the fast pointer by N steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Maintaining the distance N between the slow and fast pointer
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return sentinel.next;
    }
}
