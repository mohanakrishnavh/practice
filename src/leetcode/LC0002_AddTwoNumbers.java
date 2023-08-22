package leetcode;

import dsa.linkedlist.ListNode;

public class LC0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode sentinel = new ListNode();
        ListNode current = sentinel;

        int sum, carry = 0;
        int val1, val2, nodeVal;
        while (l1 != null || l2 != null || carry > 0) {
            val1 = 0;
            val2 = 0;

            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            sum = val1 + val2 + carry;
            carry = sum / 10;
            nodeVal = sum % 10;

            current.next = new ListNode(nodeVal);
            current = current.next;
        }

        return sentinel.next;
    }
}
