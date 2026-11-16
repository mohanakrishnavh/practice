package dsa.linkedlist;

public class DoublyLinkedList {
    public class DoublyLinkedListNode {
        int val;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int val) {
            this.val = val;

        }
    }

    private DoublyLinkedListNode head;
    private int length;

    public DoublyLinkedList() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length || head == null) {
            return -1;
        }

        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.val;
    }

    public void addFirst(int val) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(val);

        if (head == null) {
            head = node;
            length += 1;
            return;
        }

        head.next = node;
        node.prev = head;
        head = node;
        length += 1;
    }

    public void addLast(int val) {
        if (head == null) {
            addFirst(val);
            return;
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(val);
        DoublyLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = node;
        node.prev = current;
        length += 1;
    }

    public void addAtIndex(int val, int index) {
        if (index < 0 || index > length) {
            return;
        }

        if (index == 0) {
            addFirst(val);
            return;
        }

        if (index == length) {
            addLast(val);
        }

        DoublyLinkedListNode node = new DoublyLinkedListNode(val);
        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DoublyLinkedListNode previous = current.prev;
        previous.next = node;
        node.prev = previous;
        node.next = current;
        current.prev = node;
        length += 1;
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index < 0 || index > length - 1) {
            return;
        }

        DoublyLinkedListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        DoublyLinkedListNode previous = current.prev;
        previous.next = current.next;
        length -= 1;
    }
}
