package leetcode;

import dsa.linkedlist.ListNode;

public class LC0206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHeadNode = reverseList(head.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = null;

        return newHeadNode;
    }
}
