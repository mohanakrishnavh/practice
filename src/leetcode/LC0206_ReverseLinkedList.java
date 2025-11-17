package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 206: Reverse Linked List
 * Difficulty: Easy
 * 
 * <p>Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * <p>Example 1:
 * <pre>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: head = [1,2]
 * Output: [2,1]
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: head = []
 * Output: []
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is in the range [0, 5000]</li>
 *   <li>-5000 <= Node.val <= 5000</li>
 * </ul>
 * 
 * <p>Follow up: A linked list can be reversed either iteratively or recursively.
 * Could you implement both?
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the list
 * <p>Space Complexity: O(1) for the iterative approach
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0206_ReverseLinkedList {
    
    /**
     * Reverses a singly linked list iteratively.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Initialize three pointers: current (starting at head), previous (null), and next</li>
     *   <li>Iterate through the list:
     *     <ul>
     *       <li>Store the next node before breaking the link</li>
     *       <li>Reverse the current node's pointer to point to previous</li>
     *       <li>Move previous and current one step forward</li>
     *     </ul>
     *   </li>
     *   <li>When current becomes null, previous will be the new head</li>
     * </ol>
     * 
     * <p>Visual representation:
     * <pre>
     * Original: 1 -> 2 -> 3 -> null
     * Step 1:   null <- 1   2 -> 3 -> null
     * Step 2:   null <- 1 <- 2   3 -> null
     * Step 3:   null <- 1 <- 2 <- 3
     * </pre>
     * 
     * @param head the head of the singly linked list to reverse
     * @return the new head of the reversed linked list, or null if the list was empty
     */
    public ListNode reverseList(ListNode head) {
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
