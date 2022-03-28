package leetcode;

import dsa.linkedlist.ListNode;

public class LC0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode current = sentinel;
        int carry = 0, n1, n2;

        while (l1 != null || l2 != null || carry > 0) {
            n1 = 0;
            n2 = 0;

            if (l1 != null) {
                n1 = l1.value;
                l1 = l1.next;
            }

            if (l2 != null) {
                n2 = l2.value;
                l2 = l2.next;
            }

            int sum = n1 + n2 + carry;
            int nodeValue = sum % 10;
            carry = sum / 10;

            current.next = new ListNode(nodeValue);
            current = current.next;
        }

        return sentinel.next;
    }
}
