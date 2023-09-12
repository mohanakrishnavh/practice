package dsa.linkedlist;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        // Step 1: Create deep copy of nodes and place it in the original list
        // The new node is inserted immediately after the original node
        Node current = head, next;
        while(current != null) {
            next = current.next;
            Node copy = new Node(current.val);
            current.next = copy;
            copy.next = next;

            current = current.next.next;
        }

        // Step2: Assign the random links for the copy nodes
        current = head;
        while(current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }

            current = current.next.next;
        }

        // Step3: Connect the next nodes for the copy and disconnect the
        // copy from the original list
        Node sentinel = new Node(-1);
        Node copy = sentinel;
        current = head;
        while(current != null) {
            // Next node of the original list
            next = current.next.next;

            // Add the new node in the copy list
            copy.next = current.next;
            copy = copy.next;

            // Restore the original list
            current.next = next;
            current = next;
        }

        return sentinel.next;
    }
}
