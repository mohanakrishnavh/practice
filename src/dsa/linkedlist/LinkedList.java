package dsa.linkedlist;

public class LinkedList {

    ListNode head;

    int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }

        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode.value;
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
            for (int i = 0; i < index-1; i++) {
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
            for (int i = 0; i < index-1; i++) {
                previousNode = previousNode.next;
            }
            ListNode currentNode = previousNode.next;
            previousNode.next = currentNode.next;
        }

        decrementLength();
    }

    public void reverse() {
        ListNode currentNode, previousNode, nextNode;
        currentNode = head;
        previousNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
    }

    public void addAll(int[] nums) {
        for (int i=nums.length-1; i >=0; i--) {
            addFirst(nums[i]);
        }
    }

    public void print() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.print("\n");
            return;
        }

        System.out.print(listNode.value + " ");
        print(listNode.next);
    }

    public static void print(ListNode listNode, boolean reverse) {
        if (listNode == null) {
            System.out.print("\n");
            return;
        }

        print(listNode.next, reverse);
        System.out.print(listNode.value + " ");
    }

    public static ListNode reverse(ListNode head) {
        return reverseHelper(head);
    }

    public static ListNode reverseHelper(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        ListNode head = reverseHelper(listNode.next);
        ListNode nextNode = listNode.next;
        nextNode.next = listNode;
        listNode.next = null;
        return head;
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
