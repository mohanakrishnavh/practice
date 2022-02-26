package leetcode;

import dsa.linkedlist.ListNode;

public class LC0002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode sentinel = new ListNode(-1);
        ListNode previous = sentinel;
        while (l1 != null || l2 != null || carry > 0) {
            int number1 = l1 != null ? l1.value : 0;
            int number2 = l2 != null ? l2.value : 0;
            int sum = number1 + number2 + carry;
            int val = sum % 10;
            carry = sum/10;

            previous.next = new ListNode(val);
            previous = previous.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return sentinel.next;
    }
}
