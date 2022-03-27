package leetcode;

import dsa.linkedlist.LinkedList;
import dsa.linkedlist.ListNode;

public class LC0876_MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addAll(new int[]{1, 2, 3, 4, 5});
        ListNode middle1 = middleNode(list1.getHead());
        LinkedList.print(middle1);

        LinkedList list2 = new LinkedList();
        list2.addAll(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middle2 = middleNode(list2.getHead());
        LinkedList.print(middle2);
    }

}
