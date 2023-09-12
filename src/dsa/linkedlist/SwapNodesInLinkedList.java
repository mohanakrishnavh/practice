package dsa.linkedlist;

public class SwapNodesInLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head, firstNode, secondNode;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        firstNode = fast;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        secondNode = slow;

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

        return head;
    }
}
