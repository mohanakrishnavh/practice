package leetcode;

import dsa.linkedlist.ListNode;

public class LC0024_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode previous = sentinel;
        ListNode first, second;
        while (head != null && head.next != null) {
            first = head;
            second = head.next;

            previous.next = second;
            first.next = second.next;
            second.next = first;

            previous = first;
            head = first.next;
        }

        return sentinel.next;
    }
}
