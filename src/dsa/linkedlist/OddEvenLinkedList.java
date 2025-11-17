package dsa.linkedlist;

/**
 * OddEvenLinkedList
 * 
 * <p>This class provides a solution to reorder a linked list by grouping all nodes
 * at odd positions together followed by nodes at even positions. The relative order
 * within odd and even groups is preserved. Position counting starts at 1.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class OddEvenLinkedList {
    /**
     * Reorders the linked list by grouping odd-positioned and even-positioned nodes.
     * 
     * <p>The algorithm maintains two separate lists (odd and even) while traversing
     * the original list. After traversal, the even list is appended to the end of
     * the odd list.
     * 
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1) as we only rearrange pointers
     * 
     * @param head the head of the linked list
     * @return the head of the reordered linked list
     * 
     * @example
     * Input: 1->2->3->4->5
     * Output: 1->3->5->2->4
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
