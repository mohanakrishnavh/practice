package dsa.linkedlist;

public class DeleteMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slowPointer = head, fastPointer = head;
        ListNode previous = null;

        while (fastPointer != null && fastPointer.next != null) {
            previous = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        previous.next = slowPointer.next;

        return head;
    }
}
