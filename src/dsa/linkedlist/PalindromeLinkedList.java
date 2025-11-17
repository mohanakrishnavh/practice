package dsa.linkedlist;

/**
 * PalindromeLinkedList
 * 
 * <p>This class provides a solution to check if a linked list is a palindrome.
 * A palindrome list reads the same forwards and backwards. The algorithm finds
 * the middle, reverses the second half, and compares both halves.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class PalindromeLinkedList {
    /**
     * Checks if the linked list is a palindrome.
     * 
     * <p>Algorithm:
     * 1. Use fast and slow pointers to find the middle of the list
     * 2. Reverse the second half of the list
     * 3. Compare the first half with the reversed second half
     * 4. If all values match, the list is a palindrome
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     * 
     * @param head the head of the linked list
     * @return true if the list is a palindrome, false otherwise
     * 
     * @example
     * Input: 1->2->2->1
     * Output: true
     */
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
        while (slow != null && slow.val == head.val) {
            slow = slow.next;
            head = head.next;
        }

        // If all the elements were equal, the slow pointer would have reached
        // the end of the list
        return slow == null;
    }

    /**
     * Reverses a linked list.
     * 
     * @param head the head of the linked list to reverse
     * @return the head of the reversed linked list
     */
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
