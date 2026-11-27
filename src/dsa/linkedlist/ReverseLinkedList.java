package dsa.linkedlist;

/**
 * ReverseLinkedList
 * 
 * <p>Given the head of a singly linked list, reverse the list and return the new head.
 *
 * <p><b>Idea:</b> walk the list once and turn each {@code next} pointer around so it points to the
 * node before it. Three pointers are enough: {@code previous} (the reversed part so far),
 * {@code current} (the node being flipped) and {@code next} (saved first, because flipping
 * {@code current.next} would otherwise lose the rest of the list). When {@code current} runs off
 * the end, {@code previous} is the old tail, which is the new head. The nodes are reused, so no new
 * list is built.
 *
 * <p>Time complexity: O(n). Space complexity: O(1).
 *
 * <p>Example: 1 -&gt; 2 -&gt; 3 -&gt; 4 -&gt; 5 becomes 5 -&gt; 4 -&gt; 3 -&gt; 2 -&gt; 1. An empty list
 * stays empty, and a single node is returned unchanged.
 *
 * @see ListNode
 *
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReverseLinkedList {
    /**
     * Reverses a singly linked list iteratively, in place.
     *
     * <p>Steps:
     * <ol>
     *   <li>Start with {@code previous = null} and {@code current = head}.</li>
     *   <li>Save {@code current.next} in {@code next} before it is overwritten.</li>
     *   <li>Point {@code current.next} back at {@code previous}.</li>
     *   <li>Move {@code previous} and {@code current} one node forward.</li>
     *   <li>When {@code current} is {@code null}, {@code previous} is the new head.</li>
     * </ol>
     * An empty list skips the loop and returns {@code null}; a single node is pointed at
     * {@code null} and returned as is.
     *
     * <p>Time Complexity: O(n) where n is the number of nodes
     * <p>Space Complexity: O(1)
     *
     * @param head the head of the linked list to reverse; may be {@code null}
     * @return the head of the reversed list (the old tail), or {@code null} if the list is empty
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = head, previous = null, next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    /**
     * Test driver: empty list, single-node list and a regular list.
     *
     * @param args unused command-line arguments
     */
    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        // 0 elements: reversing an empty list gives an empty list
        ListNode result = solver.reverseList(null);
        System.out.println((result == null ? "PASS" : "FAIL") + " - empty list (expected null, got " + result + ")");

        // 1 element: the single node is its own reverse
        ListNode single = new ListNode(7);
        result = solver.reverseList(single);
        boolean ok = result == single && result.val == 7 && result.next == null;
        System.out.println((ok ? "PASS" : "FAIL") + " - single node [7]");

        // regular list: 1->2->3->4->5 becomes 5->4->3->2->1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        result = solver.reverseList(head);

        StringBuilder got = new StringBuilder();
        for (ListNode node = result; node != null; node = node.next) {
            got.append(node.val).append(node.next != null ? "->" : "");
        }
        String expected = "5->4->3->2->1";
        System.out.println((expected.contentEquals(got) ? "PASS" : "FAIL") + " - regular list (expected " + expected + ", got " + got + ")");
    }
}
