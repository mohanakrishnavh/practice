package leetcode;

import dsa.linkedlist.ListNode;

public class LC0237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
