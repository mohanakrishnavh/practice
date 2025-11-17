package dsa.linkedlist;
/**
 * AddTwoNumbers
 * 
 * <p>This class provides a solution for adding two numbers represented as linked lists.
 * Each node contains a single digit and the digits are stored in reverse order.
 * For example, the number 342 is represented as 2 -> 4 -> 3.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class AddTwoNumbers {

    /**
     * Adds two numbers represented by linked lists where digits are stored in reverse order.
     * 
     * <p>This method traverses both linked lists simultaneously, adding corresponding digits
     * along with any carry from the previous addition. The result is returned as a new
     * linked list with digits also in reverse order.
     * 
     * <p>Time Complexity: O(max(m, n)) where m and n are the lengths of the two lists
     * <p>Space Complexity: O(max(m, n)) for the result list
     * 
     * @param l1 the first linked list representing a non-negative integer
     * @param l2 the second linked list representing a non-negative integer
     * @return a new linked list representing the sum of the two numbers
     * 
     * @example
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode sentinel = new ListNode();
        ListNode current = sentinel;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int val1 = 0, val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            int total = val1 + val2 + carry;
            carry = total / 10;
            current.next = new ListNode(total % 10);
            current = current.next;
        }

        return sentinel.next;
    }

}
