package leetcode;

import dsa.linkedlist.ListNode;

public class LC0237_DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
