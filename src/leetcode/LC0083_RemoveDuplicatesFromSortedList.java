package leetcode;

import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 83: Remove Duplicates from Sorted List
 * Difficulty: Easy
 * 
 * <p>Given the head of a sorted linked list, delete all duplicates such that each element
 * appears only once. Return the linked list sorted as well.
 * 
 * <p>Example 1:
 * <pre>
 * Input: head = [1,1,2]
 * Output: [1,2]
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in the list is in the range [0, 300]</li>
 *   <li>-100 <= Node.val <= 100</li>
 *   <li>The list is guaranteed to be sorted in ascending order</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n) where n is the number of nodes in the list
 * <p>Space Complexity: O(1) - in-place modification
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0083_RemoveDuplicatesFromSortedList {
    
    /**
     * Removes duplicate values from a sorted linked list.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Traverse the list with a current pointer</li>
     *   <li>If current.val == current.next.val, skip the next node</li>
     *   <li>Otherwise, move to the next node</li>
     *   <li>Continue until we reach the end</li>
     * </ol>
     * 
     * <p>Since the list is sorted, all duplicates are adjacent, making this simple.
     * 
     * @param head the head of the sorted linked list
     * @return the head of the modified list with duplicates removed
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
