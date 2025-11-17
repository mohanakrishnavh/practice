package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 234: Palindrome Linked List
 * Difficulty: Easy
 * 
 * <p>Given the head of a singly linked list, return true if it is a palindrome
 * or false otherwise.
 * 
 * <p>Example 1:
 * <pre>
 * Input: head = [1,2,2,1]
 * Output: true
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: head = [1,2]
 * Output: false
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is in the range [1, 10^5]</li>
 *   <li>0 <= Node.val <= 9</li>
 * </ul>
 * 
 * <p>Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * <p>Algorithm (O(n) time, O(1) space):
 * <ol>
 *   <li>Find the middle of the linked list using slow/fast pointers</li>
 *   <li>Reverse the second half of the list</li>
 *   <li>Compare the first half with the reversed second half</li>
 *   <li>If all values match, it's a palindrome</li>
 * </ol>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes
 * <p>Space Complexity: O(1) - no extra data structures used
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0234_PalindromeLinkedList {
    
    /**
     * Checks if the linked list is a palindrome.
     * 
     * <p>Uses the two-pointer technique to find the middle, then reverses
     * the second half and compares with the first half.
     * 
     * @param head the head of the singly linked list
     * @return true if the list is a palindrome, false otherwise
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
     * Reverses a linked list in place.
     * 
     * <p>Uses the standard three-pointer technique to reverse links.
     * 
     * @param head the head of the list to reverse
     * @return the new head of the reversed list
     */
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
