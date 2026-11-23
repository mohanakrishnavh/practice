package leetcode;

import dsa.linkedlist.LinkedList;
import dsa.linkedlist.ListNode;

/**
 * OddEvenLinkedList
 * 
 * Groups the odd-positioned nodes of a linked list together, followed by the even-positioned nodes.
 *
 * <p>Approach: Walk the list once, appending each node to either an odd or an even chain based
 * on its 1-based position, then link the end of the odd chain to the head of the even chain.
 *
 * <p>Time Complexity: O(n). Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class OddEvenLinkedList {
    /**
     * Reorders the list so odd-position nodes precede even-position nodes.
     *
     * @param head the head of the list
     * @return the head of the reordered list, or null if the list is empty
     */
    public static ListNode getOddEvenLinkedList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode evenHead, oddHead, evenTail, oddTail;
        evenHead = oddHead = evenTail = oddTail = null;

        int position = 1;
        ListNode current = head;
        while (current != null) {
            if (position % 2 != 0) {
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            } else {
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            }

            current = current.next;
            position++;
        }

        oddTail.next = evenHead;

        if (evenTail != null) {
            evenTail.next = null;
        }

        return oddHead;
    }

    /**
     * Demo driver with sample inputs.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        ListNode head = list.getHead();

        OddEvenLinkedList.getOddEvenLinkedList(head);

    }
}
