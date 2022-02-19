package dsa.linkedlist;

public class LinkedList {

    ListNode head;

    int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public ListNode getHead() {
        return this.head;
    }

    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    public void addFirst(int value) {
        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
        incrementLength();
    }

    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
            return;
        }

        ListNode current = head;
        for (int i = 0; i < length - 1; i++) {
            current = current.next;
        }

        current.next = new ListNode(val);
        incrementLength();
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(val);
        } else if (index == length) {
            addLast(val);
        } else {
            ListNode current = head;
            ListNode previous = null;
            for (int i = 0; i < index; i++) {
                previous = current;
                current = current.next;
            }

            ListNode newListNode = new ListNode(val);
            previous.next = newListNode;
            newListNode.next = current;
            length += 1;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head.next;
            ListNode previous = head;
            for (int i = 1; i < index; i++) {
                previous = current;
                current = current.next;
            }

            previous.next = current.next;
        }

        decrementLength();
    }

    private void incrementLength() {
        length += 1;
    }

    private void decrementLength() {
        length -= 1;
    }
}
