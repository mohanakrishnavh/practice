package dsa.linkedlist;

/**
 * MergeTwoSortedLists
 * 
 * <p>This class provides a solution to merge two sorted linked lists into one sorted list.
 * The merge is done by splicing together the nodes of the two lists using a sentinel node
 * to simplify edge cases.
 * 
 * @author Practice Repository
 * @version 1.0
 */
public class MergeTwoSortedLists {
    /**
     * Merges two sorted linked lists into a single sorted linked list.
     * 
     * <p>Uses a sentinel (dummy) node to simplify the logic and avoid handling
     * special cases for the head. Compares nodes from both lists and appends
     * the smaller one to the result list.
     * 
     * <p>Time Complexity: O(m + n) where m and n are the lengths of the two lists
     * <p>Space Complexity: O(1) as we only rearrange pointers
     * 
     * @param list1 the head of the first sorted linked list
     * @param list2 the head of the second sorted linked list
     * @return the head of the merged sorted linked list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode sentinel = new ListNode(-1);
        ListNode previous = sentinel;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                previous.next = list1;
                list1 = list1.next;
            } else {
                previous.next = list2;
                list2 = list2.next;
            }

            previous = previous.next;
        }

        if (list1 != null) {
            previous.next = list1;
        }

        if (list2 != null) {
            previous.next = list2;
        }

        return sentinel.next;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addFirst(4);
        list1.addFirst(2);
        list1.addFirst(1);

        LinkedList list2 = new LinkedList();
        list2.addFirst(4);
        list2.addFirst(3);
        list2.addFirst(1);

        ListNode list3 = mergeTwoLists(list1.getHead(), list2.getHead());
        LinkedList.print(list3);
    }
}
