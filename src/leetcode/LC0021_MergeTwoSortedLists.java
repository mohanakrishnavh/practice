package leetcode;

import dsa.linkedlist.LinkedList;
import dsa.linkedlist.ListNode;

/**
 * LeetCode Problem 21: Merge Two Sorted Lists
 * Difficulty: Easy
 * 
 * <p>You are given the heads of two sorted linked lists list1 and list2.
 * 
 * <p>Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * <p>Return the head of the merged linked list.
 * 
 * <p>Example 1:
 * <pre>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * </pre>
 * 
 * <p>Example 2:
 * <pre>
 * Input: list1 = [], list2 = []
 * Output: []
 * </pre>
 * 
 * <p>Example 3:
 * <pre>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * </pre>
 * 
 * <p>Constraints:
 * <ul>
 *   <li>The number of nodes in both lists is in the range [0, 50]</li>
 *   <li>-100 <= Node.val <= 100</li>
 *   <li>Both list1 and list2 are sorted in non-decreasing order</li>
 * </ul>
 * 
 * <p>Time Complexity: O(n + m) where n and m are the lengths of the two lists
 * <p>Space Complexity: O(1) - only uses a constant amount of extra space
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class LC0021_MergeTwoSortedLists {
    
    /**
     * Merges two sorted linked lists into one sorted linked list.
     * 
     * <p>Algorithm:
     * <ol>
     *   <li>Handle edge cases: if either list is null, return the other list</li>
     *   <li>Create a sentinel node to simplify edge case handling</li>
     *   <li>Use two pointers to traverse both lists simultaneously</li>
     *   <li>At each step, append the smaller node to the result list</li>
     *   <li>After one list is exhausted, append the remainder of the other list</li>
     *   <li>Return sentinel.next (the actual head of the merged list)</li>
     * </ol>
     * 
     * <p>The sentinel node technique avoids special handling for the head node.
     * 
     * @param list1 the head of the first sorted linked list
     * @param list2 the head of the second sorted linked list
     * @return the head of the merged sorted linked list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode previous = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                previous.next = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                list2 = list2.next;
            }

            previous = previous.next;
        }

        if (list1 != null) {
            previous.next = list1;
        }

        if (list2 != null) {
            previous.next = list2;
        }

        return sentinel.next;
    }

    /**
     * Main method demonstrating the merge of two sorted linked lists.
     * 
     * <p>Test case:
     * <ul>
     *   <li>list1: 1 -> 2 -> 4</li>
     *   <li>list2: 1 -> 3 -> 4</li>
     *   <li>result: 1 -> 1 -> 2 -> 3 -> 4 -> 4</li>
     * </ul>
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addFirst(4);
        list1.addFirst(2);
        list1.addFirst(1);

        LinkedList list2 = new LinkedList();
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(1);

        ListNode list3 = mergeTwoLists(list1.getHead(), list2.getHead());
        LinkedList.print(list3);
    }
}
