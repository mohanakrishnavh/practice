package dsa.linkedlist;

import dsa.tree.Node;

public class LinkedList {

    ListNode head;

    int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.print("\n");
            return;
        }

        System.out.print(listNode.val + " ");
        print(listNode.next);
    }

    public static void print(ListNode listNode, boolean reverse) {
        if (listNode == null) {
            System.out.print("\n");
            return;
        }

        print(listNode.next, reverse);
        System.out.print(listNode.val + " ");
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.val;
    }

    public void addFirst(int value) {
        ListNode listNode = new ListNode(value);
        listNode.next = head;
        head = listNode;
        incrementLength();
    }

    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        ListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new ListNode(value);
        incrementLength();
    }

    public void addAtIndex(int value, int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(value);
        } else {
            ListNode previousNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            ListNode currentNode = previousNode.next;

            ListNode listNode = getNewListNode(value);
            previousNode.next = listNode;
            listNode.next = currentNode;
            incrementLength();
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            ListNode previousNode = head;
            for (int i = 0; i < index - 1; i++) {
                previousNode = previousNode.next;
            }
            ListNode currentNode = previousNode.next;
            previousNode.next = currentNode.next;
        }

        decrementLength();
    }

    public void reverse() {
        ListNode current, prev, next;
        current = head;
        prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void addAll(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            addFirst(nums[i]);
        }
    }

    public void print() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public ListNode getHead() {
        return this.head;
    }

    private ListNode getNewListNode(int value) {
        return new ListNode(value);
    }

    private void incrementLength() {
        length += 1;
    }

    private void decrementLength() {
        length -= 1;
    }
}
