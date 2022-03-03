package leetcode;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class LC0707_DesignLinkedList {
    int length;
    ListNode head;
    public LC0707_DesignLinkedList() {
        head = null;
        length = 0;
    }

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     */
    public static void main(String[] args) {
        LC0707_DesignLinkedList list1 = new LC0707_DesignLinkedList();
        list1.addAtHead(7);
        list1.addAtHead(2);
        list1.addAtHead(1);
        list1.addAtIndex(3, 0);
        list1.deleteAtIndex(2);
        list1.addAtHead(6);
        list1.addAtTail(4);
        System.out.println(list1.get(4));
        list1.addAtHead(4);
        list1.addAtIndex(5, 0);
        list1.addAtHead(6);
        list1.print();
    }

    public int get(int index) {
        if (index < 0 || index > length - 1) {
            return -1;
        }

        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        if (head != null) {
            node.next = head;
        }

        head = node;
        length += 1;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        ListNode node = new ListNode(val);
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        length += 1;
    }

    public void deleteAtHead() {
        if (head == null) {
            return;
        }

        head = head.next;
        length -= 1;
    }

    public void deleteAtTail() {
        if (head == null) {
            return;
        }

        ListNode previous = null;
        ListNode current = head;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        length -= 1;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            return;
        }

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == length) {
            addAtTail(val);
            return;
        }

        ListNode node = new ListNode(val);
        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = node;
        node.next = current;
        length += 1;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }

        if (index == 0) {
            deleteAtHead();
            return;
        }

        if (index == length - 1) {
            deleteAtTail();
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        length -= 1;
    }

    public void print() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val + " ");
            current = current.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
