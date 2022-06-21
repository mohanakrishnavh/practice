package leetcode;

import dsa.linkedlist.ListNode;

public class LC0234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        // Find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        slow = reverse(slow);

        // Check if the list is a palindrome
        while (slow != null && slow.value == head.value) {
            slow = slow.next;
            head = head.next;
        }

        // If all the elements were equal, the slow pointer would have reached
        // the end of the list
        return slow == null;
    }

    // Helper to reverse the linked list
    public ListNode reverse(ListNode head) {
        ListNode current = head, previous = null, next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
