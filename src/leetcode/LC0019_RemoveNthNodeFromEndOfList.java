package leetcode;

import dsa.linkedlist.ListNode;

public class LC0019_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return sentinel.next;
    }
}
