package dsa.linkedlist;

import dsa.tree.Node;

/**
 * LinkedList
 * 
 * A singly linked list of ints, implemented from scratch using {@link ListNode}.
 *
 * <p>Supports adding at the front, end or a given index, removing by index, indexed access,
 * iterative and recursive reversal, and printing (forward or reverse via recursion). The list tracks
 * its {@code length} so index checks do not need a traversal.
 *
 * <p>Complexity: addFirst O(1); addLast, addAtIndex, remove and get O(n); reverse O(n).
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class LinkedList {

    ListNode head;

    int length;

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        head = null;
        length = 0;
    }

    /**
     * Recursively prints the values from {@code node} onwards on one line, followed by a newline.
     *
     * @param node first node to print (may be null)
     */
    public static void print(ListNode node) {
        if (node == null) {
            System.out.print("\n");
            return;
        }

        System.out.print(node.val + " ");
        print(node.next);
    }

    /**
     * Recursively prints the values from {@code node} onwards in reverse order, followed by a newline.
     *
     * @param node    first node of the list to print (may be null)
     * @param reverse flag selecting this overload; the value itself is only passed through
     */
    public static void print(ListNode node, boolean reverse) {
        if (node == null) {
            System.out.print("\n");
            return;
        }

        print(node.next, reverse);
        System.out.print(node.val + " ");
    }

    /**
     * Recursively reverses a linked list.
     *
     * @param head head of the list to reverse
     * @return the new head (the old tail), or {@code head} if the list has fewer than two nodes
     */
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return temp;
    }

    /**
     * Returns the value at the given index.
     *
     * @param index zero-based position
     * @return the value stored at {@code index}
     * @throws IndexOutOfBoundsException if the list is empty
     */
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

    /**
     * Inserts a value at the front of the list.
     *
     * @param value value to insert
     */
    public void addFirst(int value) {
        ListNode listNode = new ListNode(value);
        listNode.next = head;
        head = listNode;
        incrementLength();
    }

    /**
     * Appends a value to the end of the list.
     *
     * @param value value to append
     */
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

    /**
     * Inserts a value at the given index, shifting later elements towards the end.
     *
     * @param value value to insert
     * @param index zero-based position in the range 0 to {@code length}
     * @throws IndexOutOfBoundsException if {@code index} is negative or greater than the length
     */
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

    /**
     * Removes the node at the given index.
     *
     * @param index zero-based position of the node to remove
     * @throws IndexOutOfBoundsException if {@code index} is negative or greater than the length
     */
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

    /**
     * Reverses this list in place iteratively by re-pointing each node's {@code next} reference.
     */
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

    /**
     * Prepends all values so the list ends up in the same order as the array.
     *
     * @param nums values to add
     */
    public void addAll(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            addFirst(nums[i]);
        }
    }

    /**
     * Prints this list's values on one line separated by spaces.
     */
    public void print() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * Returns the head of the list.
     *
     * @return the first node, or null if the list is empty
     */
    public ListNode getHead() {
        return this.head;
    }

    /**
     * Creates a new node holding the given value.
     *
     * @param value value for the node
     * @return the new node
     */
    private ListNode getNewListNode(int value) {
        return new ListNode(value);
    }

    /**
     * Increments the stored length by one.
     */
    private void incrementLength() {
        length += 1;
    }

    /**
     * Decrements the stored length by one.
     */
    private void decrementLength() {
        length -= 1;
    }
}
